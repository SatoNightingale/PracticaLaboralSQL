package com.satoshihans.practicalaboralsql.models.dto;

public class EmpleadosDTO {
    private String nombre, apellido, direccion, puesto;
    private Integer edad, telefono, id;

    public EmpleadosDTO(String nombre, String apellido, String direccion, String puesto, Integer edad, Integer telefono, Integer id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.puesto = puesto;
        this.edad = edad;
        this.telefono = telefono;
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Empleado: {" +
                    "nombre: " +nombre+
                    "apellido: "+apellido+
                    "direccion: " +direccion+
                    "puesto: " +puesto+
                    "edad: " +edad+
                    "telefono: " +telefono+
                    "id: " +id+
                    "}";
    }
}
