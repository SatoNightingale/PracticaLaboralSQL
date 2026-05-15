package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.asignacion.TrabajaRepository;
import com.satoshihans.practicalaboralsql.departamento.DepartamentoRepository;
import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoCreacionDTO;
import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoDTO;
import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoIngresosDTO;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private TrabajaRepository trabajaRepository;

    @Autowired
    private PeriodoMapper mapper;


    public PeriodoDTO add(PeriodoCreacionDTO dto){
        Periodo periodo = mapper.toNewEntity(dto, departamentoRepository);
        Periodo guardado = periodoRepository.save(periodo);
        return mapper.toDTO(guardado);
    }

    public List<PeriodoDTO> listar(){
        return periodoRepository
            .findAll()
            .stream()
            .map(p -> mapper.toDTO(p))
            .toList();
    }

    public Periodo getById(Long id) {
        return periodoRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
    }

    public PeriodoDTO getAsDto(Long id){
        return mapper.toDTO(getById(id));
    }

    public PeriodoDTO getPeriodoByFecha(LocalDate fecha){
        return mapper.toDTO(periodoRepository.getPeriodoByFecha(fecha));
    }

    public Double getIngresosTotalesPeriodo(Long id){
        Periodo periodo = getById(id);
        return trabajaRepository.getIngresosTotalesPorPeriodo(
            periodo.getFechaInicio(), periodo.getFechaFin()
        );
    }

    public PeriodoDTO cerrarPeriodo(Long id){
        Periodo periodo = getById(id);
        periodo.setAbierto(false);
        // Calcular ingresos totales (reales) del periodo
        periodo.setIngresosTotales(
            trabajaRepository.getIngresosTotalesPorPeriodo(
                periodo.getFechaInicio(), periodo.getFechaFin()
            )
        );
        Periodo actualizado = periodoRepository.save(periodo);
        return mapper.toDTO(actualizado);
    }

    List<PeriodoIngresosDTO> listaIngresosHistoricos(){
        List<PeriodoIngresosDTO> ingresos = periodoRepository.findAllIngresosTotales();
        // Calcular los ingresos del ultimo periodo, que aun esta activo y por tanto tiene el campo en null
        for(PeriodoIngresosDTO periodo : ingresos){
            if(periodo.getIngresos() == null){
                periodo.setIngresos(getIngresosTotalesPeriodo(periodo.getId()));
            }
        }
        return ingresos;
    }
}
