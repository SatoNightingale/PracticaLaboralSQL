package com.satoshihans.practicalaboralsql.models;

import java.util.List;

public class Factura {
    private String id, idCliente;
    private float importe;
    //aqui no se si hacer una lista con los id o con las lineas de sericios
    private List<LineaDeServicios> lineaDeServiciosList;

    /**
     * Constructor de Facturas
     * @param id
     * @param idCliente
     * @param importe
     * @param lineaDeServiciosList
     */
    public Factura(String id, String idCliente, float importe, List<LineaDeServicios> lineaDeServiciosList){
        this.id = id;
        this.idCliente = idCliente;
        this.importe = importe;
        this.lineaDeServiciosList = lineaDeServiciosList;
    }

    /**
     * Gets y Sets
     */
    public void setId(String id) {
        this.id = id;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public void setImporte(float importe) {
        this.importe = importe;
    }
    public void setLineaDeServiciosList(List<LineaDeServicios> lineaDeServiciosList) {
        this.lineaDeServiciosList = lineaDeServiciosList;
    }
    public String getId() {
        return id;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public float getImporte() {
        return importe;
    }
    public List<LineaDeServicios> getLineaDeServiciosList() {
        return lineaDeServiciosList;
    }
}
