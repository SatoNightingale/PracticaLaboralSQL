package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.UsuarioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Usuario;
import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;
import com.satoshihans.practicalaboralsql.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AdvanceMapper mapper;

    public Usuario add_usuario(UsuarioDTO dto) {
        Usuario nuevo = mapper.toEntity(dto);
        usuarioRepository.save(nuevo);
        return nuevo;
    }

    public List<UsuarioDTO> listar_usuarios() {
        return usuarioRepository.findAll().stream().map(
            (Usuario u) -> mapper.toDTO(u)).toList();
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
