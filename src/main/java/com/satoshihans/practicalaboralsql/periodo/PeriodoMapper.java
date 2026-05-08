package com.satoshihans.practicalaboralsql.periodo;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.satoshihans.practicalaboralsql.departamento.DepartamentoRepository;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public interface PeriodoMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departamento", source = "idDepartamento", qualifiedByName = "departamentoFromId")
    @Mapping(target = "periodo", ignore = true)
    Plan toNewEntity(
        PlanPeriodoCreacionDTO dto,
        @Context DepartamentoRepository repository
    );

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "abierto", constant = "true")
    @Mapping(target = "ingresosTotales", ignore = true)
    @Mapping(target = "planes", ignore = true)
    Periodo toNewEntity(PeriodoCreacionDTO dto);

    PeriodoDTO toDTO(Periodo entity);
}
