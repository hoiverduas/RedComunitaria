package com.talentoTechGrupo3.redComunitaria.controller;

import com.talentoTechGrupo3.redComunitaria.entity.User;
import com.talentoTechGrupo3.redComunitaria.service.imple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
       return ResponseEntity
               .status(HttpStatus.OK)
               .body(this.userService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userService.updateUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id){
        this.userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
