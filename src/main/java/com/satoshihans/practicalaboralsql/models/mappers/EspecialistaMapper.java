package com.satoshihans.practicalaboralsql.models.mappers;

import java.security.InvalidParameterException;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.DepartamentoCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Departamento;
import com.satoshihans.practicalaboralsql.models.entity.Especialista;
import com.satoshihans.practicalaboralsql.services.DepartamentoService;

@Mapper(componentModel = "spring", uses = {AdvanceMapper.class, RelationResolver.class})
public abstract class EspecialistaMapper {

    @Mapping(target = "idDepartamento", source = "departamento.id")
    public abstract EspecialistaDTO toDTO(Especialista entity);

    @Mapping(target = "departamento", source = "idDepartamento", qualifiedByName = "departamentoFromId")
    public abstract Especialista toEntity(EspecialistaDTO dto, @Context DepartamentoService service);

    @Mapping(target = "id", ignore = true)
    public Especialista toNewEntity(EspecialistaCreacionDTO dto, @Context DepartamentoService service){
        Especialista especialista = new Especialista();
        try {
            if(dto.getIdDepartamento() != null){
                Departamento departamento = service.getById(dto.getIdDepartamento());
                especialista.setDepartamento(departamento);
            } else 
                throw new InvalidParameterException();
        } catch (ResponseStatusException | InvalidParameterException e){
            DepartamentoCreacionDTO nuevoDepartamento = dto.getDepartamento();
            Departamento departamento = service.add_departamento(nuevoDepartamento);
            especialista.setDepartamento(departamento);
        }
        return especialista;
    }
}
