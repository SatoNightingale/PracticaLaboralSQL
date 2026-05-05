package com.satoshihans.practicalaboralsql.models.mappers;

import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.models.entity.Cliente;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    uses = { RelationResolver.class, LocalizacionMapper.class }
)
public abstract class ClienteMapper {

    public abstract ClienteDTO toDTO(Cliente entity);

    @Mapping(target = "codigoId", source = "id")
    @Mapping(target = "municipio", ignore = true)
    public abstract Cliente toNewEntity(ClienteCreacionDTO dto);

    public abstract Cliente updateEntity(
        ClienteDTO dto,
        @MappingTarget Cliente entity
    );
}
