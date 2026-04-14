package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.dto.MunicipioCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioDTO;
import com.satoshihans.practicalaboralsql.models.dto.ProvinciaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Municipio;
import com.satoshihans.practicalaboralsql.models.entity.Provincia;
import com.satoshihans.practicalaboralsql.repositories.ProvinciaRepository;
import com.satoshihans.practicalaboralsql.services.ProvinciaService;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public abstract class LocalizacionMapper {

    public abstract MunicipioDTO toDTO(Municipio entity);

    @BeforeMapping
    public void resolverProvincia(MunicipioCreacionDTO dto, @MappingTarget Municipio entity, @Context ProvinciaService service){
        if(dto.getId_provincia() == null || (!service.existsById(dto.getId_provincia()) && dto.getNombre_provincia() != null)){
            service.add_provincia(dto.getNombre_provincia());
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos de municipio invalidos");
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provincia", source = "id_provincia", qualifiedByName = "provinciaFromId")
    public abstract Municipio toEntity(MunicipioCreacionDTO dto, @Context ProvinciaRepository repo);

    public abstract ProvinciaDTO toDTO(Provincia entity);

    @Mapping(target = "municipios", ignore = true)
    public abstract Provincia toEntity(ProvinciaDTO dto);
}
