package com.example.prabhash.paymentserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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
                .requestMatchers("/**").hasAnyAuthority("packageAdmin","A_PAYMENT")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
/*@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
             .cors()
             .and()
             .csrf().disable()
             .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
             .authorizeRequests()
             .requestMatchers("/**").permitAll() // Accessible to everyone
             .requestMatchers("/**").hasAnyAuthority("USER","A_PAYMENT") // Requires ROLE_ADMIN authority
//                .antMatchers("/**").hasAuthority("PDA") // Requires ROLE_ADMIN authority
             .anyRequest().authenticated() // Any other request requires authentication
             .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
 }*/
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:63342"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
 //eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfUEFZTUVOVCIsInN1YiI6InBheTIwMDEiLCJpYXQiOjE2OTgyMTc0NjcsImV4cCI6NDg1MTgxNzQ2N30.d91AdCqnITrzGbsMPvQNr0vYLDtmBocuvcBnep9hC-A