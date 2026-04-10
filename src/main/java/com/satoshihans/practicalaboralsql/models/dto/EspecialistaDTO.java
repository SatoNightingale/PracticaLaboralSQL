package com.satoshihans.practicalaboralsql.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecialistaDTO {
    private Long id;
    private String nombre, especialidad;
    private Long idDepartamento;

    // public static EspecialistaDTO fromEntity(Especialista entity){
    //     return new EspecialistaDTO(
    //         entity.getId(),
    //         entity.getNombre(),
    //         entity.getEspecialidad(),
    //         entity.getDepartamento().getId()
    //     );
    // }
}
