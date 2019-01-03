package ADP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateADP {
	
    Statement mienunciado;
    ResultSet resultado;
    
    public void Reporte_Sel(String Estado,String Reporte){
    	
   
    	ConexionADP conexion = new ConexionADP();
        String Query = "UPDATE Reporte SET estado=? Where descripcion='"+Reporte+"'";
       
      
       PreparedStatement ps;
          
       try{
           ps = conexion.miconexion.prepareStatement(Query);
           ps.setString(1,Estado);
           ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println("Error en el up");
       }
     }

}
