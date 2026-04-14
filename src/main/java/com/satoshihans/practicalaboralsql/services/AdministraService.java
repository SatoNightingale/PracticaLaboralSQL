package com.satoshihans.practicalaboralsql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.models.dto.AdministraCreacionDTO;
import com.satoshihans.practicalaboralsql.models.entity.Administra;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;
import com.satoshihans.practicalaboralsql.models.mappers.ServicioMapper;
import com.satoshihans.practicalaboralsql.repositories.AdministraRepository;
import com.satoshihans.practicalaboralsql.repositories.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.repositories.LineaDeServiciosRepository;
import com.satoshihans.practicalaboralsql.repositories.UsuarioRepository;

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


    public Administra add(AdministraCreacionDTO dto, LineaDeServicios lineaServicios){
        Administra nuevo = mapper.toNewEntity(dto, lineaServicios, especialistaRepository, usuarioRepository);
        Administra guardado = administraRepository.save(nuevo);
        return guardado;
    }

    public Administra add(AdministraCreacionDTO dto){
        Administra nuevo = mapper.toNewEntity(dto, especialistaRepository, usuarioRepository, lineaDeServiciosRepository);
        Administra guardado = administraRepository.save(nuevo);
        return guardado;
    }
}
