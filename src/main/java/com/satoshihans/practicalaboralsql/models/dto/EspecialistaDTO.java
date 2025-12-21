package com.satoshihans.practicalaboralsql.models.dto;

public class EspecialistaDTO {
    private String nombre, idDepartamento, especialidad;

    /**
     * Contructor de Especialista
     * @param nombre
     * @param idDepartamento
     * @param especialidad
     */
    public EspecialistaDTO(String nombre, String idDepartamento, String especialidad){
        this.nombre = nombre;
        this.idDepartamento = idDepartamento;
        this.especialidad = especialidad;
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
    public String getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString(){
        return "Especialista: {"+
                    "nombre: " +nombre+
                    "id de Departamento: " +idDepartamento+
                    "especialidad: " +especialidad+
                    "}";
    }
}
