package com.satoshihans.practicalaboralsql.asignacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaCreacionDTO;
import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaDTO;
import com.satoshihans.practicalaboralsql.asignacion.dto.TrabajaModificacionDTO;
import com.satoshihans.practicalaboralsql.especialista.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServicios;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServiciosRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.ServicioMapper;

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

    // public TrabajaDTO add(TrabajaCreacionDTO dto, LineaDeServicios linea){
    //     return mapper.toDTO(add_nodto(dto, linea));
    // }

    public TrabajaDTO addIndependiente(TrabajaCreacionDTO dto, LineaDeServicios linea){
        Trabaja nuevo = add(dto, linea);
        nuevo.setLineaServicios(linea);
        Trabaja guardado = trabajaRepository.save(nuevo);
        return mapper.toDTO(guardado);
    }

    public Trabaja add(TrabajaCreacionDTO dto, LineaDeServicios linea){
        Trabaja nuevo = mapper.toNewEntity(dto, linea, especialistaRepo);
        return nuevo;
    }

    public Optional<Trabaja> getByEspecialistaAndLineaServicios(Long idEspecialista, Long idLineaDeServicio){
        return trabajaRepository.findByEspecialistaIdAndLineaServiciosId(idEspecialista, idLineaDeServicio);
    }

    // public Double sumImporteByLineaServiciosId(Long id){
    //     return trabajaRepository.sumImporteByLineaServiciosId(id);
    // }

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
