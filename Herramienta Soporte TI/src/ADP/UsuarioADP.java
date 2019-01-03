package ADP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DP.ReporteDP;

public class UsuarioADP {
	
    Statement mienunciado;
    ResultSet resultado;
    
    public void UsuarioADP (ReporteDP datos) {
    	
    	ConexionADP conexion = new ConexionADP();
    	String Query = "Insert into Reporte(id_reporte,id_usuario,nombre,departamento,id_equipo,descripcion,estado,fecha)"
    			+ "values(NULL,?,?,?,?,?,?,SYSDATE());";
        PreparedStatement ps;
        
        
        try{
            ps = conexion.miconexion.prepareStatement(Query);
            ps.setString(1,datos.getId());
            ps.setString(2,datos.getNombre()+" "+datos.getAp_paterno()+" "+datos.getAp_materno());
            ps.setString(3,datos.getDepartamento());
            ps.setString(4,datos.getEquipo());
            ps.setString(5,datos.getReporte());
            ps.setString(6,"Pendiete");
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error en el insert" + ex);
        }
    	
    }

}
