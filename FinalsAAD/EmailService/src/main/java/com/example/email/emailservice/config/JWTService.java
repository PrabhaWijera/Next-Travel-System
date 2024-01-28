package com.example.email.emailservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    private static final String SECRET_KEY = "khBfXWLgglDDWijP3yIMNRTVLCus5BoLD9lGlyXTgtaOG68G7YreTCG4qATj9hkDWFkK0ADUJAy5+QG3KAUKR0hzjxcVFEMwYc7XnPH7JUIL+kfAYcPzlo2iT9ZzcNVz3/SnbrEELQ5x/arqataa4W6cxv6QAvuaAVxDEun53SebHriEs1t+XmOz88S2DUEMu+9QuPX7N5J/mOjutgr6LGrnm6dc/eln8/gzc6h4owY3euerPoFs/LzT0os/LXtEtI55W1H5HaiNtmr1HbSRgPzuYMMWr+npDKFpYsbq+SIHLlEtocFQdYaagosgcdUIibie6eLe8s9aKrYrcvJTDXxgyWYNWYGWs8CZ4ClCDzE=";

    public String extractUsername(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    private Claims extractAllClaims(String jwtToken) {
        return Jwts.
                parserBuilder().
                setSigningKey(getSecretKey()) //Verifies the signature.
                .build().
                parseClaimsJws(jwtToken).
                getBody();
    }

    private Key getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);

    }
    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }
    public String generateToken(Map<String,Object> claims, UserDetails userDetails) {
        long expirationTimeInMilliseconds = System.currentTimeMillis() + 100L * 365L * 24L * 60L * 60L * 1000L; // 100 years

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expirationTimeInMilliseconds))
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }
    public boolean validateToken(String jwtToken, UserDetails userDetails) {
        final String username = extractUsername(jwtToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
    }

    private boolean isTokenExpired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractClaim(jwtToken, Claims::getExpiration);
    }

    public String getUserRole(String jwtToken){
        return extractAllClaims(jwtToken).get("userRole").toString();

    }

    public boolean validateToken(String jwtToken) {
        return !isTokenExpired(jwtToken);
    }

}
