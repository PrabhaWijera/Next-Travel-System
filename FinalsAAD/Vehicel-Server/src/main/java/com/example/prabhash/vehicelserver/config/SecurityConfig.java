package com.example.prabhash.vehicelserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/**").hasAnyAuthority("A_HOTEL","A_PACKAGE","PACKAGE_DETAILS","A_VEHICLE")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}




//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfVkVISUNMRSIsInN1YiI6InZlaGkyMDAxIiwiaWF0IjoxNjk4MjE3ODY0LCJleHAiOjQ4NTE4MTc4NjR9.XdlpJELspG2kIHotbtx9WTmywt03QSV1qwoLigO6kKE