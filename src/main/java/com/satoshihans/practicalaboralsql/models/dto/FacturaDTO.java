package com.satoshihans.practicalaboralsql.models.dto;

import com.satoshihans.practicalaboralsql.models.entity.Cliente;

public class FacturaDTO {
    private Long id; 
    private Cliente cliente;
    
    /**
     * Constructor de Factura
     * @param id
     * @param cliente
     */
    public FacturaDTO(Long id, Cliente cliente){
        this.id = id;
        this.cliente = cliente;
    }

    /**
     * Gets y Sets
     */
    public void setId(Long id) {
        this.id = id;
    }
    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Long getId() {
        return id;
    }
    public Cliente getIdCliente() {
        return cliente;
    }

    @Override
    public String toString(){
        return "Factura: {" +
                    "id: " +id+
                    "id de Cliente: " +cliente.getId()+
                    "}";
    }
}
