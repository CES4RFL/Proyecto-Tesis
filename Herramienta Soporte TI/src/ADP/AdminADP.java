package ADP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminADP {
	
    Statement mienunciado;
    ResultSet resultado;
    
    public ResultSet Editor_Sel(){
        
    	ConexionADP conexion = new ConexionADP();
        String Query = "SELECT id_reporte,id_equipo,id_usuario,nombre,departamento,descripcion,fecha,estado FROM Reporte";
        try {
            mienunciado = conexion.miconexion.createStatement();
            resultado = mienunciado.executeQuery(Query);
            System.out.println("ejecutado");
            return resultado;
        }catch (SQLException sqle) {
            System.out.println(sqle + "\nError en la consulta");
        }
        return null;
     }
}
