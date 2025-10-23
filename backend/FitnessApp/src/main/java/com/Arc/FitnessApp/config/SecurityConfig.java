package com.Arc.FitnessApp.config;


/* DISABLING SECURITY UNTIL I GET FURTHER IN DEVELOPMENT */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // 👈 Marks this as a configuration class (like an advanced settings file)
public class SecurityConfig {   // 👈 This is the class declaration

    @Bean   // 👈 Defines a Spring bean (a reusable object managed by Spring)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> {}) // Enables CORS handling
                .csrf(csrf -> csrf.disable())  // disable CSRF (for testing)
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // allow all requests
                .formLogin(form -> form.disable())  // disable login forms
                .httpBasic(basic -> basic.disable()); // disable basic auth
        return http.build();
    }
}