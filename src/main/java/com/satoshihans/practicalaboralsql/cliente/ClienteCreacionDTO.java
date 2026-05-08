package com.satoshihans.practicalaboralsql.cliente;

import com.satoshihans.practicalaboralsql.localizacion.MunicipioCreacionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteCreacionDTO {
    private String Id;
    private String telefono, nombre, direccion, email;
    private Long idMunicipio;
    private MunicipioCreacionDTO municipioCreacion;
}
