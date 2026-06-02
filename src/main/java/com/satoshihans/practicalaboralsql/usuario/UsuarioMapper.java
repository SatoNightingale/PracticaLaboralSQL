package com.satoshihans.practicalaboralsql.usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public abstract class UsuarioMapper {

    public abstract UsuarioDTO toDTO(Usuario entity);

    @Mapping(target = "id", ignore = true)
    public abstract Usuario toNewEntity(UsuarioCreacionDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "contrasena", ignore = true)
    public abstract Usuario updateEntity(UsuarioDTO dto, @MappingTarget Usuario entity);
}
