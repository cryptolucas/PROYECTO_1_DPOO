package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuEmpleado extends JFrame implements ActionListener {
	
	private JLabel text1;
	private JButton boton_registrar;
	private JButton boton_consultar;
	private JButton boton_enviarmant;
	private JButton boton_sacarmant;
	
	private Principal principal;
	
	
	public MenuEmpleado(Principal p_principal) {
		principal = p_principal;
		
		setTitle("Bienvenido Empleado!");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setLayout(new BorderLayout());
        
        JPanel panel_central = new JPanel();
        panel_central.setLayout(new GridLayout(2,2,10,10));
		
		
        text1 = new JLabel("¿Que desea hacer el dia de hoy?");
        text1.setFont(new Font("Arial", Font.BOLD, 35));
        text1.setForeground( Color.BLACK );
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setPreferredSize(new Dimension(950, 200));
        
        boton_registrar = new JButton("QUIERO REGISTRAR UN CARRO EN MI SEDE");
        boton_registrar.setPreferredSize(new Dimension(150, 50));
        boton_registrar.setBackground( Color.BLUE );
        boton_registrar.setForeground( Color.WHITE );
        boton_registrar.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(boton_registrar);
        
        
        boton_consultar = new JButton("QUIERO CONSULTAR UNA RESERVA POR ID");
        boton_consultar.setPreferredSize(new Dimension(150, 50));
        boton_consultar.setBackground( Color.BLUE );
        boton_consultar.setForeground( Color.WHITE );
        boton_consultar.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(boton_consultar);
        
        
        boton_enviarmant = new JButton("QUIERO ENVIAR UN CARRO A MANTENIMIENTO");
        boton_enviarmant.setPreferredSize(new Dimension(150, 50));
        boton_enviarmant.setBackground( Color.BLUE );
        boton_enviarmant.setForeground( Color.WHITE );
        boton_enviarmant.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(boton_enviarmant);
        
        
        boton_sacarmant = new JButton("QUIERO SACAR DE MANTENIMIENTO UN CARRO");
        boton_sacarmant.setPreferredSize(new Dimension(150, 50));
        boton_sacarmant.setBackground( Color.BLUE );
        boton_sacarmant.setForeground( Color.WHITE );
        boton_sacarmant.setHorizontalAlignment(SwingConstants.CENTER);
        panel_central.add(boton_sacarmant);
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(350, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 200)));
        add(panelVentanaPrincipalArr, BorderLayout.SOUTH);
        		
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(text1);
        add(panelVentanaPrincipalAba, BorderLayout.NORTH);
        
        boton_registrar.addActionListener(this);
        boton_registrar.setActionCommand("registrar");
        
        boton_consultar.addActionListener(this);
        boton_consultar.setActionCommand("consultar");
        
        boton_enviarmant.addActionListener(this);
        boton_enviarmant.setActionCommand("enviar");
        
        boton_sacarmant.addActionListener(this);
        boton_sacarmant.setActionCommand("sacar");
        
        add(panel_central, BorderLayout.CENTER);
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand( ).equals( "registrar" )) {
			RegistrarPorEmpleados reg = new RegistrarPorEmpleados(principal);
			reg.setLocationRelativeTo(null);
			reg.setVisible(true);
			dispose();
			
		}
		
		else if (e.getActionCommand( ).equals( "consultar" )) {
			ConsultarReserva ccc = new ConsultarReserva(principal);
			ccc.setLocationRelativeTo(null);
			ccc.setVisible(true);
			dispose();
			
		}
		
		
		else if (e.getActionCommand( ).equals( "enviar" )) {
			EnviarAmantenimiento q = new EnviarAmantenimiento(principal);
			q.setLocationRelativeTo(null);
			q.setVisible(true);
			dispose();
			
		}
		else if (e.getActionCommand( ).equals( "sacar" )) {
			
			SacarMantenimiento sgg = new SacarMantenimiento(principal);
			sgg.setLocationRelativeTo(null);
			sgg.setVisible(true);
			dispose();
		
		}
	}
	

}
