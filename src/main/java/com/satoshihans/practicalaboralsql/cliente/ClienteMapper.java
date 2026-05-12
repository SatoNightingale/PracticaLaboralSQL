package com.satoshihans.practicalaboralsql.cliente;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.localizacion.LocalizacionMapper;
import com.satoshihans.practicalaboralsql.localizacion.MunicipioRepository;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(
    componentModel = "spring",
    uses = { RelationResolver.class, LocalizacionMapper.class }
)
public abstract class ClienteMapper {

    public abstract ClienteDTO toDTO(Cliente entity);

    @Mapping(target = "codigoId", source = "id")
    @Mapping(target = "municipio", source = "idMunicipio", qualifiedByName = "municipioFromId")
    public abstract Cliente toNewEntity(ClienteCreacionDTO dto, @Context MunicipioRepository municipioRepository);

    public abstract Cliente updateEntity(
        ClienteDTO dto,
        @MappingTarget Cliente entity
    );
}
