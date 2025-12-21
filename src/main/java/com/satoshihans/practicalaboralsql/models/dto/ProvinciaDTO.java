package com.satoshihans.practicalaboralsql.models.dto;

public class ProvinciaDTO {
    private String id, nombre;

    /**
     * Contructor de Provincia
     * @param id
     * @param nombre
     */
    public ProvinciaDTO(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Gets y Sets
     */
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setId(String id){this.id = id;}
    public String getNombre(){return nombre;}
    public String getId(){return id;}

    @Override
    public String toString(){
        return "Provincia: {" +
                    "nombre: " +nombre+
                    "id: " +id+
                    "}";
    }
}
