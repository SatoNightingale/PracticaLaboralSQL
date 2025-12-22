package com.satoshihans.practicalaboralsql.models.mappers;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;


public class TodoMapper {

    /**
     * Transforma las entidades en clases DTO
     */
    public static FacturaDTO toDtoFacturaDTO(Factura factura){
        return new FacturaDTO(factura.getId(), factura.getIdCliente());
    }

    public static ClienteDTO toDtoClienteDTO(Cliente cliente){
        return new ClienteDTO(cliente.getIdCliente(), cliente.getNombre(), cliente.getDireccion(), cliente.getGmail(), cliente.getTelefono());
    }

    public static LineaDeServiciosDTO toDtoLineaDeServiciosDTO(LineaDeServicios lineaDeServicios){
        return new LineaDeServiciosDTO(lineaDeServicios.getIdFactura(), lineaDeServicios.getIdServicio());
    
    }
    
    public static EspecialistaDTO toDtEspecialistaDTO(Especialista especialista){
        return new EspecialistaDTO(especialista.getNombre(), especialista.getIdDepartamento(), especialista.getEspecialidad());
    }

    public static Trabaja_enDTO toDtoTabaja_enDTO(Trabaja_en trabaja_en){
        return new Trabaja_enDTO(trabaja_en.getIdEspecialista(), trabaja_en.getIdServicio(), trabaja_en.getImporte());
    }
    

    /**
     * Transforma las clases DTO en entidades
     */
    public static Factura toEntityFactura(FacturaDTO dto){
        Factura factura = new Factura(dto.getId(), dto.getIdCliente());
        return factura;
    }

    public static Cliente toEntityCliente(ClienteDTO dto){
        Cliente cliente = new Cliente(dto.getIdCliente(), dto.getNombre(), dto.getDireccion(), dto.getGmail(), dto.getTelefono());
        return cliente;
    }

    public static LineaDeServicios toEntityLineaDeServicios(LineaDeServiciosDTO dto){
        LineaDeServicios lineaDeServicios = new LineaDeServicios(dto.getId(), dto.getIdServicio());
        return lineaDeServicios; 
    }

    public static Especialista toEntityEspecialista(EspecialistaDTO dto){
        Especialista especialista = new Especialista(dto.getNombre(), dto.getIdDepartamento(), dto.getEspecialidad());
        return especialista;
    }

    public static Trabaja_en toEntityTrabaja_en(Trabaja_enDTO dto){ 
        Trabaja_en trabaja_en = new Trabaja_en(dto.getIdEspecialista(), dto.getIdServicio(), dto.getImporte());
        return trabaja_en;
    }
}
