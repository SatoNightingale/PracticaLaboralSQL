package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.models.dto.AdministraCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.AdministraDTO;
import com.satoshihans.practicalaboralsql.models.dto.LineaDeServiciosDTO;
import com.satoshihans.practicalaboralsql.models.dto.ServicioDTO;
import com.satoshihans.practicalaboralsql.models.dto.TrabajaCreacionDTO;
import com.satoshihans.practicalaboralsql.models.dto.TrabajaDTO;
import com.satoshihans.practicalaboralsql.models.entity.Administra;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;
import com.satoshihans.practicalaboralsql.models.entity.Servicio;
import com.satoshihans.practicalaboralsql.models.entity.Trabaja;
import com.satoshihans.practicalaboralsql.repositories.*;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public abstract class ServicioMapper {

    /* Servicio */

    public abstract ServicioDTO toDTO(Servicio entity);
    public abstract Servicio toEntity(ServicioDTO dto);

    /* LineaDeServicios */

    @Mapping(target = "id_factura", source = "factura.id")
    public abstract LineaDeServiciosDTO toDTO(LineaDeServicios entity);

    // @Mapping(target = "id", ignore = true)
    // @Mapping(target = "servicio", source = "id_servicio", qualifiedByName = "servicioFromId")
    // public abstract LineaDeServicios toNewEntity(
    //     LineaDeServiciosCreacionDTO dto,
    //     @Context Factura factura,
    //     @Context Long idUsuarioAdmin,
    //     @Context ServicioRepository servicioRepository,
    //     @Context TrabajaRepository trabajaRepository,
    //     @Context AdministraRepository administraRepository
    // );
    // @AfterMapping
    // protected void resolverDependencias(LineaDeServiciosCreacionDTO dto,
    //     @MappingTarget LineaDeServicios entity,
    //     @Context Factura factura,
    //     @Context Long idUsuarioAdmin,
    //     @Context ServicioRepository servicioRepository,
    //     @Context TrabajaRepository trabajaRepository,
    //     @Context AdministraRepository administraRepository
    // ){
    //     List<Trabaja> contratos = new ArrayList<>();
    //     List<Administra> asignaciones = new ArrayList<>();
    //     Double importe = 0.0;

    //     for (TrabajaCreacionDTO trabajaDto : dto.getContratos()) {
    //         importe += trabajaDto.getImporte();
    //         contratos.add(trabajaRepository.add_nodto(trabajaDto, entity));
    //         asignaciones.add(administraRepository.add(
    //             new AdministraCreacionDTO(
    //                 idUsuarioAdmin,
    //                 trabajaDto.getId_especialista(),
    //                 entity.getId(),
    //                 LocalDateTime.now()
    //             ), entity
    //         ));
    //     }
        
    //     entity.setFactura(factura);
    //     entity.setImporte(importe);
    //     entity.setContratados(contratos);
    //     entity.setAsignaciones(asignaciones);
    // }

    /* Trabaja */

    public abstract TrabajaDTO toDTO(Trabaja entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "especialista", source = "dto.id_especialista", qualifiedByName = "especialistaFromId")
    @Mapping(target = "importe", source = "dto.importe")
    public abstract Trabaja toNewEntity(TrabajaCreacionDTO dto, LineaDeServicios lineaServicios,
        @Context EspecialistaRepository repo
    );

    /* Administra */

    @Mapping(target = "especialistaAsignado", source = "asignado")
    @Mapping(target = "id_LineaDeServicio", source = "lineaServicios.id")
    public abstract AdministraDTO toDTO(Administra entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "asignado", source = "idEspecialistaAsignado", qualifiedByName = "especialistaFromId")
    @Mapping(target = "usuario", source = "idUsuario", qualifiedByName = "usuarioFromId")
    @Mapping(target = "lineaServicios", source = "idLineaServicios", qualifiedByName = "lineaServiciosFromId")
    public abstract Administra toNewEntity(AdministraCreacionDTO dto,
        @Context EspecialistaRepository especialistaRepo,
        @Context UsuarioRepository usuarioRepo,
        @Context LineaDeServiciosRepository lineaServiciosRepo
    );

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "asignado", source = "dto.idEspecialistaAsignado", qualifiedByName = "especialistaFromId")
    @Mapping(target = "usuario", source = "dto.idUsuario", qualifiedByName = "usuarioFromId")
    public abstract Administra toNewEntity(AdministraCreacionDTO dto, LineaDeServicios lineaServicios,
        @Context EspecialistaRepository especialistaRepo,
        @Context UsuarioRepository usuarioRepo
    );
}
