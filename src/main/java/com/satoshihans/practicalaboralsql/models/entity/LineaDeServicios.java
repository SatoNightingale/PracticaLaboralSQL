package com.satoshihans.practicalaboralsql.models.entity;

public class LineaDeServicios {
    private String idFactura, idServicio;

    /**
     * Contructor de Linea de Servicio
     * @param idFactura
     * @param idServicio
     */
    public LineaDeServicios(String idFactura, String idServicio){
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
}
