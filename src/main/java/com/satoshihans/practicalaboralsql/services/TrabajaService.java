package com.satoshihans.practicalaboralsql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.models.dto.TrabajaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.TrabajaDTO;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;
import com.satoshihans.practicalaboralsql.models.entity.Trabaja;
import com.satoshihans.practicalaboralsql.models.mappers.ServicioMapper;
import com.satoshihans.practicalaboralsql.repositories.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.repositories.TrabajaRepository;

@Service
public class TrabajaService {

    @Autowired
    private TrabajaRepository trabajaRepository;

    @Autowired
    private EspecialistaRepository especialistaRepo;

    @Autowired
    private ServicioMapper mapper;

    public TrabajaDTO add(TrabajaCreacionDTO dto, LineaDeServicios servicio){
        return mapper.toDTO(add_nodto(dto, servicio));
    }

    public Trabaja add_nodto(TrabajaCreacionDTO dto, LineaDeServicios servicio){
        Trabaja nuevo = mapper.toNewEntity(dto, servicio, especialistaRepo);
        Trabaja guardado = trabajaRepository.save(nuevo);
        return guardado;
    }
}
