package com.satoshihans.practicalaboralsql.localizacion;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public abstract class LocalizacionMapper {

    public abstract MunicipioDTO toDTO(Municipio entity);
    public abstract ProvinciaDTO toDTO(Provincia entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provincia", ignore = true)
    public abstract Municipio toNewEntity(MunicipioCreacionDTO dto);
    
    @Mapping(target = "municipios", ignore = true)
    public abstract Provincia toEntity(ProvinciaDTO dto);
}