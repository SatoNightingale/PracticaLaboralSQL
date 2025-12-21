package com.satoshihans.practicalaboralsql.models.entity;

public class Usuario {
    private String nombre, cod, gmail;

    /**
     * Contructor de Usuario
     * @param nombreU
     * @param cod
     */
    public Usuario(String nombre, String cod, String gmail){
        this.nombre = nombre;
        this.cod = cod;
        this.gmail = gmail;
    }

    /**
     * Getes y Setes
     */
    public void setNombreU(String nombre){this.nombre = nombre;}
    public void setCod(String cod){this.cod = cod;}
    public void setGmail(String gmail){this.gmail = gmail;}
    public String getNombreU(){return nombre;}
    public String getCod(){return cod;}
    public String getGmail(){return gmail;}
}
