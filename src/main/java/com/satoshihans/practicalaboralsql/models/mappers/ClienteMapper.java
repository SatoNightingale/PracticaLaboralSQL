package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.ClienteCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.entity.Cliente;
import com.satoshihans.practicalaboralsql.repositories.MunicipioRepository;
import com.satoshihans.practicalaboralsql.services.MunicipioService;

@Mapper(componentModel = "spring", uses = {RelationResolver.class, LocalizacionMapper.class})
public abstract class ClienteMapper {
    
    public abstract ClienteDTO toDTO(Cliente entity);
    
    @BeforeMapping
    protected void resolverMunicipio(ClienteCreacionDTO dto, @MappingTarget Cliente entity, @Context MunicipioService municipioService){
        if(dto.getId_municipio() == null || (!municipioService.existsById(dto.getId_municipio()) && dto.getMunicipio() != null)){
            MunicipioCreacionDTO nuevoMunicipio = dto.getMunicipio();
            municipioService.add_municipio(nuevoMunicipio);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos de municipio invalidos");
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "municipio", source = "id_municipio", qualifiedByName = "municipioFromId")
    public abstract Cliente toNewEntity(ClienteCreacionDTO dto, @Context MunicipioRepository repo);

    public abstract Cliente updateEntity(ClienteDTO dto, @MappingTarget Cliente entity);
}
