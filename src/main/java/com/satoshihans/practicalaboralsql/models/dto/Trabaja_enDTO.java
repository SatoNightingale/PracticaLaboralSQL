package com.satoshihans.practicalaboralsql.models.dto;

public class Trabaja_enDTO {
    private String idEspecialista, idServicio;
    private Float importe;

    /**
     * Constructor de Trabaja_en 
     * @param idEspecialista
     * @param idServicio
     * @param importe
     */
    public Trabaja_enDTO(String idEspecialista, String idServicio, Float importe){
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
    public Float getImporte() {
        return importe;
    }
    public void setImporte(Float importe) {
        this.importe = importe;
    }

    @Override
    public String toString(){
        return "Traba en: {" +
                    "id de Servicio: " +idServicio+
                    "id de Especialista: " +idEspecialista+
                    "importe: " +importe+
                    "}";
    }
}
