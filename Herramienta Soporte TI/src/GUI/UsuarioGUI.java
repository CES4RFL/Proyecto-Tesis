package GUI;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import DP.LoginDP;
import DP.ReporteDP;
import ADP.UsuarioADP;


public class UsuarioGUI extends JFrame implements ActionListener{
	//Elementos del layout
	public Container layout;
	public JLabel lDatos;
	public JLabel lEquipo;
	public JLabel lNombre;
	public JLabel lDepartamento;
	public JLabel lDescripcion;
	public JTextArea taReporte;
	public JScrollPane spReporte;
    public JButton bAceptar;
    //Atributos 
	private String Sap;
	private String Sam;
	private String Sid;
	private String Snombre;
	private String Sdepartamento;
	private String Sequipo;
	
	public void UsuarioGUI(LoginDP dat){
		
		Snombre=dat.getNombre();
	    Sap=dat.getAp_paterno();
		Sam=dat.getAp_materno();
		Sid=Integer.toString(dat.getId());
		Sdepartamento=dat.getDepartamento();
	    Sequipo=Integer.toString(dat.getEquipo());
		
		
		layout= getContentPane();
	    layout.setLayout(null);
	    setResizable(false);
	    
	    lDatos=new JLabel("DATOS DEL USUARIO");
	    taReporte=new JTextArea();
	    taReporte.setLineWrap(true); 
	    taReporte.setWrapStyleWord(true); 
	    spReporte=new JScrollPane(taReporte);
	    spReporte.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	     
	    lNombre=new JLabel("ID Empleado: "+Sid+" Nombre: "+Snombre+" "+Sap+" "+Sam);
	    lDepartamento=new JLabel("Departamento: "+Sdepartamento);
	    lEquipo=new JLabel("Etuipo: "+Sequipo);
	    lDescripcion=new JLabel("DESCRIPCIÓN DEL PROBLEMA");
	    bAceptar=new JButton("Enviar");
	
	    lDatos.setBounds(10, 20, 120, 20);
	    lNombre.setBounds(10, 50, 400, 20);
	    lDepartamento.setBounds(10, 70, 400, 20);
	    lEquipo.setBounds(10, 90, 400, 20);
	    bAceptar.setBounds(10, 500, 120, 20);
	    lDescripcion.setBounds(10, 120, 400, 20);
	    spReporte.setBounds(10, 140, 380, 340);
	
	    

	    layout.add(lDatos);
	    layout.add(lNombre);
	    layout.add(spReporte);
	    layout.add(lDepartamento);
	    layout.add(lDescripcion);
	    layout.add(lEquipo);
	    layout.add(bAceptar);
	     
	     setTitle     ("Reporte");
	     setSize      ( 400,600 );
	     setLocation  ( 100,100 );
	     
	     bAceptar.addActionListener(this);
	      
	    
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	   if(arg0.getSource()==bAceptar){
		   
	      ReporteDP reporte=new ReporteDP();
	      reporte.setUsuario(Sid);
	      reporte.setNombre(Snombre);
	      reporte.setAp_paterno(Sap);
	      reporte.setAp_materno(Sam);
		  reporte.setDepartamento(Sdepartamento);
		  reporte.setEquipo(Sequipo);
		  reporte.setReporte(taReporte.getText());
		  
		  UsuarioADP datos_rep= new UsuarioADP(); 
		  datos_rep.UsuarioADP(reporte);
		  
		  System.out.println("Reporte subido");
		  dispose();
	   }
	
		
	}



}
