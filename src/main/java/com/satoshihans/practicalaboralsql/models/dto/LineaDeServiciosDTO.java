package com.satoshihans.practicalaboralsql.models.dto;

import com.satoshihans.practicalaboralsql.models.entity.Factura;

public class LineaDeServiciosDTO {
    private Long id;
    private Float importe;
    private Factura factura;

    /**
     * Contructor de Linea de Servicio
     * @param factura
     * @param id
     * @param importe
     */
    public LineaDeServiciosDTO(Factura factura, Long id, Float importe){
        this.factura = factura;
        this.id = id;
        this.importe = importe;
    }

    /**
     * Gets y Sets
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString(){
        return "Linea de Servicio: {" +
                    "id de Factura: " +factura.getId() +
                    "id de Servicio: " + id+
                    "importe: " +importe +
                    "}";
                    
    }

}
