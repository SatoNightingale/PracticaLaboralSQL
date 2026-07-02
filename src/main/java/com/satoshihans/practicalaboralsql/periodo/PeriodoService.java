package com.satoshihans.practicalaboralsql.periodo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.asignacion.TrabajaRepository;
import com.satoshihans.practicalaboralsql.departamento.DepartamentoRepository;
import com.satoshihans.practicalaboralsql.factura.*;
import com.satoshihans.practicalaboralsql.lineaservicio.LineaDeServiciosRepository;
import com.satoshihans.practicalaboralsql.periodo.dto.*;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private LineaDeServiciosRepository lineaDeServiciosRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private PeriodoMapper mapper;


    public PeriodoDTO add(PeriodoCreacionDTO dto){
        if(periodoRepository.findByAbiertoIsTrue()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya hay un período abierto");
        }
        Periodo periodo = mapper.toNewEntity(dto, departamentoRepository);
        Periodo guardado = periodoRepository.save(periodo);
        return mapper.toDTO(guardado);
    }

    public List<PeriodoDTO> listar(){
        return periodoRepository
            .findAll()
            .stream()
            .map(p -> mapper.toDTO(p))
            .toList();
    }

    public Periodo getById(Long id) {
        return periodoRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
    }

    public PeriodoDTO getAsDto(Long id){
        return mapper.toDTO(getById(id));
    }

    public PeriodoDTO getPeriodoByFecha(LocalDate fecha){
        return mapper.toDTO(periodoRepository.getPeriodoByFecha(fecha));
    }

    public PeriodoDTO cerrarPeriodo(Long id){
        Periodo periodo = getById(id);
        periodo.setAbierto(false);
        // Calcular ingresos totales (reales) del periodo
        periodo.setIngresosTotales(totalFacturadoPeriodo(id));
        Periodo actualizado = periodoRepository.save(periodo);
        return mapper.toDTO(actualizado);
    }

    List<PeriodoIngresosDTO> listaIngresosHistoricos(){
        List<PeriodoIngresosDTO> ingresos = periodoRepository.findAllIngresosTotales();
        // Calcular los ingresos del ultimo periodo, que aun esta activo y por tanto tiene el campo en null
        for(PeriodoIngresosDTO periodo : ingresos){
            if(periodo.getIngresos() == null){
                periodo.setIngresos(totalFacturadoPeriodo(periodo.getId()));
            }
        }
        return ingresos;
    }

    public Double totalFacturadoPeriodo(Long idPeriodo){
        periodoRepository.findById(idPeriodo).orElseThrow();
        // List<Factura> facturasPeriodo = facturaRepository.findByPeriodoId(idPeriodo);
        // double total = 0.0;
        // for (Factura factura : facturasPeriodo) {
        //     total += factura.getImporteTotal();
        // }
        return lineaDeServiciosRepository.totalRepartidoPorPeriodo(idPeriodo); // facturaRepository.sumImporteTotalByPeriodoId(idPeriodo);
    }

    public Double pendienteDeRepartoPeriodo(Long idPeriodo){
        periodoRepository.findById(idPeriodo).orElseThrow();
        List<Factura> facturasPeriodo = facturaRepository.findByPeriodoId(idPeriodo);
        double pendiente = 0.0;
        for (Factura factura : facturasPeriodo) {
            pendiente += facturaService.pendienteDeReparto(factura.getId());
        }
        return pendiente;
    }

    public Double cumplimientoPlan(Long idPeriodo){
        periodoRepository.findById(idPeriodo).orElseThrow();
        double totalFacturado = totalFacturadoPeriodo(idPeriodo);
        double planTotal = planRepository.getPlanPeriodo(idPeriodo);
        return totalFacturado / planTotal;
    }
}
