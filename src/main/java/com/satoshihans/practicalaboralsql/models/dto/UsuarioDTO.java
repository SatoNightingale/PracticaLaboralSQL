package com.satoshihans.practicalaboralsql.models.dto;

public class UsuarioDTO {
    private String nombre, cod, gmail;

    /**
     * Contructor de Usuario
     * @param nombreU
     * @param cod
     */
    public UsuarioDTO(String nombre, String cod, String gmail){
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

    @Override
    public String toString(){
        return "Usuario: {" +
                    "nombre: " +nombre+
                    "gmail: " + gmail+
                    "cood: " +cod+
                    "}";
    }
}
