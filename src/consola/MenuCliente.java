package consola;

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

public class MenuCliente extends JFrame implements ActionListener{
	
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JLabel image1;
	private JLabel image2;
	private JLabel image3;
	
	private Principal principal;
	
	private JButton boton_reservar;
	private JButton boton_consultar;
	
	
	
	
	
	public MenuCliente(Principal p_principal) {
		
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
        boton_reservar.addActionListener(this);
        boton_reservar.setActionCommand("reservar");
        
        boton_consultar = new JButton("CONSULTAR RESERVA POR ID");
        boton_consultar.setPreferredSize(new Dimension(150, 50));
        boton_consultar.setBackground( Color.BLUE );
        boton_consultar.setForeground( Color.WHITE );
        boton_consultar.setHorizontalAlignment(SwingConstants.CENTER);
        panel_sur.add(boton_consultar);
        boton_consultar.addActionListener(this);
        boton_consultar.setActionCommand("consultar");
        
        JLabel nada1 = new JLabel("");
        panel_sur.add(nada1);
        
        JLabel nada2 = new JLabel("");
        panel_sur.add(nada2);
        
        
        
        
        add(panel_sur, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand( ).equals( "reservar" )) {
			
			RealizarReserva res = new RealizarReserva(principal);
			res.setLocationRelativeTo(null);
			res.setVisible(true);
			
			dispose();
			
		
		}
		
		else if (e.getActionCommand( ).equals( "consultar" )) {
			ConsultarReserva ccc = new ConsultarReserva(principal);
			ccc.setLocationRelativeTo(null);
			ccc.setVisible(true);
			dispose();
		}
	}
	
	
	

}
