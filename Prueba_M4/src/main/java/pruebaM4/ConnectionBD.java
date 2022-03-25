package pruebaM4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

	private static final String Ctrl = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/employees";
	private static final String user = "root";
	private static final String contra = "22111998";
	
	protected static Connection ConexionMySQL() {
		Connection conex =  null;
		try {
			
			Class.forName(Ctrl);
			conex = DriverManager.getConnection(url,user,contra); //local,usuario,contraseña
			
		}catch(ClassNotFoundException error) {
			System.out.println("No se pudo cargar la base de datos");
			error.getStackTrace();
			
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return conex;
	}
}
