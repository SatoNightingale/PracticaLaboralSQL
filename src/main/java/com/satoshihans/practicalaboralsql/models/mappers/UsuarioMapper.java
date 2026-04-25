package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.satoshihans.practicalaboralsql.models.dto.UsuarioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.UsuarioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Usuario;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public abstract class UsuarioMapper {

    public abstract UsuarioDTO toDTO(Usuario entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autenticado", constant = "false")
    public abstract Usuario toNewEntity(UsuarioCreacionDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contrasena", ignore = true)
    @Mapping(target = "autenticado", ignore = true)
    public abstract Usuario updateEntity(UsuarioDTO dto, @MappingTarget Usuario entity);
}
