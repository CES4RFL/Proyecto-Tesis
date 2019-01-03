package ADP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DP.LoginDP;

public class LoginADP {
	
    Statement mienunciado;
    ResultSet resultado;

	public LoginDP Login(LoginDP dat) {
		
		
		ConexionADP conexion= new ConexionADP();
		String Query = "SELECT * FROM "+dat.getPerfil()+" where USERNAME='" + dat.getUserName() + "' and PASS='" + dat.getPassword() + "'";
		String resultadoBusqueda = "";
		
			try {
				mienunciado =conexion.miconexion.createStatement();
				resultado = mienunciado.executeQuery(Query);
				
				if(dat.getPerfil()=="EMPLEADO"){
					while (resultado.next()) {
						int Id=resultado.getInt(1);
						String Departamento = resultado.getString(2);
						int Equipo = resultado.getInt(3);
						String Nombre = resultado.getString(4);
						String AP = resultado.getString(5);
						String AM = resultado.getString(6);
						dat.setDepartamento(Departamento);
						dat.setEquipo(Equipo);
						dat.setUsuario(Id);
					    dat.setNombre(Nombre);
					    dat.setAp_paterno(AP);
					    dat.setAp_materno(AM);
						
					}
			     }
				
				if(dat.getPerfil()=="ADMINISTRADOR"){
					while (resultado.next()) {
						
						String Nombre = resultado.getString(1);
					    dat.setNombre(Nombre);
					    
						
					}
			     }
					
					
			

			}catch(SQLException sqle){
				    System.out.println(sqle + "\nError en la consulta");
			}
			System.out.println(resultadoBusqueda);
			return dat;
			
	}


}
