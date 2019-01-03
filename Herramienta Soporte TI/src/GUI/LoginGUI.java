package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import ADP.LoginADP;
import DP.LoginDP;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame implements ActionListener{ 
	
	public Container   cContenedor ;
	public JLabel      lUser;
	public JTextField  tfUser;
	public JLabel      lPass;
	public JPasswordField  tfPass;
	public JButton     bAceptar;
	public JComboBox   cbPerfiles;
	public UsuarioGUI usuario= new UsuarioGUI(); 
	public AdministradorGUI admin= new AdministradorGUI(); 
		
	public  LoginGUI() throws IOException {
	
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		String[] sPerfiles = {"EMPLEADO", "ADMINISTRADOR" };
		cContenedor = getContentPane();
		cContenedor.setLayout( null );
		setResizable(false);
		cbPerfiles= new JComboBox(sPerfiles); 
		lUser = new JLabel(); 
		tfUser = new JTextField();
		lPass = new JLabel(); 
		tfPass = new JPasswordField();
		bAceptar= new JButton();
		
		lUser.setText( "Usuario" );
		lPass.setText( "Password" );
		bAceptar.setText( "Aceptar" );
		lUser.setBounds (10, 20,80,30 );
		tfUser.setBounds (100,20,125,30); 
		lPass.setBounds (10,60,80, 30 );
		tfPass.setBounds (100,60,125,30); 
		bAceptar.setBounds (35,150, 160, 50);
		cbPerfiles.setBounds (10,100,100,30);
		
		                  //Agrega componentes al Contenedor
		cContenedor.add ( lUser );
		cContenedor.add ( tfUser );
		cContenedor.add ( lPass );
		cContenedor.add ( tfPass );
		cContenedor.add ( bAceptar );
		cContenedor.add (cbPerfiles);
		
		
		setTitle     ("Login");
	    setSize      ( 250,250 );
	    setLocation  ( 100,100 );
	    bAceptar.addActionListener ( this );
		
	
	}
	    
    @Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == bAceptar){
			try {
				Valida();
			}catch(IOException e) {
				System.out.println("Eror en la validacion");
			}
		}	
	}
	    	
   public void Valida() throws IOException{
	   LoginDP cliente = new LoginDP();
	   cliente.setUsername(tfUser.getText());
	   cliente.setPassword(tfPass.getText());
	   cliente.setPerfil( (String) cbPerfiles.getSelectedItem());
	   
	   LoginADP loginadp= new LoginADP();
	   
	   LoginDP busqueda=loginadp.Login(cliente);
	   
	   if(busqueda.getNombre()!= null){
			
			if(cliente.getPerfil()=="EMPLEADO"){
				usuario.UsuarioGUI(busqueda);
				usuario.setVisible(true);
				System.out.println("Bienvenido");
				dispose();
			}else if(cliente.getPerfil()=="ADMINISTRADOR"){
				admin.AdministradorGUI();
			    admin.setVisible(true);
			    System.out.println("Bienvenido");
				dispose();
			}
	   }else{
		   
			System.out.println("Rechazado");	
		
	   }  
   }  
}
