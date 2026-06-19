package com.satoshihans.practicalaboralsql.lineaservicio;

import java.sql.Connection;
import java.sql.SQLException;

import org.h2.api.Trigger;

public class ValidarImporteTrigger implements Trigger {

	@Override
	public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
		// Importe = 2, repartido = 3
		if((Double) newRow[2] > (Double) newRow[3]){
			throw new SQLException("Error: El monto repartido sobrepasa el importe total de la linea");
		}
	}

}
