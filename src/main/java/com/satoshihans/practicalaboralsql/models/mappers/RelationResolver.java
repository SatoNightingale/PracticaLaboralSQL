package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.services.*;

public class RelationResolver {

    @Named("municipioFromId")
    public static Municipio municipioFromId(Long id, @Context MunicipioService service) {
        return id != null ? service.getById(id) : null;
    }

    @Named("provinciaFromId")
    public static Provincia provinciaFromId(Long id, @Context ProvinciaService service) {
        return id != null ? service.getById(id) : null;
    }

    @Named("clienteFromId")
    public static Cliente clienteFromId(Long id, @Context ClienteService service) {
        return id != null ? service.getById(id) : null;
    }

    @Named("facturaFromId")
    public static Factura facturaFromId(Long id, @Context FacturaService service) {
        return id != null ? service.getById(id) : null;
    }

    @Named("servicioFromId")
    public static Servicio servicioFromId(Long id, @Context ServicioService service) {
        return id != null ? service.getById(id) : null;
    }

    @Named("usuarioFromId")
    public static Usuario usuarioFromId(Long id, @Context UsuarioService service) {
        return id != null ? service.getById(id) : null;
    }

    @Named("departamentoFromId")
    public static Departamento departamentoFromId(Long id, @Context DepartamentoService service) {
        return id != null ? service.getById(id) : null;
    }
}
