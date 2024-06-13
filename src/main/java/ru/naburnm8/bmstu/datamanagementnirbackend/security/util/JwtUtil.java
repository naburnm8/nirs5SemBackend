package ru.naburnm8.bmstu.datamanagementnirbackend.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "svosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvozzsvosvosvosvosvosvosvosvosvosvosvo";
    private final long EXPIRATION_TIME = 86400000;

    public String generateToken(Users user){
        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }

    public boolean validateToken(String token) {
        try{
        Jwts.parser().setSigningKey(SECRET_KEY).build().parseSignedClaims(token);
        return true;
        } catch (JwtException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
