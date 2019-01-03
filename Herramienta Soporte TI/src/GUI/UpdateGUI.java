package GUI;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import ADP.ReporteSetADP;

public class UpdateGUI extends JFrame implements ActionListener  {
	
	    public Container cContenedor;
	    public JLabel lNombre;
	    public JLabel lDatos;
	    public JTextArea taReporte;
	    public ResultSet resultado;
	    public JScrollPane scNoticia;
	    public JComboBox cbEstado;
	    public JButton bActualizar;
	    public JLabel lFecha;
	    public JLabel lImagen;
	   
		
		private String Sidus;
		private String Snombre;
		private String Sidrep;
		private String Sdepartamento;
		private String Sequipo;
		private String Descripcion;
	    private String Fecha;
	
	    
	    public void UpdateGUI(int reporte)  {
	    	
	        String[] sEstado = {"Pendiente", "Atendido"};
	        cContenedor = getContentPane();
	        cContenedor.setLayout(null);
	        setResizable(false);
	        
	        bActualizar= new JButton("Actualizar");
	        ReporteSetADP p = new ReporteSetADP();
	        resultado=p.Reporte_Sel(reporte);
	        
	        try {
	            while (resultado.next()) {
	            	
	                Object[] fila = new Object[8];
                    
	                Sidrep=resultado.getString(1);
	                Sequipo=resultado.getString(2);
	                Sidus=resultado.getString(3);
	                Snombre=resultado.getString(4);
	                Sdepartamento=resultado.getString(5);
	                Descripcion=resultado.getString(6);
	                Fecha=resultado.getString(7);
	            
	            }
	        }catch(SQLException ex) {
	            System.out.println("Error llenando tabla");
	        }
	          
	        lNombre=new JLabel("Empleado: "+Sidus+"         Nombre: "+Snombre);
	        lNombre.setBounds(10,20,500,20);
	        lDatos=new JLabel("Departamento: "+Sdepartamento+"     Equipo: "+Sequipo);
	        lDatos.setBounds(10,60,500,20);
	        taReporte=new JTextArea(Descripcion);
	        taReporte.setLineWrap(true); 
	        taReporte.setWrapStyleWord(true);
	        taReporte.setBounds(10,100,250,250);
	        lFecha=new JLabel(Fecha);
	        lFecha.setBounds(10,350,200,20);
	        scNoticia = new JScrollPane(taReporte);
	        scNoticia.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	   
	        cbEstado= new JComboBox(sEstado);
	        cbEstado.setBounds(300,250,80,30);
	        bActualizar.setBounds(300, 290, 100, 30);
	        
	        cContenedor.add(lNombre);
	        cContenedor.add(lDatos);
	        cContenedor.add(lFecha);
	        cContenedor.add(taReporte);
	        cContenedor.add(cbEstado);
	        cContenedor.add(bActualizar);


	        setTitle     ("Reporte");
	        setSize      ( 600,400 );
	        setLocation  ( 100,100 );
	        
	        bActualizar.addActionListener ( this );

	    }

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
	        
	    	if (arg0.getSource() == bActualizar){
				
					String estado= (String) cbEstado.getSelectedItem();
					String reporte= (String) taReporte.getText();
					ADP.UpdateADP l_up=new ADP.UpdateADP();
					l_up.Reporte_Sel(estado,reporte);
					dispose();
				    GUI.AdministradorGUI l_ad=new GUI.AdministradorGUI();
				    try {
						l_ad.AdministradorGUI();
						l_ad.setVisible(true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}	
	    }
	    

}
