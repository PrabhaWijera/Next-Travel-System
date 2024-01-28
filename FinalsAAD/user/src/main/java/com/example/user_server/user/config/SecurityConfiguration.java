package com.example.user_server.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Autowired
    private JWTAuthFilter jwtAuthFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/v1/auth/getAuth","api/v1/userApi").permitAll()
                .requestMatchers("/**").hasAnyAuthority("user",  "packageDetailsAdmin", "paymentsAdmin","A_HOTEL","A_GUIDE","AD_USER","A_VEHICLE")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
}
}
//nrmal user
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6Ik5PUk1BTF9DVVNUT01FUiIsInN1YiI6ImVtaWx5aiIsImlhdCI6MTY5ODIxODcyOCwiZXhwIjo0ODUxODE4NzI4fQ.pjv6B1h7F6T4WVXftA-tgpe3OAj3RWytKBucAE62_cU

//admin controller user
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFEX1VTRVIiLCJzdWIiOiJ1c2VyYWRtaW4yMDAxIiwiaWF0IjoxNjk4MjE4NDMyLCJleHAiOjQ4NTE4MTg0MzJ9.ojHdxgx9k3lJMdNwjYei4eNE2DPM7EWO9Ttjx2eJCog


