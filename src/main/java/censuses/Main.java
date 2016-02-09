package censuses;

import java.sql.Connection;
import java.sql.SQLException;

import censuses.persistence.Jdbc;

public class Main {

	public static void main(String[] args) {
		
		String nombreFichero;
		
		try {
			Connection con = Jdbc.getConnection();
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Base de Datos no disponible");
		}
		
	}

}
