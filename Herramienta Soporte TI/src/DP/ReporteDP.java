package DP;

public class ReporteDP {
	
	 String nombre;
	 String ap_paterno;
	 String ap_materno;
	 String departamento;
	 String reporte;
	 String id_equipo; 
	 String id_usuario;

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
	 public String getReporte(){
		 return reporte;
	 }
	 public String getEquipo(){
		 return id_equipo;
	 }
	 public String getId(){
		 return id_usuario;
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
	 public void setReporte(String l_reporte){
		 this.reporte=l_reporte;
	 }
	 public void setDepartamento(String l_departamento){
		 this.departamento=l_departamento;
	 }
	 public void setUsuario(String id){
		 this.id_usuario=id;
	 }
	 public void setEquipo(String l_equipo){
		 this.id_equipo=l_equipo;
	 }
}
