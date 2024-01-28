package com.example.user_server.user.api;

import com.example.user_server.user.config.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin
public class HandleRequests {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;



    @GetMapping(path = "/isAuthenticated",params = "jwtToken")
    public  boolean isAuthenticated( @RequestParam("jwtToken") String jwtToken){
        System.out.println("jwtToken = " + jwtToken);
        UserDetails user = userDetailsService.loadUserByUsername(jwtService.extractUsername(jwtToken));
        return jwtService.validateToken(jwtToken,user);


    }
}
