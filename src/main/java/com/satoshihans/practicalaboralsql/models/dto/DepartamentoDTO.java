package com.satoshihans.practicalaboralsql.models.dto;

public class DepartamentoDTO {
    private String nombre, direccion;
    private Long id;

    /**
     * Contructor de Departamento
     * @param nombre
     * @param direccion
     * @param id
     */
    public DepartamentoDTO(String nombre, String direccion, Long id){
        this.nombre = nombre;
        this.direccion = direccion;
        this.id = id;
    }

    /**
     * Gets y Sets
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        return "Departamento: {" +
                    "nombre: " + nombre +
                    "direccion: " +direccion+
                    "id: " +id+
                    "}";
    }
}
