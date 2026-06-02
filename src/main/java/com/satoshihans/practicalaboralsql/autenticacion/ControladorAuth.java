package com.satoshihans.practicalaboralsql.autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Autenticación", description = "Operaciones para autenticar usuarios")
@RestController
@RequestMapping("/api/auth")
public class ControladorAuth {

	@Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenProvider tokenProvider;

	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        
        try{
            // 1. Spring Security valida las credenciales
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    dto.getNombre(),
                    dto.getContrasena()
                )
            );
        
            // 2. Si llegamos aquí, las credenciales son correctas
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            // 3. Generar el token JWT
            String jwt = tokenProvider.generateToken(authentication);
            
            // 4. Obtener el usuario autenticado
            UsuarioSecurity userDetails = (UsuarioSecurity) authentication.getPrincipal();
            
            // 5. Devolver respuesta
            return ResponseEntity.ok(new RespuestaLoginDTO(
                jwt,
                userDetails.getId(),
                userDetails.getUsername()
            ));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(
                e.getMessage()
            );
        }
    }
}
