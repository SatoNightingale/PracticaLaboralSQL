package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.repositories.*;

public class RelationResolver {

    @Named("municipioFromId")
    public static Municipio municipioFromId(Long id, @Context MunicipioRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("provinciaFromId")
    public static Provincia provinciaFromId(Long id, @Context ProvinciaRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("clienteFromId")
    public static Cliente clienteFromId(Long id, @Context ClienteRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("facturaFromId")
    public static Factura facturaFromId(Long id, @Context FacturaRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("servicioFromId")
    public static Servicio servicioFromId(Long id, @Context ServicioRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("usuarioFromId")
    public static Usuario usuarioFromId(Long id, @Context UsuarioRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("departamentoFromId")
    public static Departamento departamentoFromId(Long id, @Context DepartamentoRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("especialistaFromId")
    public static Especialista especialistaFromId(Long id, @Context EspecialistaRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }

    @Named("lineaServiciosFromId")
    public static LineaDeServicios lineaServiciosFromId(Long id, @Context LineaDeServiciosRepository repo) {
        return id != null ? repo.findById(id).get() : null;
    }
}
