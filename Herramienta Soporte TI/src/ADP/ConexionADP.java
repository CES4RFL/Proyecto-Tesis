package ADP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionADP {
	
	Connection miconexion;
	
		public ConexionADP() {
			try {
				String url = "jdbc:mysql://localhost:3306/proyect1";
				String usuario = "root";
				String password = "";
				
				miconexion = DriverManager.getConnection(url, usuario, password);
				
				System.out.println("Conexion exitosa con Mysql periodico");
			}catch(SQLException sqe) {
			    System.out.println("Error de conexion"+sqe);
			}
		}

}
