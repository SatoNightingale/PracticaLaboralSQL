package com.satoshihans.practicalaboralsql.autenticacion;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
// La interfaz y la implementación de la clave secreta
import javax.crypto.SecretKey;

@Component
public class TokenProvider {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration}")
    private int jwtExpirationMs;

    /**
     * Este método convierte tu clave secreta (String) en un objeto
     * SecretKey que JJWT entiende. Es crucial para firmar y validar.
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = jwtSecret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Genera un token a partir del objeto Authentication de Spring Security.
     */
    public String generateToken(Authentication authentication) {
        UsuarioSecurity userPrincipal = (UsuarioSecurity) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        // Así es como se construye un token con la nueva API
        return Jwts.builder()
                .subject(userPrincipal.getId().toString()) // El "subject" es el ID del usuario
                .issuedAt(now)                            // Fecha de emisión
                .expiration(expiryDate)                   // Fecha de expiración
                .signWith(getSigningKey(), Jwts.SIG.HS512) // Algoritmo para firmarlo
                .compact();
    }

    /**
     * Obtiene el ID del usuario desde el token.
     */
    public Long getUserIdFromToken(String token) {
        String userId = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject(); // Aquí recuperamos el ID que guardamos en .subject()

        return Long.parseLong(userId);
    }

    // Devolver un decoder para el SecurityConfig
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder
            .withSecretKey(getSigningKey())
            .macAlgorithm(MacAlgorithm.HS512)
            .build();
    }

    /**
     * Valida un token (que no esté expirado, que la firma sea correcta...)
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            // Aquí podrías loguear el error si quieres
            return false;
        }
    }
}