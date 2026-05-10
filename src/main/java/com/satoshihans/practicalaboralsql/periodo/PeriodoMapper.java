package com.satoshihans.practicalaboralsql.periodo;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoRepository;
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
        for(PlanPeriodoCreacionDTO planDTO : dto.getPlanes()){
            Plan nuevo_plan = toNewEntity(planDTO, repository);
            nuevo_plan.setPeriodo(entity);
            entity.getPlanes().add(nuevo_plan);
        }
    }

    PeriodoDTO toDTO(Periodo entity);
}
