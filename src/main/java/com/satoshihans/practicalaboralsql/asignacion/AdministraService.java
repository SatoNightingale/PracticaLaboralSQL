package com.satoshihans.practicalaboralsql.asignacion;

import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.asignacion.dto.AdministraCreacionDTO;
import com.satoshihans.practicalaboralsql.asignacion.dto.AdministraCreacionDesdeLineaDeServiciosDTO;
import com.satoshihans.practicalaboralsql.especialista.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServicios;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServiciosRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.ServicioMapper;
import com.satoshihans.practicalaboralsql.usuario.UsuarioRepository;

@Service
public class AdministraService {

    private final AdministraRepository administraRepository;

    private final UsuarioRepository usuarioRepository;

    private final EspecialistaRepository especialistaRepository;

    private final LineaDeServiciosRepository lineaDeServiciosRepository;

    private final ServicioMapper mapper;

    
    AdministraService(AdministraRepository administraRepository, UsuarioRepository usuarioRepository, EspecialistaRepository especialistaRepository, LineaDeServiciosRepository lineaDeServiciosRepository, ServicioMapper mapper) {
        this.administraRepository = administraRepository;
        this.usuarioRepository = usuarioRepository;
        this.especialistaRepository = especialistaRepository;
        this.lineaDeServiciosRepository = lineaDeServiciosRepository;
        this.mapper = mapper;
    }


    public Administra add(AdministraCreacionDesdeLineaDeServiciosDTO dto, LineaDeServicios lineaServicios){
        Administra nuevo = mapper.toNewEntity(dto, lineaServicios, especialistaRepository, usuarioRepository);
        nuevo.setLineaServicios(lineaServicios);
        return nuevo;
    }

    public Administra addIndependiente(AdministraCreacionDesdeLineaDeServiciosDTO dto, LineaDeServicios lineaServicios){
        Administra nuevo = add(dto, lineaServicios);
        nuevo.setLineaServicios(lineaServicios);
        Administra guardado = administraRepository.save(nuevo);
        return guardado;
    }

    public Administra add(AdministraCreacionDTO dto){
        Administra nuevo = mapper.toNewEntity(dto, especialistaRepository, usuarioRepository, lineaDeServiciosRepository);
        Administra guardado = administraRepository.save(nuevo);
        return guardado;
    }

    public Administra getByIds(Long idAdmin, Long idEspecialista, Long idLineaServicios){
        return administraRepository.getByUsuarioIdAndAsignadoIdAndLineaServiciosId(idAdmin, idEspecialista, idLineaServicios);
    }

    public void delete(Long idAdmin, Long idEspecialista, Long idLineaServicios){
        administraRepository.deleteByUsuarioIdAndAsignadoIdAndLineaServiciosId(idAdmin, idEspecialista, idLineaServicios);
    }

    public void delete(Administra a){
        administraRepository.delete(a);
    }
}
