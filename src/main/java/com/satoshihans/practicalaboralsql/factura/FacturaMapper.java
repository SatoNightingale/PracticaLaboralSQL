package com.satoshihans.practicalaboralsql.factura;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.satoshihans.practicalaboralsql.cliente.ClienteRepository;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.lineaservicio.ServicioMapper;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;

@Mapper(componentModel = "spring", uses = {RelationResolver.class, ServicioMapper.class})
public abstract class FacturaMapper {

    public abstract FacturaDTO toDTO(Factura entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cliente", source = "idCliente", qualifiedByName = "clienteFromId")
    @Mapping(target = "fechaEmision", expression = "java(LocalDateTime.now())")
    @Mapping(target = "importeTotal", ignore = true)
    @Mapping(target = "lineasDeServicio", ignore = true)
    public abstract Factura toNewEntity(FacturaCreacionDTO dto,
        @Context ClienteRepository clienteRepo,
        @Context LineaDeServiciosService lineaDeServiciosService
    );
    @AfterMapping
    protected void resolverDependencias(FacturaCreacionDTO dto, @MappingTarget Factura entity,
        @Context ClienteRepository clienteRepo,
        @Context LineaDeServiciosService lineaDeServiciosService
    ){
        List<LineaDeServicios> lineasdeServicio = new ArrayList<>();
        Double importe = 0.0;

        for (LineaDeServiciosCreacionDesdeFacturaDTO lineaServiciosDTO : dto.getLineasDeServicios()) {
            LineaDeServicios nuevaLineaServicios = lineaDeServiciosService.add(
                lineaServiciosDTO, entity, dto.getIdUsuarioAdmin()
            );
            importe += nuevaLineaServicios.getImporte();
            lineasdeServicio.add(nuevaLineaServicios);
        }

        entity.setLineasDeServicio(lineasdeServicio);
        entity.setImporteTotal(importe);
    }

    public abstract LineaDeServiciosCreacionDesdeFacturaDTO toCreacionDTO(LineaDeServiciosCreacionDTO dto);
}
