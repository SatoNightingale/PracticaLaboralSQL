package com.satoshihans.practicalaboralsql.asignacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.especialista.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.usuario.UsuarioRepository;

@Service
public class AdministraService {

    @Autowired
    private AdministraRepository administraRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Autowired
    private LineaDeServiciosRepository lineaDeServiciosRepository;

    @Autowired
    private ServicioMapper mapper;


    public Administra add(AdministraCreacionDesdeLineaDeServiciosDTO dto, LineaDeServicios lineaServicios){
        Administra nuevo = mapper.toNewEntity(dto, lineaServicios, especialistaRepository, usuarioRepository);
        Administra guardado = administraRepository.save(nuevo);
        return guardado;
    }

    public Administra add(AdministraCreacionDTO dto){
        Administra nuevo = mapper.toNewEntity(dto, especialistaRepository, usuarioRepository, lineaDeServiciosRepository);
        Administra guardado = administraRepository.save(nuevo);
        return guardado;
    }

    public Administra getByIds(Long idAdmin, Long idEspecialista, Long idLineaServicios){
        return administraRepository.getByUsuarioAndAsignadoAndLineaServicios(idAdmin, idEspecialista, idLineaServicios);
    }

    public void delete(Long idAdmin, Long idEspecialista, Long idLineaServicios){
        administraRepository.deleteByUsuarioAndAsignadoAndLineaServicios(idAdmin, idEspecialista, idLineaServicios);
    }

    public void delete(Administra a){
        administraRepository.delete(a);
    }
}
