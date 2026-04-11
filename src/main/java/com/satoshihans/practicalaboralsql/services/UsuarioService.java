package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.UsuarioAutenticacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.UsuarioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.UsuarioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Usuario;
import com.satoshihans.practicalaboralsql.models.mappers.UsuarioMapper;
import com.satoshihans.practicalaboralsql.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioMapper mapper;


    public Usuario add(UsuarioCreacionDTO dto) {
        Usuario nuevo = mapper.toNewEntity(dto);
        if(usuarioRepository.existsByNombre(dto.getNombre())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese nombre");
        }
        usuarioRepository.save(nuevo);
        return nuevo;
    }

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream().map(
            (Usuario u) -> mapper.toDTO(u)).toList();
    }

    public UsuarioDTO getAsDto(Long id){
        return mapper.toDTO(getById(id));
    }
    
    public UsuarioDTO update(Long id, UsuarioDTO dto){
        Usuario usuario = getById(id);
        Usuario actualizado = mapper.updateEntity(dto, usuario);
        Usuario guardado = usuarioRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long id){
        getById(id); // si no da error aqui, pues...
        usuarioRepository.deleteById(id);
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UsuarioDTO autenticar(UsuarioAutenticacionDTO dto){
        Usuario usuario = usuarioRepository.findByNombreAndContrasena(dto.getNombre(), dto.getContrasena()).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas")
        );
        
        return mapper.toDTO(usuario);
    }
}
