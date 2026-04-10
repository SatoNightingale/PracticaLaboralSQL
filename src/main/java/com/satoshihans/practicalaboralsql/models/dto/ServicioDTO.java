package com.satoshihans.practicalaboralsql.models.dto;

import com.satoshihans.practicalaboralsql.models.entity.Servicio;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicioDTO {
    private Long id;
    private String nombre, descripcion;

    public static ServicioDTO fromEntity(Servicio entity){
        return new ServicioDTO(
            entity.getId(), 
            entity.getNombre(), 
            entity.getDescripcion()
        );
    }
}
