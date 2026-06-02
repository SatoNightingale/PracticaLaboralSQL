package com.satoshihans.practicalaboralsql.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

// import com.satoshihans.practicalaboralsql.autenticacion.LoginDTO;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper mapper;


    public UsuarioDTO add(UsuarioCreacionDTO dto) {
        Usuario nuevo = mapper.toNewEntity(dto);
        if(usuarioRepository.existsByNombre(dto.getNombre())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese nombre");
        }
        String passwordHashed = passwordEncoder.encode(dto.getContrasena());
        nuevo.setContrasena(passwordHashed);
        usuarioRepository.save(nuevo);
        return mapper.toDTO(nuevo);
    }

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream().map(
            (Usuario u) -> mapper.toDTO(u)).toList();
    }

    public UsuarioDTO getAsDto(Long id){
        return mapper.toDTO(usuarioRepository.findById(id).orElseThrow());
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id).orElseThrow();
    }
    
    public UsuarioDTO update(Long id, UsuarioDTO dto){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        Usuario actualizado = mapper.updateEntity(dto, usuario);
        Usuario guardado = usuarioRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long id){
        usuarioRepository.findById(id).orElseThrow(); // si no da error aqui, pues...
        usuarioRepository.deleteById(id);
    }

    // public Usuario getAutenticado(Long usuario_id){
    //     checkAutenticado(usuario_id);
    //     return usuarioRepository.findById(usuario_id).orElseThrow();
    // }

    // public UsuarioDTO autenticar(LoginDTO dto){
    //     Usuario usuario = usuarioRepository.findByNombreAndContrasena(dto.getNombre(), dto.getContrasena()).orElseThrow(() ->
    //         new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas")
    //     );
        
    //     if(usuario.isAutenticado()){
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ya se encuentra autenticado");
    //     }
    //     usuario.setAutenticado(true);
    //     usuarioRepository.save(usuario);
    //     return mapper.toDTO(usuario);
    // }

    // public void desautenticar(Long usuario_id){
    //     Usuario usuario = usuarioRepository.findById(usuario_id).orElseThrow();
    //     if(!usuario.isAutenticado()){
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario no está autenticado");
    //     }
    //     usuario.setAutenticado(false);
    //     usuarioRepository.save(usuario);
    // }

    // public void checkAutenticado(Long usuario_id){
    //     if(!usuarioRepository.existsByIdAndAutenticadoTrue(usuario_id))
    //         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario no está autenticado");
    // }
}
