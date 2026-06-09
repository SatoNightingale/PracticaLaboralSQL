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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(username)
            .orElseThrow(() -> {
                return new UsernameNotFoundException("ID de usuario no encontrado: " + username);
            });
        return new UsuarioSecurity(usuario);
    }

    public UsuarioSecurity findById(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioSecurity(usuario);
    }
}
