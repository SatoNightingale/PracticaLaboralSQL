package com.satoshihans.practicalaboralsql.models.entity;

public class Provincia {
    private String id, nombre;

    /**
     * Contructor de Provincia
     * @param id
     * @param nombre
     */
    public Provincia(String id, String nombre){
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
}
