package com.satoshihans.practicalaboralsql.autenticacion;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.satoshihans.practicalaboralsql.usuario.Usuario;

import lombok.Data;

@Data
public class UsuarioSecurity implements UserDetails {
    
    private final Long id;
    private final String username;
    private final String password;
    // private final List<GrantedAuthority> authorities;
    
    // Constructor que toma tu entidad Usuario
    public UsuarioSecurity(Usuario usuario) {
        this.id = usuario.getId();
        this.username = usuario.getNombre();
        this.password = usuario.getContrasena();  // Ya debe estar cifrado con BCrypt
        // Por si voy a usar roles para controlar qué usuario puede hacer qué. Aunque aquí todo el que usa este programa es admin, así que meh
        // this.authorities = usuario.getRoles().stream()
        //     .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombre()))
		// 	.toList();
    }
    
    // Métodos requeridos por UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { 
        return Collections.emptyList(); 
    }
    
    @Override
    public boolean isAccountNonExpired() { return true; }
    
    @Override
    public boolean isAccountNonLocked() { return true; }
    
    @Override
    public boolean isCredentialsNonExpired() { return true; }
    
    // @Override
    // public boolean isEnabled() { return usuario.isActivo(); }  // Si tu entidad tiene ese campo
}
