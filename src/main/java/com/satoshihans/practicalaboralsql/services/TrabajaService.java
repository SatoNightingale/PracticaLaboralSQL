package com.satoshihans.practicalaboralsql.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.models.dto.TrabajaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.TrabajaDTO;
import com.satoshihans.practicalaboralsql.models.dto.TrabajaModificacionDTO;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;
import com.satoshihans.practicalaboralsql.models.entity.Trabaja;
import com.satoshihans.practicalaboralsql.models.mappers.ServicioMapper;
import com.satoshihans.practicalaboralsql.repositories.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.repositories.LineaDeServiciosRepository;
import com.satoshihans.practicalaboralsql.repositories.TrabajaRepository;

@Service
public class TrabajaService {

    @Autowired
    private TrabajaRepository trabajaRepository;

    @Autowired
    private EspecialistaRepository especialistaRepo;

    @Autowired
    private LineaDeServiciosRepository lineaDeServiciosRepo;

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

    public Optional<Trabaja> getByEspecialistaAndLineaServicios(Long idEspecialista, Long idLineaDeServicio){
        return trabajaRepository.findByEspecialistaIdAndLineaServiciosId(idEspecialista, idLineaDeServicio);
    }

    public Double sumImporteByLineaServiciosId(Long id){
        return trabajaRepository.sumImporteByLineaServiciosId(id);
    }

    public TrabajaDTO update(TrabajaModificacionDTO dto){
        Trabaja entity = trabajaRepository.findById(dto.getIdTrabaja()).orElseThrow();
        Trabaja actualizado = mapper.updateEntity(dto, entity, especialistaRepo, lineaDeServiciosRepo);
        Trabaja guardado = trabajaRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }

    public void delete(Long idEspecialista, Long idLineaServicios){
        trabajaRepository.deleteByEspecialistaAndLineaServicios(idEspecialista, idLineaServicios);
    }

    public void delete(Trabaja t){
        trabajaRepository.delete(t);
    }
}
