package com.satoshihans.practicalaboralsql.models.mappers;

import java.util.ArrayList;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;


public class TodoMapper {

    /**
     * Transforma las entidades en clases DTO
     */
    public static FacturaDTO toFacturaDTO(Factura factura){
        return new FacturaDTO(
            factura.getId(),
            toClienteDTO(factura.getCliente()),
            factura.getImporte(),
            factura.getFecha()
        );
    }

    public static ClienteDTO toClienteDTO(Cliente cliente){
        return null;
        // return new ClienteDTO(
        //     cliente.getId(),
        //     cliente.getTelefono(),
        //     cliente.getNombre(),
        //     cliente.getDireccion(),
        //     cliente.getGmail()
        // );
    }

    public static LineaDeServiciosDTO toLineaDeServiciosDTO(LineaDeServicios lineaDeServicios) {
        return new LineaDeServiciosDTO(
            lineaDeServicios.getId(),
            lineaDeServicios.getImporte(),
            toFacturaDTO(lineaDeServicios.getFactura()),
            toServicioDTO(lineaDeServicios.getServicio()),
            toUsuarioDTO(lineaDeServicios.getUsuario())
        );
    
    }
    
    public static EspecialistaDTO toEspecialistaDTO(Especialista especialista){
        return new EspecialistaDTO(
            especialista.getId(),
            especialista.getNombre(),
            especialista.getEspecialidad(),
            toDepartamentoDTO(especialista.getDepartamento())
        );
    }

    public static Trabaja_enDTO toTabaja_enDTO(Trabaja_en trabaja_en){
        return new Trabaja_enDTO(
            toLineaDeServiciosDTO(trabaja_en.getIdServicio()),
            toEspecialistaDTO(trabaja_en.getEspecialista()),
            trabaja_en.getImporte()
        );
    }

    public static DepartamentoDTO toDepartamentoDTO(Departamento departamento){
        return new DepartamentoDTO(
            departamento.getId(),
            departamento.getNombre(),
            departamento.getDireccion()
        );
    }

    public static UsuarioDTO toUsuarioDTO(Usuario usuario){
        return new UsuarioDTO(
            usuario.getNombre(),
            usuario.getDireccion(),
            usuario.getGmail()
        );
    }

    public static ServicioDTO toServicioDTO(Servicio servicio){
        return new ServicioDTO(
            servicio.getId(),
            servicio.getNombre(),
            servicio.getDescripcion()
        );
    }
    

    /**
     * Transforma las clases DTO en entidades
     */
    public static Factura toEntityFactura(FacturaDTO dto){
        return new Factura(
            dto.getId(),
            toEntityCliente(dto.getCliente()),
            dto.getImporte(),
            dto.getFecha()
        );
        // return new Factura(dto.getId(), dto.getIdCliente());
    }

    public static Cliente toEntityCliente(ClienteDTO dto){
        // Cliente cliente = new Cliente(dto.getId(), dto.getNombre(), dto.getDireccion(), dto.getGmail(), dto.getTelefono());
        return null;
    }

    public static LineaDeServicios toEntityLineaDeServicios(LineaDeServiciosDTO dto){
        // LineaDeServicios lineaDeServicios = new LineaDeServicios(dto.getId(), dto.getFactura(), dto.getImporte());
        return null; 
    }

    public static Especialista toEntityEspecialista(EspecialistaDTO dto){
        // Especialista especialista = new Especialista(dto.getId(), dto.getNombre(), dto.getDepartamento(), dto.getEspecialidad());
        return null;
    }

    public static Trabaja_en toEntityTrabaja_en(Trabaja_enDTO dto){ 
        // Trabaja_en trabaja_en = new Trabaja_en(dto.getEspecialista(), dto.getLineaDeServicios(), dto.getImporte());
        return null;
    }

    public static Departamento toEntityDepartamento(DepartamentoDTO dto){
        Departamento departamento = new Departamento(
            dto.getId(),
            dto.getNombre(),
            dto.getDireccion(),
            new ArrayList<>()
        );
        return departamento;
    }
}
