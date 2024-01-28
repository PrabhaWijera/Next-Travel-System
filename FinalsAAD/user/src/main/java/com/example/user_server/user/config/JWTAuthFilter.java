package com.example.user_server.user.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.io.IOException;

@Component
@RequiredArgsConstructor

public class JWTAuthFilter extends OncePerRequestFilter {
    public static String JWT_TOKEN;
    @Autowired
    private final HandlerExceptionResolver handlerExceptionResolver;
    @Autowired
    private JWTService JWTService;
    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        System.out.println("This is JWTAuthFilter." + request.getHeader("Authorization"));
        String authHeader = request.getHeader("Authorization");//Extracting the header.
        String jwtToken = null;
        String userName;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("No token found! - This is UA S.");
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7);
        JWT_TOKEN = jwtToken;


        try {
            userName = JWTService.extractUsername(jwtToken);
            System.out.println("Username : " + userName);
        } catch (Exception exception) {
            handlerExceptionResolver.resolveException(request, response, null, new RuntimeException("Invalid token : " + exception.getLocalizedMessage()));
            return;

        }
        //Checking of the username's not nullability  and the authentication status of the current user.
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = userDetailsService.loadUserByUsername(userName);
            System.out.println("User : " + user.toString());

            if (JWTService.validateToken(jwtToken, user) && JWTService.getUserRole(jwtToken).equals("user") || JWTService.getUserRole(jwtToken).equals("AD_USER") || JWTService.getUserRole(jwtToken).equals("packageDetailsAdmin") || JWTService.getUserRole(jwtToken).equals("paymentsAdmin") || JWTService.getUserRole(jwtToken).equals("A_GUIDE") || JWTService.getUserRole(jwtToken).equals("A_VEHICLE") || JWTService.getUserRole(jwtToken).equals("A_HOTEL")) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                System.out.println("auth status: " + authToken.isAuthenticated());
                System.out.println("Here is user role : " + JWTService.getUserRole(jwtToken));
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);


            }


        }
        filterChain.doFilter(request, response);


    }

}
