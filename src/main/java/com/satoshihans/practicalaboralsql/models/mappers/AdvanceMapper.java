package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;

@Mapper(componentModel = "spring")
public interface AdvanceMapper {
    UsuarioDTO toDTO(Usuario usuario);
    @Mapping(target= "id", ignore = true)
    Usuario toEntity(UsuarioDTO dto);

    ClienteDTO toDTO(Cliente cliente);
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteCreacionDTO dto);

    ProvinciaDTO toDTO(Provincia provincia);
    @Mapping(target = "municipios", ignore = true)
    Provincia toEntity(ProvinciaDTO dto);

    @Mapping(target = "id_provincia", expression = "java(municipio.getProvincia().getId())")
    MunicipioDTO toDTO(Municipio municipio);
    Municipio toEntity(MunicipioDTO dto);
    @Mapping(target = "id", ignore = true)
    Municipio toEntity(MunicipioCreacionDTO dto);
}
