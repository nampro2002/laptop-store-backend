package com.example.backendspringboot.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.backendspringboot.model.userDetails.MyUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenProvider {
    // private final String JWT_SECRET = "duc_anh_2002";
    // private final long JWT_EXPIRATION = 604800000L;

    @Value("${bezkoder.app.jwtSecret}")
    private String JWT_SECRET;

    @Value("${bezkoder.app.jwtExpirationMs}")
    private long JWT_EXPIRATION;

    public String generateToken( Authentication authentication) {
        MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Map<String, Object> claims = new HashMap<>();
        // System.out.println(user.getAuthorities());
        // TokenPayload tokenPayload =
        // TokenPayload.builder().userId(user.getUser().getId())
        // .authorities(user.getAuthorities().stream().toList()).build();
        // claims.put("payload", tokenPayload);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getAuthorities().toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    public Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            // LOGGER.error("Could not get all claims Token from passed token");
            claims = null;
        }
        return claims;
    }

}