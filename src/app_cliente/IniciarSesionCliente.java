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
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import consola.MenuCliente;

public class IniciarSesionCliente extends JFrame implements ActionListener{
	
	private JLabel lblLog_In;
	private JLabel lblPassw;
	private JLabel lblNada;
	private JLabel image2;
	
	private JTextField txtLog_In;
	private JTextField txtPassw;
	
	private JButton btnIniciarSesion;
	
	private ClientePrincipal principal;
	
	public IniciarSesionCliente( ClientePrincipal pPrincipal ) {
		principal = pPrincipal;
		setTitle("Iniciar sesión");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
		setSize(1350,710);
		setLayout(new BorderLayout());
        //setLayout(new GridLayout(3,2));
        
        JPanel pnlInic = new JPanel();
        pnlInic.setLayout(new GridLayout(3,2));
        JLabel nada = new JLabel("");
        nada.setPreferredSize(new Dimension(50, 50));
        pnlInic.add(nada);
        JLabel nada2 = new JLabel("");
        nada2.setPreferredSize(new Dimension(50, 50));
        pnlInic.add(nada2);
        
		lblLog_In = new JLabel("Log-In");
        lblLog_In.setFont(new Font("Arial", Font.BOLD, 15));
        lblLog_In.setForeground( Color.BLACK );
        lblLog_In.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(lblLog_In);
        txtLog_In = new JTextField( "" );
        pnlInic.add(txtLog_In);
        
        lblPassw = new JLabel("Contraseña");
        lblPassw.setFont(new Font("Arial", Font.BOLD, 15));
        lblPassw.setForeground( Color.BLACK );
        lblPassw.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInic.add(lblPassw);
        txtPassw = new JTextField( "" );
        pnlInic.add(txtPassw);

        
        add(pnlInic, BorderLayout.CENTER);
        
        JPanel panelVentanaPrincipalDere = new JPanel();
        panelVentanaPrincipalDere.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalDere, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(250, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);
        
        JPanel panel_norte = new JPanel();
        
        ImageIcon icono1 = new ImageIcon("data/rentalPapis.jpg");
        image2 = new JLabel((new ImageIcon(icono1.getImage().getScaledInstance(850, 250, Image.SCALE_SMOOTH))));
        panel_norte.add(image2);
        //panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(250, 300)));
        add(panel_norte, BorderLayout.NORTH);
        
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(0, 300)));
        btnIniciarSesion = new JButton("INICIAR SESIÓN");
        btnIniciarSesion.setPreferredSize(new Dimension(150, 50));
        btnIniciarSesion.setBackground( Color.BLUE );
        btnIniciarSesion.setForeground( Color.WHITE );
        btnIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        panelVentanaPrincipalAba.add(btnIniciarSesion);
        btnIniciarSesion.addActionListener(this);
        btnIniciarSesion.setActionCommand("INICIAR SESIÓN");
        add(panelVentanaPrincipalAba, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand( ).equals( "INICIAR SESIÓN" )) { 
			String tipoUser = "error";
			try {
				tipoUser = principal.iniciarSesion(txtLog_In.getText(), txtPassw.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERROR!", 
						"ERROR", JOptionPane.ERROR_MESSAGE);
				dispose();
			}
			
			if (tipoUser.equals("cliente")){
				
				MENU menu_cliente = new MENU(principal);
				menu_cliente.setLocationRelativeTo(null);
				menu_cliente.setVisible(true);
				
				dispose();
			}
			
			else {//"error"
				JOptionPane.showMessageDialog(null, "No existe el usuario", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
        	
        	//llamar a la otra ventana...
        }
	}
	}


