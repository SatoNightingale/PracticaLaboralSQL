package com.satoshihans.practicalaboralsql.models.entity;

public class Municipio {
    private String idP, id, nombre;

    /**
     * Contructor de Municipio
     * @param idP
     * @param id
     * @param nombre
     */
    public Municipio(String idP, String id, String nombre){
        this.nombre = nombre;
        this.idP = idP;
        this.id = id;
    }

    /**
     * Gets y Sets
     */
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setId(String id){this.id = id;}
    public void setIdP(String idP){this.idP = idP;}
    public String getNombre(){return nombre;}
    public String getId(){return id;}
    public String getIdP(){return idP;}
}
