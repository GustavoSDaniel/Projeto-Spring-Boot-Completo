package dev.gustavosdaniel.projetospringboot.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;


public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // CHAVE PARA FAZER A CRIPTOGRAFIA
    private static final long EXPIRATION_TIME = 86400000; // ISSO É IGUYAL A 1 DIA PARA EXPIRAR O TOKEN

    public static String generateToken(String userName) {

        return Jwts.builder().setSubject(userName).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key, SignatureAlgorithm.HS256).compact();
        // ESSE COMANDO VAI FAZER O TOKEN PARA NOIS
    }

    public static String extractUserName(String token) { // EXTRAINDO USUARIO
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token).getBody().getSubject();
    }

    public static boolean validateToken(String token) { // VALIDANDO TOKEN
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token);
            return true;
        }
        catch (JwtException e) {
            return false;
        }
    }
}
