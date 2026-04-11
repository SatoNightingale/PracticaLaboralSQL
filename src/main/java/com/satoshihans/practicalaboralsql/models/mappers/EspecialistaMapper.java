package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.satoshihans.practicalaboralsql.models.dto.DepartamentoCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaModificacionDTO;
import com.satoshihans.practicalaboralsql.models.entity.Departamento;
import com.satoshihans.practicalaboralsql.models.entity.Especialista;
import com.satoshihans.practicalaboralsql.services.DepartamentoService;

@Mapper(componentModel = "spring", uses = {AdvanceMapper.class, RelationResolver.class},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EspecialistaMapper {

    // @Mapping(target = "idDepartamento", source = "departamento.id")
    public abstract EspecialistaDTO toDTO(Especialista entity);

    @Mapping(target = "id", ignore = true)
    public abstract Especialista toNewEntity(EspecialistaCreacionDTO dto, @Context DepartamentoService service);
    @AfterMapping
    protected void resolverDepartamento(EspecialistaCreacionDTO dto, @MappingTarget Especialista entity, @Context DepartamentoService departamentoService){
        if(dto.getIdDepartamento() != null && departamentoService.existsById(dto.getIdDepartamento())){
            Departamento departamento = departamentoService.getById(dto.getIdDepartamento());
            entity.setDepartamento(departamento);
        } else {
            DepartamentoCreacionDTO nuevoDepartamento = dto.getDepartamento();
            Departamento departamento = departamentoService.add_departamento(nuevoDepartamento);
            entity.setDepartamento(departamento);
        }
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departamento", ignore = true)
    public abstract Especialista updateEntity(EspecialistaModificacionDTO dto, @MappingTarget Especialista entity);
}
