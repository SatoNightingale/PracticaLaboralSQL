package com.satoshihans.practicalaboralsql.models.dto;

import com.satoshihans.practicalaboralsql.models.entity.Departamento;

public class EspecialistaDTO {
    private String nombre, especialidad;
    private Long id;
    private Departamento departamento;

    /**
     * Contructor de Especialista
     * @param nombre
     * @param departamento
     * @param especialidad
     * @param id
     */
    public EspecialistaDTO(String nombre, Departamento departamento, String especialidad, Long id){
        this.nombre = nombre;
        this.departamento = departamento;
        this.especialidad = especialidad;
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
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Especialista: {"+
                    "nombre: " +nombre+
                    "especialidad: " +especialidad+
                    "id: " +id+
                    "id de Departamento: " +departamento.getId()+
                    "}";
    }
}
