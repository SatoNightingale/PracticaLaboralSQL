package com.satoshihans.practicalaboralsql.models.entity;

public class Servicios {
    private String idServicio, nombre, descripcion;

    /**
     * Contructor de Servicio
     * @param idServicio
     * @param nombre
     * @param descripcion
     */
    public Servicios(String idServicio, String nombre, String descripcion){
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Gets y Sets
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public String getIdServicio() {
        return idServicio;
    }
    public String getDescripcion() {
        return descripcion;
    }
}
