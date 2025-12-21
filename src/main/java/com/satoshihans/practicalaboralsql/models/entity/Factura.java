package com.satoshihans.practicalaboralsql.models.entity;


public class Factura {
    private String id, idCliente;
    
    /**
     * Constructor de Factura
     * @param id
     * @param idCliente
     */
    public Factura(String id, String idCliente){
        this.id = id;
        this.idCliente = idCliente;
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
    public String getId() {
        return id;
    }
    public String getIdCliente() {
        return idCliente;
    }
}
