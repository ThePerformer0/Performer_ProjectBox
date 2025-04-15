package com.projectbox.projectbox_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // on désactive CSRF pour permettre les requêtes POST depuis Postman
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll() );  // permet l'accès à toutes les routes sans authentification

        return http.build();
    }
}
