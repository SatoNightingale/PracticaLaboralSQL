package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;

@Mapper(componentModel = "spring")
public abstract class OldMapper {
    // public abstract UsuarioDTO toDTO(Usuario usuario);
    // @Mapping(target= "id", ignore = true)
    // public abstract Usuario toEntity(UsuarioDTO dto);

    // public abstract ClienteDTO toDTO(Cliente cliente);
    // @Mapping(target = "id", ignore = true)
    // Cliente toEntity(ClienteCreacionDTO dto);

    // public abstract ProvinciaDTO toDTO(Provincia provincia);
    
    // @Mapping(target = "municipios", ignore = true)
    // public abstract Provincia toEntity(ProvinciaDTO dto);
    // @AfterMapping
    // protected void resolveRelations(ProvinciaDTO dto, @MappingTarget Provincia entity,
    //     @Context ProvinciaService provinciaService
    // ){
    //     if(dto.getId() != null){

    //     }
    // }


    // @Mapping(target = "id_provincia", expression = "java(municipio.getProvincia().getId())")
    // public abstract MunicipioDTO toDTO(Municipio municipio);
    // Municipio toEntity(MunicipioDTO dto);
    // @Mapping(target = "id", ignore = true)
    // Municipio toEntity(MunicipioCreacionDTO dto);

    // public abstract DepartamentoDTO toDTO(Departamento dto);
    // public abstract DepartamentoCreacionDTO tDtoCreacion(Departamento dto);
    // @Mapping(target = "especialistas", ignore = true)
    // @Mapping(target = "id", ignore = true)
    // public abstract Departamento toEntity(DepartamentoCreacionDTO dto);

    // EspecialistaDTO toDTO(Especialista dto);

    // @Mapping(target = "id", ignore = true)
    // public abstract Servicio toEntity(ServicioDTO dto);

    
    // public abstract FacturaDTO toDTO(Factura entity);
    // @Mapping(target = "id", ignore = true)
    // public abstract Factura toEntity(FacturaDTO dto);
}