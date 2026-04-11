package com.satoshihans.practicalaboralsql.models.mappers;

import org.mapstruct.*;
import com.satoshihans.practicalaboralsql.models.dto.*;
import com.satoshihans.practicalaboralsql.models.entity.*;
import com.satoshihans.practicalaboralsql.services.*;

@Mapper(componentModel = "spring", uses = {RelationResolver.class})
public interface AdvanceMapper {

    /* Cliente */
    @Mapping(target = "id_municipio", source = "municipio.id")
    public ClienteDTO toDTO(Cliente entity);
    @Mapping(target = "municipio", source = "id_municipio", qualifiedByName = "municipioFromId")
    public Cliente toEntity(ClienteDTO dto, @Context MunicipioService service);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "municipio", source = "id_municipio", qualifiedByName = "municipioFromId")
    public Cliente toNewEntity(ClienteCreacionDTO dto, @Context MunicipioService service);

    /* Factura */
    @Mapping(target = "id_cliente", source = "cliente.id")
    public FacturaDTO toDTO(Factura entity);
    @Mapping(target = "cliente", source = "id_cliente", qualifiedByName = "clienteFromId")
    public Factura toEntity(FacturaDTO dto, @Context ClienteService service);

    /* Departamento */
    public DepartamentoDTO toDTO(Departamento entity);
    @Mapping(target = "especialistas", ignore = true)
    @Mapping(target = "id", ignore = true)
    public Departamento toNewEntity(DepartamentoCreacionDTO dto);

    /* Especialista */
    // @Mapping(target = "idDepartamento", source = "departamento.id")
    // public EspecialistaDTO toDTO(Especialista entity);
    // @Mapping(target = "departamento", source = "idDepartamento", qualifiedByName = "departamentoFromId")
    // public Especialista toEntity(EspecialistaDTO dto, @Context DepartamentoService service);
    // @Mapping(target = "departamento", source = "idDepartamento", qualifiedByName = "departamentoFromId")
    // @Mapping(target = "id", ignore = true)
    // public Especialista toNewEntity(EspecialistaCreacionDTO dto, @Context DepartamentoService service);

    /* Municipio */
    @Mapping(target = "id_provincia", source = "provincia.id")
    public MunicipioDTO toDTO(Municipio entity);
    @Mapping(target = "provincia", source = "id_provincia", qualifiedByName = "provinciaFromId")
    public Municipio toEntity(MunicipioDTO dto, @Context ProvinciaService service);

    /* Provincia */
    public ProvinciaDTO toDTO(Provincia entity);
    @Mapping(target = "municipios", ignore = true)
    public Provincia toEntity(ProvinciaDTO dto);

    /* Servicio */
    public ServicioDTO toDTO(Servicio entity);
    public Servicio toEntity(ServicioDTO dto);

    /* Usuario */
    

    /* LineaDeServicios */
    @Mapping(target = "id_factura", source = "factura.id")
    @Mapping(target = "id_servicio", source = "servicio.id")
    public LineaDeServiciosDTO toDTO(LineaDeServicios entity);
    // @AfterMapping
    // protected void resolveRelations(LineaDeServiciosDTO dto, @MappingTarget Cliente entity,
    //     @Context MunicipioService municipioService){
    //     if(dto.getId_municipio() != null){
    //         Municipio municipio = municipioService.getById(dto.getId_municipio());
    //         entity.setMunicipio(municipio);
    //     } else 
    //         throw new RuntimeException("id_municipio no puede ser null");
    // }

    @Mapping(target = "factura", source = "id_factura", qualifiedByName = "facturaFromId")
    @Mapping(target = "servicio", source = "id_servicio", qualifiedByName = "servicioFromId")
    @Mapping(target = "administradores", ignore = true)
    public LineaDeServicios toEntity(LineaDeServiciosDTO dto,
        @Context FacturaService facturaService,
        @Context ServicioService servicioService
    );


}


// @AfterMapping
// protected void resolveRelations(ClienteCreacionDTO dto, @MappingTarget Cliente entity,
//     @Context MunicipioService municipioService){
//     if(dto.getId_municipio() != null){
//         Municipio municipio = municipioService.getById(dto.getId_municipio());
//         entity.setMunicipio(municipio);
//     } else 
//         throw new RuntimeException("id_municipio no puede ser null");
// }