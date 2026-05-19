package com.satoshihans.practicalaboralsql.factura;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.satoshihans.practicalaboralsql.cliente.ClienteRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class, ServicioMapper.class})
public abstract class FacturaMapper {

    public abstract FacturaDTO toDTO(Factura entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", source = "idCliente", qualifiedByName = "clienteFromId")
    @Mapping(target = "fechaEmision", expression = "java(LocalDateTime.now())")
    @Mapping(target = "importeTotal", ignore = true)
    @Mapping(target = "lineasDeServicio", ignore = true)
    @Mapping(target = "periodo", ignore = true)
    public abstract Factura toNewEntity(FacturaCreacionDTO dto, @Context ClienteRepository clienteRepo);
    // @AfterMapping
    // protected void resolverDependencias(FacturaCreacionDTO dto, @MappingTarget Factura entity,
    //     @Context ClienteRepository clienteRepo,
    //     @Context PeriodoRepository periodoRepo,
    //     @Context LineaDeServiciosService lineaDeServiciosService
    // ){
        
    // }

    public abstract LineaDeServiciosCreacionDesdeFacturaDTO toCreacionDesdeFacturaDTO(LineaDeServiciosCreacionDTO dto);
}
