package com.satoshihans.practicalaboralsql.autenticacion;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaLoginDTO {
	String token;
	Long id;
	String nombreUsuario;
}
