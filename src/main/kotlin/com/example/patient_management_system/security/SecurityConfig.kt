package com.example.patient_management_system.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests {
                it.anyRequest().permitAll() // Allow all requests without authentication
            }
            .csrf { csrf -> csrf.disable() } // Disable CSRF for development (not recommended for production)
        return http.build()
    }
}