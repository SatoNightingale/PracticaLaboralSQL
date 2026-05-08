package com.satoshihans.practicalaboralsql.especialista;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.satoshihans.practicalaboralsql.departamento.Departamento;
import com.satoshihans.practicalaboralsql.departamento.DepartamentoCreacionDTO;
import com.satoshihans.practicalaboralsql.departamento.DepartamentoDTO;
import com.satoshihans.practicalaboralsql.departamento.DepartamentoService;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class},
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class EspecialistaMapper {

    public abstract EspecialistaDTO toDTO(Especialista entity);

    public abstract EspecialistaNombreDTO toNombreDTO(Especialista entity);

    @Mapping(target = "id", ignore = true)
    public abstract Especialista toNewEntity(EspecialistaCreacionDTO dto, @Context DepartamentoService service);
    @AfterMapping
    protected void resolverDepartamento(EspecialistaCreacionDTO dto, @MappingTarget Especialista entity, @Context DepartamentoService departamentoService){
        if(dto.getIdDepartamento() != null && departamentoService.existsById(dto.getIdDepartamento())){
            Departamento departamento = departamentoService.getById(dto.getIdDepartamento());
            entity.setDepartamento(departamento);
        } else {
            DepartamentoCreacionDTO nuevoDepartamento = dto.getDepartamento();
            Departamento departamento = departamentoService.add_NoDto(nuevoDepartamento);
            entity.setDepartamento(departamento);
        }
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "departamento", ignore = true)
    public abstract Especialista updateEntity(EspecialistaModificacionDTO dto, @MappingTarget Especialista entity);

    public abstract DepartamentoDTO toDTO(Departamento entity);

    @Mapping(target = "especialistas", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Departamento toNewEntity(DepartamentoCreacionDTO dto);

    @Mapping(target = "especialistas", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Departamento updateEntity(DepartamentoCreacionDTO dto, @MappingTarget Departamento entity);
}
