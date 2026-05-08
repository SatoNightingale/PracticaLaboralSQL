package com.satoshihans.practicalaboralsql.cliente;

import com.satoshihans.practicalaboralsql.localizacion.MunicipioDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {
    private String codigoId;
    private String telefono, nombre, direccion, email;
    private MunicipioDTO municipio;
}
