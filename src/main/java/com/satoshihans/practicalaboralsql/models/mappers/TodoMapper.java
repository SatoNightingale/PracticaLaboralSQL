package com.satoshihans.practicalaboralsql.models.mappers;

import com.satoshihans.practicalaboralsql.models.Empleados;
import com.satoshihans.practicalaboralsql.models.dto.FacturaDTO;
import com.satoshihans.practicalaboralsql.models.dto.ClienteDTO;
import com.satoshihans.practicalaboralsql.models.dto.EmpleadosDTO;
import com.satoshihans.practicalaboralsql.models.dto.EspecialistaDTO;
import com.satoshihans.practicalaboralsql.models.dto.LineaDeServiciosDTO;
import com.satoshihans.practicalaboralsql.models.dto.MunicipioDTO;
import com.satoshihans.practicalaboralsql.models.dto.ProvinciaDTO;
import com.satoshihans.practicalaboralsql.models.dto.ServiciosDTO;
import com.satoshihans.practicalaboralsql.models.dto.Trabaja_enDTO;
import com.satoshihans.practicalaboralsql.models.dto.UsuarioDTO;
import com.satoshihans.practicalaboralsql.models.entity.Cliente;
import com.satoshihans.practicalaboralsql.models.entity.Especialista;
import com.satoshihans.practicalaboralsql.models.entity.Factura;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;
import com.satoshihans.practicalaboralsql.models.entity.Municipio;
import com.satoshihans.practicalaboralsql.models.entity.Provincia;
import com.satoshihans.practicalaboralsql.models.entity.Servicios;
import com.satoshihans.practicalaboralsql.models.entity.Trabaja_en;
import com.satoshihans.practicalaboralsql.models.entity.Usuario;

public class TodoMapper {

    /**
     * Transforma las entidades en clases DTO
     */
    public static FacturaDTO toDtoFacturaDTO(Factura factura){return new FacturaDTO(factura.getId(), factura.getIdCliente());}
    public static ClienteDTO toDtoClienteDTO(Cliente cliente){return new ClienteDTO(cliente.getIdCliente(), cliente.getNombre(), cliente.getDireccion(), cliente.getGmail(), cliente.getTelefono());}
    public static LineaDeServiciosDTO toDtoLineaDeServiciosDTO(LineaDeServicios lineaDeServicios){return new LineaDeServiciosDTO(lineaDeServicios.getIdFactura(), lineaDeServicios.getIdServicio());}
    public static ServiciosDTO toDtoServiciosDTO(Servicios servicios){return new ServiciosDTO(servicios.getIdServicio(),  servicios.getNombre(), servicios.getDescripcion());}
    public static EspecialistaDTO toDtEspecialistaDTO(Especialista especialista){return new EspecialistaDTO(especialista.getNombre(), especialista.getIdDepartamento(), especialista.getEspecialidad());}
    public static MunicipioDTO toDtoMunicipioDTO(Municipio municipio){return new MunicipioDTO(municipio.getIdP(), municipio.getId(), municipio.getNombre());}
    public static ProvinciaDTO toDtoProvinciaDTO(Provincia provincia){return new ProvinciaDTO(provincia.getId(), provincia.getNombre());}
    public static Trabaja_enDTO toDtoTabaja_enDTO(Trabaja_en trabaja_en){return new Trabaja_enDTO(trabaja_en.getIdEspecialista(), trabaja_en.getIdServicio(), trabaja_en.getImporte());}
    public static UsuarioDTO toDtoUsuarioDTO(Usuario usuario){return new UsuarioDTO(usuario.getNombre(), usuario.getCod(), usuario.getGmail());}
    public static EmpleadosDTO toDtoEmpleadosDTO(Empleados empleados){return new EmpleadosDTO(empleados.getNombre(), empleados.getApellido(), empleados.getDireccion(), empleados.getPuesto(), empleados.getEdad(), empleados.getTelefono(), empleados.getId());}

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
    public static Servicios toEntityServicios(ServiciosDTO dto){
        Servicios servicios = new Servicios(dto.getIdServicio(), dto.getNombre(), dto.getDescripcion());
        return servicios;
    }    
    public static Especialista toEntityEspecialista(EspecialistaDTO dto){
        Especialista especialista = new Especialista(dto.getNombre(), dto.getIdDepartamento(), dto.getEspecialidad());
        return especialista;
    }
    public static Municipio toEntityMunicipio(MunicipioDTO dto){
        Municipio municipio= new Municipio(dto.getIdP(), dto.getId(), dto.getNombre());
        return municipio;
    }
    public static Provincia toEntityProvincia(ProvinciaDTO dto){
        Provincia provincia = new Provincia(dto.getId(), dto.getNombre());
        return provincia;
    }
    public static Trabaja_en toEntityTrabaja_en(Trabaja_enDTO dto){ 
        Trabaja_en trabaja_en = new Trabaja_en(dto.getIdEspecialista(), dto.getIdServicio(), dto.getImporte());
        return trabaja_en;
    }
    public static Usuario toEntityUsuario(UsuarioDTO dto){
        Usuario usuario = new Usuario(dto.getNombreU(), dto.getCod(), dto.getGmail());
        return usuario;
    }
    public static Empleados toEntityEmpleados(Empleados dto){
        Empleados empleados = new Empleados(dto.getNombre(), dto.getApellido(), dto.getDireccion(), dto.getPuesto(), dto.getEdad(), dto.getTelefono(), dto.getId());
        return empleados;
    }

















}
