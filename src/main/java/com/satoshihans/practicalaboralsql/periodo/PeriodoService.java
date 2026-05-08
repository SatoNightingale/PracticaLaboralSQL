package com.satoshihans.practicalaboralsql.periodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoRepository;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private PeriodoMapper mapper;


    public PeriodoDTO add(PeriodoCreacionDTO dto){
        Periodo periodo = new Periodo();
        periodo.setAbierto(true);
        periodo.setInicio(dto.getInicio());
        periodo.setFin(dto.getFin());
        // LocalDate.parse(null)
        periodo.setIngresosTotales(0.0);
        
        for (PlanPeriodoCreacionDTO planDTO : dto.getPlanes()) {
            Plan nuevo_plan = new Plan();
            nuevo_plan.setPeriodo(periodo);
            nuevo_plan.setDepartamento(RelationResolver.departamentoFromId(planDTO.getIdDepartamento(), departamentoRepository));
            nuevo_plan.setPlan(planDTO.getPlan());
            // Plan guardado = planRepository.save(nuevo_plan);
            periodo.getPlanes().add(nuevo_plan);
        }

        Periodo guardado = periodoRepository.save(periodo);

        return mapper.toDTO(guardado);
    }
}
