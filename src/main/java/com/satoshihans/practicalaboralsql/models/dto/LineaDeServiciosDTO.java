package com.satoshihans.practicalaboralsql.models.dto;

public class LineaDeServiciosDTO {
    private String idFactura, idServicio;

    /**
     * Contructor de Linea de Servicio
     * @param idFactura
     * @param idServicio
     */
    public LineaDeServiciosDTO(String idFactura, String idServicio){
        this.idFactura = idFactura;
        this.idServicio = idServicio;
    }

    /**
     * Gets y Sets
     */
    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
    public void setId(String idFactura) {
        this.idFactura = idFactura;
    }
    public String getId() {
        return idFactura;
    }
    public String getIdServicio() {
        return idServicio;
    }

    @Override
    public String toString(){
        return "Linea de Servicio: {" +
                    "id de Factura: " +idFactura +
                    "id de Servicio: " + idServicio+
                    "}";
                    
    }
}
