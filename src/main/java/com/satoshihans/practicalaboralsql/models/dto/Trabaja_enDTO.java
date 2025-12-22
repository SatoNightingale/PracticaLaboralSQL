package com.satoshihans.practicalaboralsql.models.dto;

import com.satoshihans.practicalaboralsql.models.entity.Especialista;
import com.satoshihans.practicalaboralsql.models.entity.LineaDeServicios;

public class Trabaja_enDTO {
    private LineaDeServicios lineaDeServicios;
    private Especialista especialista;
    private Float importe;

    /**
     * Constructor de Trabaja_en 
     * @param especialista
     * @param lineaDeServicios
     * @param importe
     */
    public Trabaja_enDTO(Especialista especialista, LineaDeServicios lineaDeServicios, Float importe){
        this.especialista = especialista;
        this.lineaDeServicios = lineaDeServicios;
        this.importe = importe;
    }

    /**
     * Gets y Sets 
     */
    public LineaDeServicios getLineaDeServicios() {
        return lineaDeServicios;
    }
    public void setLineaDeServicios(LineaDeServicios lineaDeServicios) {
        this.lineaDeServicios = lineaDeServicios;
    }
    public Especialista getEspecialista() {
        return especialista;
    }
    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
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
                    "id de Servicio: " +lineaDeServicios.getId()+
                    "id de Especialista: " +especialista.getId()+
                    "importe: " +importe+
                    "}";
    }

}
