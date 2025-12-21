package com.satoshihans.practicalaboralsql.models.dto;


public class FacturaDTO {
    private String id, idCliente;
    
    /**
     * Constructor de Factura
     * @param id
     * @param idCliente
     */
    public FacturaDTO(String id, String idCliente){
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

    @Override
    public String toString(){
        return "Factura: {" +
                    "id: " +id+
                    "id de Cliente: " +idCliente+
                    "}";
    }
}
