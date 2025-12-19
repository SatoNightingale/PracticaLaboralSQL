package com.satoshihans.practicalaboralsql.models;

public class Cliente {
    private String idCliente, nombre, direccion, gmal;
    private int telefono;

    /**
     * Contructor de Cliente
     * @param idCliente
     * @param nombre
     * @param direccion
     * @param gmal
     * @param telefono
     */
    public Cliente(String idCliente, String nombre, String direccion, String gmal, int telefono){
        this.nombre = nombre;
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.gmal = gmal;
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
    public void setGmal(String gmal) {
        this.gmal = gmal;
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
    public String getGmal() {
        return gmal;
    }
    public int getTelefono() {
        return telefono;
    }
}
