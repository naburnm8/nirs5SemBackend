package ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.UserDetailsImplementation;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationMS}")
    private int jwtExpirationMS;

    public String generateJwtToken(Authentication authentication) {
        UserDetailsImplementation userPrincipal = (UserDetailsImplementation) authentication.getPrincipal();

        return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date()).setExpiration(new Date((new Date()).getTime() + jwtExpirationMS))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
