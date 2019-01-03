package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ADP.AdminADP;


public class AdministradorGUI extends JFrame implements ActionListener {
    public Container Layout;
    public JTable taColumnista;
    public JScrollPane scColumnista;
    public JLabel lUser;
    public JButton btSalir;
    public DefaultTableModel modelo;
    public ResultSet resultado;
    public String user_send;
    public UpdateGUI l;
    
    public void AdministradorGUI() throws IOException  { 

        Layout = getContentPane();
        Layout.setLayout( null );
        setResizable(false);
        
        lUser=new JLabel();
        lUser.setText("Reportes");
        lUser.setBounds(10,20,120,20);
        Layout.add(lUser);
        JButton editar=new JButton("Editar");
        
        modelo= new DefaultTableModel();
        
        taColumnista = new JTable(modelo) {
	        @Override
	        public boolean isCellEditable(int row, int col) {return false;} 
        };

        modelo.addColumn("Folio");
        modelo.addColumn("Equipo");
        modelo.addColumn("Id Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Departamento");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Ver");
        
        AdminADP p = new AdminADP();
        
        resultado=p.Editor_Sel();
        try {
            while (resultado.next()) {
                Object[] fila = new Object[9];

                fila[0]=resultado.getObject(1);
                fila[1]=resultado.getObject(2);
                fila[2]=resultado.getObject(3);
                fila[3]=resultado.getObject(4);
                fila[4]=resultado.getObject(5);
                fila[5]=resultado.getObject(6);
                fila[6]=resultado.getObject(7);
                fila[7]=resultado.getObject(8);
                fila[8]=editar;

                modelo.addRow(fila);
            }
        }catch(SQLException ex) {
            System.out.println("Error llenando tabla");
        }
        
        taColumnista.setDefaultRenderer(Object.class,new Render());
        taColumnista.setDefaultRenderer(Object.class,new Render());
        taColumnista.setRowHeight(30);
        
        scColumnista= new JScrollPane(taColumnista);
        scColumnista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  
        btSalir=new JButton("Salir");
        
        scColumnista.setBounds(10, 50,770,250);
   
        btSalir.setBounds(10,300,160,50);
        
        Layout.add(scColumnista);
   
        Layout.add(btSalir);


        setTitle     ("Reportes");
        setSize      ( 800,450 );
        setLocation  ( 100,100 );
        setEventoMouseClicked(taColumnista);
    
       } 
    
   private void setEventoMouseClicked(JTable tbl){
        
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
            
                    tablaMouseClicked(e);
               
            }
        }
        );
    }
   
    
    private void  tablaMouseClicked(java.awt.event.MouseEvent evt){
        int reporte;
        int clic_tabla = 0;
        int colum=taColumnista.getColumnModel().getColumnIndexAtX(evt.getX());
        int row=evt.getY()/taColumnista.getRowHeight();
        
        clic_tabla = this.taColumnista.rowAtPoint(evt.getPoint());
        reporte = (int)taColumnista.getValueAt(clic_tabla, 0);

            if(row < taColumnista.getRowCount() && row >= 0 && colum < taColumnista.getColumnCount() && colum >= 0){
            Object value=taColumnista.getValueAt(row, colum);
	            if(value instanceof JButton){
	                ((JButton)value).doClick();
	                JButton boton=(JButton)value;
	                l=new UpdateGUI();
	                l.UpdateGUI(reporte);
	                l.setVisible(true);
	                dispose();
	            }
            }
        }
    
    public class Render extends DefaultTableCellRenderer {
    	
    	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){
      
        
       if (value instanceof JButton) {
		      JButton bver=(JButton)value;
		      return bver;
		    }else{ 
	    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);}
    	}
    	
    	public Component getTableCellRendererComponent1(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){
    	    JLabel cell=(JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    	    
    	    if(value instanceof String){
    	        String columna= (String) value;
    	    	if(column==7){
    	    		if(columna.equals("Pendiete")){
    	    			cell.setBackground(Color.RED);
    	    			cell.setForeground(Color.WHITE);	
    	    		}if(columna.equals("Pendiete")){
    	    			cell.setBackground(Color.WHITE);
    	    			cell.setForeground(Color.BLACK);
    	    		}
    	    		
    	    	}
    	    	
    	       }
			return cell;
    	}
    }
    	 

 
	@Override
	public void actionPerformed(ActionEvent arg0) {

		
	}

}
