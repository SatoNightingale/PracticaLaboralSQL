package com.satoshihans.practicalaboralsql.models;

public class LineaDeServicios {
    private String id, idServicio;
    private float importe;

    /**
     * Contructor de Linea de Servicios
     * @param id
     * @param idServicio
     * @param importe
     */
    public LineaDeServicios(String id, String idServicio, float importe){
        this.id = id;
        this.idServicio = idServicio;
        this.importe = importe;
    }

    /**
     * Gets y Sets
     */
    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setImporte(float importe) {
        this.importe = importe;
    }
    public String getId() {
        return id;
    }
    public String getIdServicio() {
        return idServicio;
    }
    public float getImporte() {
        return importe;
    }
}
