package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Principal extends JFrame implements ActionListener{

	
	
	public Principal() {
		
		Aplicacion app = new Aplicacion();
		
		VentanaPrincipal();
	}
	
	
	public void VentanaPrincipal() {
		setTitle("Bienvenidos a RENTAL PAPIS!");
		setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelVentanaPrincipal = new JPanel();
        panelVentanaPrincipal.setLayout(new GridLayout(4,1, 200, 150));

        // Agregar dos JTextField
        JLabel text1 = new JLabel("RENTAL PAPIS");
        text1.setFont(new Font("Arial", Font.BOLD, 40));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel text2 = new JLabel("Te invitamos a escoger una de las siguientes opciones");
        text2.setFont(new Font("Arial", Font.BOLD, 35));
        panelVentanaPrincipal.add(text1);
        panelVentanaPrincipal.add(text2);

        // Agregar dos JButton
        JButton boton1 = new JButton("Iniciar seción con LOG-IN");
        boton1.addActionListener(this);
        boton1.setActionCommand("LOG-IN");
        
        JButton boton2 = new JButton("REGISTRARME, soy usuario nuevo");
        boton2.addActionListener(this);
        boton2.setActionCommand("REGISTRAR");
      
        boton1.setPreferredSize(new Dimension(150, 50));
        boton2.setPreferredSize(new Dimension(150, 50));
        panelVentanaPrincipal.add(boton1);
        panelVentanaPrincipal.add(boton2);
        

        // Agregar el panel a la ventana
        add(panelVentanaPrincipal);
       
        
        
        
        setVisible(true);
	}
	
	
	
	public void actionPerformed( ActionEvent evento )
    {
//        // TODO Auto-generated method stub
//        if(evento.getActionCommand( ).equals( "LOG-IN" )) {
        	
        }
        
	
	
	public static void main(String[] args)
	{
		new Principal();
		
		
	}
}
