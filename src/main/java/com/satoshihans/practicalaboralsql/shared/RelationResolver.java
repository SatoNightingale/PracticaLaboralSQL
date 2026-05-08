package com.satoshihans.practicalaboralsql.shared;

import org.mapstruct.*;

import com.satoshihans.practicalaboralsql.cliente.*;
import com.satoshihans.practicalaboralsql.departamento.*;
import com.satoshihans.practicalaboralsql.especialista.*;
import com.satoshihans.practicalaboralsql.factura.*;
import com.satoshihans.practicalaboralsql.lineaservicio.*;
import com.satoshihans.practicalaboralsql.localizacion.*;
import com.satoshihans.practicalaboralsql.servicio.*;
import com.satoshihans.practicalaboralsql.usuario.*;

public class RelationResolver {

    @Named("municipioFromId")
    public static Municipio municipioFromId(Long id, @Context MunicipioRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("provinciaFromId")
    public static Provincia provinciaFromId(Long id, @Context ProvinciaRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("clienteFromId")
    public static Cliente clienteFromId(String id, @Context ClienteRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("facturaFromId")
    public static Factura facturaFromId(Long id, @Context FacturaRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("servicioFromId")
    public static Servicio servicioFromId(Long id, @Context ServicioRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("usuarioFromId")
    public static Usuario usuarioFromId(Long id, @Context UsuarioRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("departamentoFromId")
    public static Departamento departamentoFromId(Long id, @Context DepartamentoRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("especialistaFromId")
    public static Especialista especialistaFromId(Long id, @Context EspecialistaRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }

    @Named("lineaServiciosFromId")
    public static LineaDeServicios lineaServiciosFromId(Long id, @Context LineaDeServiciosRepository repo) {
        return id != null ? repo.findById(id).orElseThrow() : null;
    }
}
