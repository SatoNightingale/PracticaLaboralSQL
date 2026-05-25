package com.satoshihans.practicalaboralsql.departamento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.asignacion.TrabajaRepository;
import com.satoshihans.practicalaboralsql.especialista.EspecialistaMapper;
import com.satoshihans.practicalaboralsql.especialista.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.especialista.dto.EspecialistaCumplimientoPlanDTO;
import com.satoshihans.practicalaboralsql.periodo.Periodo;
import com.satoshihans.practicalaboralsql.periodo.PeriodoRepository;
import com.satoshihans.practicalaboralsql.periodo.PlanRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private TrabajaRepository trabajaRepository;

    @Autowired
    private EspecialistaRepository especialistaRepository;

    @Autowired
    private EspecialistaMapper mapper;

    
    public Departamento add_NoDto(DepartamentoCreacionDTO dto) {
        if (departamentoRepository.count() < 5) {
            Departamento nuevo = mapper.toNewEntity(dto);
            Departamento guardado = departamentoRepository.save(nuevo);
            return guardado;
        } else throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "No puede haber más de 5 departamentos activos"
        );
    }


    public DepartamentoDTO add(DepartamentoCreacionDTO dto) {
        return mapper.toDTO(add_NoDto(dto));
    }


    public List<DepartamentoDTO> listar() {
        return departamentoRepository
            .findAll()
            .stream()
            .map((Departamento u) -> mapper.toDTO(u))
            .toList();
    }


    public Departamento getById(Long id) {
        return departamentoRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
    }

    public DepartamentoDTO getAsDTO(Long id){
        return mapper.toDTO(getById(id));
    }


    public DepartamentoDTO update(Long id, DepartamentoCreacionDTO dto) {
        Departamento entity = getById(id);
        Departamento actualizado = mapper.updateEntity(dto, entity);
        Departamento guardado = departamentoRepository.save(actualizado);
        return mapper.toDTO(guardado);
    }


    public void delete(Long id) {
        getById(id);
        departamentoRepository.deleteById(id);
    }


    public boolean existsById(Long id) {
        return departamentoRepository.existsById(id);
    }


    public Double obtenerFraccionPlanPorEspecialista(Long idDepartamento, Long idPeriodo){
        Double planDepartamento = planRepository.getPlanByDepartamento(idDepartamento, idPeriodo);
        Integer cantEspecialistas = especialistaRepository.countByDepartamento(idDepartamento);
        return planDepartamento / cantEspecialistas;
    }


    public EspecialistaCumplimientoPlanDTO porcentajeCumplimientoPlanEspecialista(
        Long idEspecialista,
        Periodo periodo,
        Double fraccionEspecialista
    ){
        Double ingresos = trabajaRepository.getIngresosTotalesEspecialistaPorPeriodo(idEspecialista, periodo.getFechaInicio(), periodo.getFechaFin());
        Double porcentajeCumplido = ingresos / fraccionEspecialista;
        return new EspecialistaCumplimientoPlanDTO(
            idEspecialista,
            ingresos,
            porcentajeCumplido
        );
    }


    public DepartamentoCumplimientoPlanDTO reporteIngresosDepartamento(Long idDepartamento, Long idPeriodo){
        Departamento departamento = departamentoRepository.findById(idDepartamento).orElseThrow();
        Periodo periodo = periodoRepository.findById(idPeriodo).orElseThrow();

        Double planPeriodo = planRepository.getPlanByDepartamento(idDepartamento, idPeriodo);
        Double fraccionEspecialista = planPeriodo / especialistaRepository.countByDepartamento(idDepartamento);
        
        List<EspecialistaCumplimientoPlanDTO> cumplimientosEspecialista = especialistaRepository
            .findAllByDepartamento(idDepartamento)
            .stream()
            .map(id -> porcentajeCumplimientoPlanEspecialista(
                    id,
                    periodo,
                    fraccionEspecialista
                )
            )
            .toList();
        
        Double ingresosTotales = cumplimientosEspecialista
            .stream()
            .mapToDouble(dto -> dto.getIngresosTotales())
            .sum();
        
        return new DepartamentoCumplimientoPlanDTO(
            mapper.toDTO(departamento),
            idPeriodo,
            ingresosTotales,
            planPeriodo,
            ingresosTotales / planPeriodo,
            cumplimientosEspecialista
        );
    }
}
