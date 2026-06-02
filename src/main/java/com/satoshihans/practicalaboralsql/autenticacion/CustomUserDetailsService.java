package com.satoshihans.practicalaboralsql.autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.usuario.Usuario;
import com.satoshihans.practicalaboralsql.usuario.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(nombre)
            .orElseThrow(() -> {
                return new UsernameNotFoundException("Usuario no encontrado: " + nombre);
            });
        return new UsuarioSecurity(usuario);
    }
}
