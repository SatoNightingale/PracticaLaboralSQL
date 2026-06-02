package com.satoshihans.practicalaboralsql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AuthTest {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Test
    void testPasswordEncoder() {
        String rawPassword = "admin123";
        
        // Cifrar la contraseña
        String encoded = passwordEncoder.encode(rawPassword);
        System.out.println("Hash generado: " + encoded);
        
        // Verificar que coincide
        boolean matches = passwordEncoder.matches(rawPassword, encoded);
        System.out.println("¿Verifica? " + matches);
        
        assertTrue(matches);
    }
}