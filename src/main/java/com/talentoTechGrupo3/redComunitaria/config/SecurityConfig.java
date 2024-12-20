package com.talentoTechGrupo3.redComunitaria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Permitir solicitudes preflight
                        .requestMatchers(HttpMethod.POST, "/auth/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/departments").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cities").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cities").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.POST, "/admins/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/entrepreneur/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/entrepreneurShip").permitAll()
                        .requestMatchers(HttpMethod.GET, "/entrepreneurShip").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/entrepreneurShip/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/publication").permitAll()
                        .requestMatchers(HttpMethod.GET, "/events").permitAll()
                        .requestMatchers(HttpMethod.POST, "/explorers").permitAll()
                        .requestMatchers(HttpMethod.GET, "/explorers/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/comment").permitAll()
                        .requestMatchers(HttpMethod.GET, "/comment").permitAll()
                        .requestMatchers(HttpMethod.GET, "/comment/").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/comment/").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/comment/").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }




    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
