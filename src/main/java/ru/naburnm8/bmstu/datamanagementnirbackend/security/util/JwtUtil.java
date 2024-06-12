package ru.naburnm8.bmstu.datamanagementnirbackend.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "svosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvosvozzsvosvosvosvosvosvosvosvosvosvosvo";
    private static final long EXPIRATION_TIME = 86400000;

    public static String generateToken(Users user){
        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).build().parseSignedClaims(token).getPayload();
    }
}
