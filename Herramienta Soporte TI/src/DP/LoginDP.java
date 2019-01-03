package DP;

public class LoginDP {
	
	 String username;
	 String password;
	 String perfil;
	 String nombre;
	 String ap_paterno;
	 String ap_materno;
	 String departamento;
	 int id_equipo; 
	 int id_usuario;
	
	 //geters
	 public String getUserName(){
		 return username;
	 }
	 public String getPassword(){
		 return password;
	 }
	 public String getPerfil(){
		 return perfil;
	 }
	 public String getNombre(){
		 return nombre;
	 }
	 public String getAp_paterno(){
		 return ap_paterno;
	 }
	 public String getAp_materno(){
		 return ap_materno;
	 }
	 public String getDepartamento(){
		 return departamento;
	 }
	 public int getEquipo(){
		 return id_equipo;
	 }
	 public int getId(){
		 return id_usuario;
	 }
	
	 //setters
	 public void setUsername(String l_username){
		 this.username=l_username;
	 }
	 public void setPassword(String l_password){
		 this.password=l_password;
	 }
	 public void setPerfil(String l_perfil){
		 this.perfil=l_perfil;
	 }
	 public void setNombre(String l_nombre){
		 this.nombre=l_nombre;
	 }
	 public void setAp_paterno(String l_app){
		 this.ap_paterno=l_app;
	 }
	 public void setAp_materno(String l_apm){
		 this.ap_materno=l_apm;
	 }
	 public void setDepartamento(String l_departamento){
		 this.departamento=l_departamento;
	 }
	 public void setUsuario(int l_usuario){
		 this.id_usuario=l_usuario;
	 }
	 public void setEquipo(int l_equipo){
		 this.id_equipo=l_equipo;
	 }
	 
	 
	
	 

}
