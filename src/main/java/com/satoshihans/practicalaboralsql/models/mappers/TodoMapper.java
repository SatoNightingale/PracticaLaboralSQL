package com.satoshihans.practicalaboralsql.models.mappers;

import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;


public class TodoMapper {

    /**
     * Transforma las entidades en clases DTO
     */
    public static FacturaDTO toDtoFacturaDTO(Factura factura){
        return new FacturaDTO(factura.getId(), factura.getCliente());
    }

    public static ClienteDTO toDtoClienteDTO(Cliente cliente){
        return new ClienteDTO( cliente.getTelefono(), cliente.getNombre(), cliente.getDireccion(), cliente.getGmail(), cliente.getId());
    }

    public static LineaDeServiciosDTO toDtoLineaDeServiciosDTO(LineaDeServicios lineaDeServicios){
        return new LineaDeServiciosDTO(lineaDeServicios.getFactura(), lineaDeServicios.getId(), lineaDeServicios.getImporte());
    
    }
    
    public static EspecialistaDTO toDtEspecialistaDTO(Especialista especialista){
        return new EspecialistaDTO(especialista.getNombre(), especialista.getDepartamento(), especialista.getEspecialidad(), especialista.getId());
    }

    public static Trabaja_enDTO toDtoTabaja_enDTO(Trabaja_en trabaja_en){
        return new Trabaja_enDTO(trabaja_en.getEspecialista(), trabaja_en.getIdServicio(), trabaja_en.getImporte());
    }

    public static DepartamentoDTO toDtoDepartamentoDTO(Departamento departamento){
        return new DepartamentoDTO(departamento.getNombre(), departamento.getDireccion(), departamento.getId());
    }
    

    /**
     * Transforma las clases DTO en entidades
     */
    public static Factura toEntityFactura(FacturaDTO dto){
        Factura factura = new Factura(dto.getId(), dto.getIdCliente());
        return factura;
    }

    public static Cliente toEntityCliente(ClienteDTO dto){
        Cliente cliente = new Cliente(dto.getId(), dto.getNombre(), dto.getDireccion(), dto.getGmail(), dto.getTelefono());
        return cliente;
    }

    public static LineaDeServicios toEntityLineaDeServicios(LineaDeServiciosDTO dto){
        LineaDeServicios lineaDeServicios = new LineaDeServicios(dto.getId(), dto.getFactura(), dto.getImporte());
        return lineaDeServicios; 
    }

    public static Especialista toEntityEspecialista(EspecialistaDTO dto){
        Especialista especialista = new Especialista(dto.getId(), dto.getNombre(), dto.getDepartamento(), dto.getEspecialidad());
        return especialista;
    }

    public static Trabaja_en toEntityTrabaja_en(Trabaja_enDTO dto){ 
        Trabaja_en trabaja_en = new Trabaja_en(dto.getEspecialista(), dto.getLineaDeServicios(), dto.getImporte());
        return trabaja_en;
    }

    public static Departamento toEntityDepartamento(DepartamentoDTO dto){
        Departamento departamento = new Departamento(dto.getId(), dto.getNombre(), dto.getDireccion());
        return departamento;
    }
}
