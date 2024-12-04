package com.talentoTechGrupo3.redComunitaria.users.controller;


import com.talentoTechGrupo3.redComunitaria.config.JwtUtil;
import com.talentoTechGrupo3.redComunitaria.users.dto.LoginDto;
import com.talentoTechGrupo3.redComunitaria.users.entities.Entrepreneur;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IEntrepreneurRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final IUserRepository userRepository;
    private final IEntrepreneurRepository entrepreneurRepository;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, IUserRepository userRepository, IEntrepreneurRepository entrepreneurRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.entrepreneurRepository = entrepreneurRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto loginDto) {
        // Autenticar al usuario
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        );

        Authentication authentication = this.authenticationManager.authenticate(login);
        System.out.println("authentication = " + authentication.isAuthenticated());
        System.out.println("authentication = " + authentication.getPrincipal());

        // Generación del token JWT
        String jwt = this.jwtUtil.create(loginDto.getEmail());

        // Recuperar los datos del usuario autenticado
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> userOptional = this.userRepository.findByEmail(loginDto.getEmail());
        User user = userOptional.get();

        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Usuario no encontrado"));
        } else if (user instanceof Entrepreneur ) {

            Entrepreneur entrepreneur = (Entrepreneur) user;
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwt);
            response.put("user", Map.of(
                    "id", entrepreneur.getId(),
                    "email", entrepreneur.getEmail(),
                    "username", entrepreneur.getUsername(),
                    "roles", entrepreneur.getRole(),
                    "fullName",entrepreneur.getFullName(),
                    "experience",entrepreneur.getExperience(),
                    "contact",entrepreneur.getContact(),
                    "specialty",entrepreneur.getSpecialty()
            ));

            return ResponseEntity.ok(response);
        }





        return null;
    }


}
