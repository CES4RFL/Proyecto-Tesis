package ADP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReporteSetADP {
	
    Statement mienunciado;
    ResultSet resultado;
    
    public ResultSet Reporte_Sel(int reporte){
    	
        String lreport=Integer.toString(reporte);
    	ConexionADP conexion = new ConexionADP();
        String Query = "SELECT id_reporte,id_equipo,id_usuario,nombre,departamento,descripcion,fecha FROM Reporte WHERE id_reporte="+lreport;
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
