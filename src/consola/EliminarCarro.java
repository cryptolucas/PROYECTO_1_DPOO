package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EliminarCarro extends JFrame implements ActionListener {
	
	
	private JLabel lblTexto1;
	private JLabel lblCentro;
	private JLabel lblNorte;
	private JLabel lblSur;
	private JLabel lblNada;
	
	
	private JLabel lblTexto2;
	private JTextField modelo;
	
	
	private JCheckBox checkBoxCentro;
    private JCheckBox checkNorte;
    private JCheckBox checkSur;
    private ButtonGroup buttonGroup;
    
    
    private JButton boton_eliminar;
    private Principal principal;
    
    private ButtonModel selected_tipoveh;
    private ButtonModel selected_sede;

	
	public EliminarCarro(Principal p_principal) {
		principal = p_principal;
		setTitle("Eliminar Carro del Inventario");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setLayout(new BorderLayout());
        
        JPanel panel_izq = new JPanel();
        panel_izq.setLayout(new GridLayout(4,2,10,10));
        JPanel panel_der = new JPanel();
        panel_der.setLayout(new GridLayout(3,1,10,10));
        
        
        lblTexto1 = new JLabel("Selecciona la sede de la que eliminará el carro: ");
        lblTexto1.setFont(new Font("Arial", Font.BOLD, 18));
        lblTexto1.setForeground( Color.BLACK );
        lblTexto1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblTexto1);
        
        lblNada = new JLabel("");
        panel_izq.add(lblNada);
        
        lblCentro = new JLabel("1. Centro ");
        lblCentro.setFont(new Font("Arial", Font.BOLD, 15));
        lblCentro.setForeground( Color.BLACK );
        lblCentro.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblCentro);
        
        checkBoxCentro = new JCheckBox();
        panel_izq.add(checkBoxCentro);
        
        
        lblNorte = new JLabel("2. Norte ");
        lblNorte.setFont(new Font("Arial", Font.BOLD, 15));
        lblNorte.setForeground( Color.BLACK );
        lblNorte.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblNorte);
        
        checkNorte= new JCheckBox();
        panel_izq.add(checkNorte);
        
        lblSur = new JLabel("3. Sur ");
        lblSur.setFont(new Font("Arial", Font.BOLD, 15));
        lblSur.setForeground( Color.BLACK );
        lblSur.setHorizontalAlignment(SwingConstants.CENTER);
        panel_izq.add(lblSur);
        
        checkSur = new JCheckBox();
        panel_izq.add(checkSur);
        
        add(panel_izq, BorderLayout.WEST);
        
        
        lblTexto2 = new JLabel("Ingrese el nombre del modelo del carro a eliminar: ");
        lblTexto2.setFont(new Font("Arial", Font.BOLD, 18));
        lblTexto2.setForeground( Color.BLACK );
        lblTexto2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_der.add(lblTexto2);
                
        modelo = new JTextField("");
        panel_der.add(modelo);
        
        
               

        boton_eliminar = new JButton("ELIMINAR VEHICULO");
        boton_eliminar.setPreferredSize(new Dimension(50, 50));
        boton_eliminar.setBackground( Color.BLUE );
        boton_eliminar.setForeground( Color.WHITE );
        panel_der.add(boton_eliminar);
        
       
        buttonGroup = new ButtonGroup();
        buttonGroup.add(checkBoxCentro);  
        buttonGroup.add(checkNorte); 
        buttonGroup.add(checkSur); 
        
        add(panel_der, BorderLayout.EAST);
        
        boton_eliminar.addActionListener(this);
        boton_eliminar.setActionCommand("Eliminar_vehiculo");
        
        
        JPanel panel_libre = new JPanel();
        panel_libre.add(Box.createRigidArea(new Dimension(50, 250)));
        add(panel_libre, BorderLayout.CENTER);
        
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(250, 200)));
        add(panelVentanaPrincipalAba, BorderLayout.NORTH);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 200)));
        add(panelVentanaPrincipalArr, BorderLayout.SOUTH);
        
       
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Eliminar_vehiculo".equals(e.getActionCommand())) {
			try {
				principal.EliminarCarro(modelo.getText(), getSede());
				
				JOptionPane.showMessageDialog(null, "Eliminaste correctamente el vehiculo del inventario!!!", 
						"Eliminar vehiculo Don German", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
			}
		}
	}
	
	
	
	
	
	
	public String getSede() {
		selected_sede = buttonGroup.getSelection();
		if (selected_sede == checkBoxCentro.getModel()) 
			return "centro";
		else if (selected_sede == checkNorte.getModel()) 
			return "norte";
		else
			return "sur";
}
	
	

}
