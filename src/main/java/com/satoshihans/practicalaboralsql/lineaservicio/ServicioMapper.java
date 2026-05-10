package com.satoshihans.practicalaboralsql.lineaservicio;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.asignacion.*;
import com.satoshihans.practicalaboralsql.especialista.EspecialistaRepository;
import com.satoshihans.practicalaboralsql.servicio.Servicio;
import com.satoshihans.practicalaboralsql.servicio.ServicioCreacionDTO;
import com.satoshihans.practicalaboralsql.servicio.ServicioDTO;
import com.satoshihans.practicalaboralsql.shared.RelationResolver;
import com.satoshihans.practicalaboralsql.usuario.UsuarioRepository;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public abstract class ServicioMapper {

    /* Servicio */

    public abstract ServicioDTO toDTO(Servicio entity);
    @Mapping(target = "id", ignore = true)
    public abstract Servicio toNewEntity(ServicioCreacionDTO dto);
    @Mapping(target = "id", ignore = true)
    public abstract Servicio updateEntity(ServicioCreacionDTO dto, @MappingTarget Servicio entity);

    /* LineaDeServicios */

    @Mapping(target = "id_factura", source = "factura.id")
    public abstract LineaDeServiciosDTO toDTO(LineaDeServicios entity);

    /* Trabaja */

    public abstract TrabajaDTO toDTO(Trabaja entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "especialista", source = "dto.idEspecialista", qualifiedByName = "especialistaFromId")
    @Mapping(target = "importe", source = "dto.importe")
    public abstract Trabaja toNewEntity(TrabajaCreacionDTO dto, LineaDeServicios lineaServicios,
        @Context EspecialistaRepository repo
    );

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaContratacion", ignore = true)
    @Mapping(target = "especialista", source = "idEspecialista", qualifiedByName = "especialistaFromId")
    @Mapping(target = "lineaServicios", source = "idLineaDeServicios", qualifiedByName = "lineaServiciosFromId")
    public abstract Trabaja updateEntity(TrabajaModificacionDTO dto, @MappingTarget Trabaja entity,
        @Context EspecialistaRepository especialistaRepo,
        @Context LineaDeServiciosRepository lineaServiciosRepo
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
    public abstract Administra toNewEntity(AdministraCreacionDesdeLineaDeServiciosDTO dto, LineaDeServicios lineaServicios,
        @Context EspecialistaRepository especialistaRepo,
        @Context UsuarioRepository usuarioRepo
    );
}
