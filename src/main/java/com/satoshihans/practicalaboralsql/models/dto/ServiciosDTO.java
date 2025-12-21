package com.satoshihans.practicalaboralsql.models.dto;

public class ServiciosDTO {
    private String idServicio, nombre, descripcion;

    /**
     * Contructor de Servicio
     * @param idServicio
     * @param nombre
     * @param descripcion
     */
    public ServiciosDTO(String idServicio, String nombre, String descripcion){
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Gets y Sets
     */
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setIdServicio(String idServicio){this.idServicio = idServicio;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
    public String getNombre(){return nombre;}
    public String getIdServicio(){return idServicio;}
    public String getDescripcion(){return descripcion;}

    @Override
    public String toString(){
        return "Servicio: {" +
                    "nombre: " +nombre+
                    "id de Servicio: " +idServicio+
                    "descripcion: " +descripcion+
                    "}";
    }
}
