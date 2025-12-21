package com.satoshihans.practicalaboralsql.models.dto;

public class ClienteDTO {
    private String idCliente, nombre, direccion, gmail;
    private int telefono;

    /**
     * Contructor de Cliente
     * @param idCliente
     * @param nombre
     * @param direccion
     * @param gmal
     * @param telefono
     */
    public ClienteDTO(String idCliente, String nombre, String direccion, String gmail, int telefono){
        this.nombre = nombre;
        this.idCliente = idCliente;
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
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public String getGmail() {
        return gmail;
    }
    public int getTelefono() {
        return telefono;
    }


    @Override
    public String toString(){
        return "Cliente: {" +
                    "nombre: " + nombre +
                    "gmail: " + gmail +
                    "direccion: " + direccion +
                    "telefono: " + telefono +
                    "id de Cliendte: " + idCliente +
                    "}"; 
    }
}
