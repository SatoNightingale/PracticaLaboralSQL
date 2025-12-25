package com.satoshihans.practicalaboralsql.models.dto;

public class ClienteDTO {
    private Long id;
    private String telefono, nombre, direccion, gmail;
    

    /**
     * Contructor de Cliente
     * @param idCliente
     * @param nombre
     * @param direccion
     * @param gmal
     * @param telefono
     */
    public ClienteDTO(String telefono, String nombre, String direccion, String gmail, Long id){
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.gmail = gmail;
        this.telefono = telefono;
    }

    /**
     * Gets y Sets
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public Long getId() {
        return id;
    }
    public String getGmail() {
        return gmail;
    }
    public String getTelefono() {
        return telefono;
    }


    @Override
    public String toString(){
        return "Cliente: {" +
                    "nombre: " + nombre +
                    "gmail: " + gmail +
                    "direccion: " + direccion +
                    "telefono: " + telefono +
                    "id de Cliendte: " + id +
                    "}"; 
    }
}
