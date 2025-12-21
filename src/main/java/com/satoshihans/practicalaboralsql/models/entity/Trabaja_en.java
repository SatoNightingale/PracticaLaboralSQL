package com.satoshihans.practicalaboralsql.models.entity;

public class Trabaja_en {
    private String idEspecialista, idServicio;
    private float importe;

    /**
     * Constructor de Trabaja_en 
     * @param idEspecialista
     * @param idServicio
     * @param importe
     */
    public Trabaja_en(String idEspecialista, String idServicio, float importe){
        this.idEspecialista = idEspecialista;
        this.idServicio = idServicio;
        this.importe = importe;
    }

    /**
     * Gets y Sets 
     */
    public String getIdEspecialista() {
        return idEspecialista;
    }
    public void setIdEspecialista(String idEspecialista) {
        this.idEspecialista = idEspecialista;
    }
    public String getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }
    public float getImporte() {
        return importe;
    }
    public void setImporte(float importe) {
        this.importe = importe;
    }
}
