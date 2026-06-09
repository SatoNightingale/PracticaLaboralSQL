package com.satoshihans.practicalaboralsql.autenticacion;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private TokenProvider tokenProvider;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
	
	@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        // ✅ Excluye las rutas de autenticación
        return path.startsWith("/api/auth/") ||
               path.startsWith("/swagger-ui") ||
               path.startsWith("/v3/api-docs") || 
			   path.startsWith("/api/auth/login") ||
			   path.startsWith("/api/usuarios/add");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        
        // 1. Obtener token del header
        String token = extractToken(request);
        
        // 2. Si hay token y es válido
        if (token != null && tokenProvider.validateToken(token)) {
            // 3. Extraer ID del usuario
            Long userId = tokenProvider.getUserIdFromToken(token);
            
            // 4. Cargar el usuario completo
            UserDetails userDetails = userDetailsService.findById(userId);
            
            // 5. Crear objeto de autenticación
            Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
            
            // 6. Guardarlo en el contexto (para que Spring sepa quién es)
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        
        // 7. Continuar con el request
        chain.doFilter(request, response);
    }
    
    private String extractToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if (bearer != null && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
