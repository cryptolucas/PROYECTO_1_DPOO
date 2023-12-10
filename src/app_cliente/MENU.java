package app_cliente;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MENU extends JFrame implements ActionListener{
	
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	
	private ClientePrincipal principal;
	
	private JButton boton_reservar;
	private JButton boton_consultar;
	private JButton boton_centro;
	private JButton boton_sur;
	private JButton boton_norte;
	
	
	
	
	
	
	public MENU(ClientePrincipal p_principal) {
		
		principal = p_principal;
		setTitle("Bienvenido a RENTAL PAPIS!");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setLayout(new BorderLayout());
       
        
        JPanel panel_norte = new JPanel();
        panel_norte.setLayout(new GridLayout(2,3, 15, 15));
       
		ImageIcon icono = new ImageIcon("data/sedan.jpg");
        image1 = new JLabel((new ImageIcon(icono.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH))));
        panel_norte.add(image1);
        
        ImageIcon icono1 = new ImageIcon("data/SUV.jpg");
        image2 = new JLabel((new ImageIcon(icono1.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH))));
        panel_norte.add(image2);
        
        ImageIcon icono2 = new ImageIcon("data/PICKUP.jpg");
        image3 = new JLabel((new ImageIcon(icono2.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH))));
        panel_norte.add(image3);
        
        

        text1 = new JLabel("<html>$50,000 COP por día:<br>SEDAN, COUPE o HATCHBACK</html>");
        text1.setFont(new Font("Arial", Font.BOLD, 30));
        text1.setForeground( Color.BLACK );
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(text1);
	
        
        text2 = new JLabel("<html>$65,000 COP por día:<br>SUV o MINIVAN</html>");
        text2.setFont(new Font("Arial", Font.BOLD, 30));
        text2.setForeground( Color.BLACK );
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(text2);
        
        text3 = new JLabel("<html>$80,000 COP por día:<br>PICKUP o STATION WAGON</html>");
        text3.setFont(new Font("Arial", Font.BOLD, 30));
        text3.setForeground( Color.BLACK );
        text3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_norte.add(text3);
        
        add(panel_norte, BorderLayout.NORTH);
        
        
        
        JPanel panel_sur = new JPanel();
        panel_sur.setLayout(new GridLayout(2,2, 35, 35));
        
        boton_reservar = new JButton("REALIZAR RESERVA");
        boton_reservar.setPreferredSize(new Dimension(150, 50));
        boton_reservar.setBackground( Color.BLUE );
        boton_reservar.setForeground( Color.WHITE );
        boton_reservar.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(boton_reservar);
       
        boton_centro= new JButton("VER OCUPACION SEDE CENTRO");
        boton_centro.setPreferredSize(new Dimension(150, 20));
        boton_centro.setBackground( Color.BLUE );
        boton_centro.setForeground( Color.WHITE );
        panel_sur.add(boton_centro);
        
        boton_norte= new JButton("VER OCUPACION SEDE NORTE");
        boton_norte.setPreferredSize(new Dimension(150, 20));
        boton_norte.setBackground( Color.BLUE );
        boton_norte.setForeground( Color.WHITE );
        panel_sur.add(boton_norte);
        
        boton_sur= new JButton("VER OCUPACION SEDE SUR");
        boton_sur.setPreferredSize(new Dimension(150, 20));
        boton_sur.setBackground( Color.BLUE );
        boton_sur.setForeground( Color.WHITE );
        panel_sur.add(boton_sur);
        
        
       

        boton_reservar.addActionListener(this);
        boton_reservar.setActionCommand("RESERVAR");
               
        boton_centro.addActionListener(this);
        boton_centro.setActionCommand("CENTRO");
               
        boton_sur.addActionListener(this);
        boton_sur.setActionCommand("SUR");
               
        boton_norte.addActionListener(this);
        boton_norte.setActionCommand("NORTE");
        
        
        add(panel_sur, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand( ).equals( "RESERVAR" )) {        	
        	
            RealizarReservaCliente reservar = new RealizarReservaCliente( principal );
            reservar.setLocationRelativeTo(null);
            reservar.setVisible(true);
            dispose();
        }
        
        else if (evento.getActionCommand( ).equals( "CENTRO" )) {        	
        	MostrarGraficaCentroCliente g = new MostrarGraficaCentroCliente(principal);
			g.setLocationRelativeTo(null);
			g.setVisible(true);
			dispose();
        }
        
        else if (evento.getActionCommand( ).equals( "SUR" )) {        	
        	MostrarGraficaSurCliente g = new MostrarGraficaSurCliente(principal);
			g.setLocationRelativeTo(null);
			g.setVisible(true);
			dispose();
        }
        
        else if (evento.getActionCommand( ).equals( "NORTE" )) {        	
        	MostrarGraficaNorteCliente g = new MostrarGraficaNorteCliente(principal);
			g.setLocationRelativeTo(null);
			g.setVisible(true);
			dispose();
        }
		
	}
	
	
	

}