package com.satoshihans.practicalaboralsql.periodo;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoRepository;
import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoCreacionDTO;
import com.satoshihans.practicalaboralsql.periodo.dto.PeriodoDTO;
import com.satoshihans.practicalaboralsql.periodo.dto.PlanPeriodoCreacionDTO;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public interface PeriodoMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departamento", source = "dto.idDepartamento", qualifiedByName = "departamentoFromId")
    @Mapping(target = "periodo", ignore = true)
    Plan toNewEntity(
        PlanPeriodoCreacionDTO dto,
        @Context DepartamentoRepository repository
    );

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "abierto", constant = "true")
    @Mapping(target = "ingresosTotales", constant = "0.0")
    @Mapping(target = "planes", ignore = true)
    @Mapping(target = "facturas", ignore = true)
    Periodo toNewEntity(
        PeriodoCreacionDTO dto,
        @Context DepartamentoRepository repository
    );
    @AfterMapping
    default void enlazarPlanes(
        PeriodoCreacionDTO dto,
        @MappingTarget Periodo entity,
        @Context DepartamentoRepository repository
    ){
        List<Long> deptoIds = repository.getAllIds();
        for(PlanPeriodoCreacionDTO planDTO : dto.getPlanes()){
            Plan nuevo_plan = toNewEntity(planDTO, repository);
            nuevo_plan.setPeriodo(entity);
            entity.getPlanes().add(nuevo_plan);
            if(deptoIds.contains(planDTO.getIdDepartamento()))
                deptoIds.remove(planDTO.getIdDepartamento());
            else
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Plan duplicado para el mismo id de departamento"
                );
        }
        if(!deptoIds.isEmpty())
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "No hay un plan asignado para todos los departamentos"
            );
    }

    PeriodoDTO toDTO(Periodo entity);
}
