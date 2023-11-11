package consola;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modelo.Empresa;



public class Principal extends JFrame implements ActionListener {

	private JPanel panelVentanaPrincipal;
	private JLabel text1;
	private JLabel text2;
	private JButton botonLog_In;
	private JButton botonReg;
	private Aplicacion app;
	private Empresa empresa;
	
	public Principal() {
		app = new Aplicacion();
		empresa = new Empresa();
		VentanaPrincipal();
	}
	
	
	public void VentanaPrincipal() {
		setTitle("Bienvenidos a RENTAL PAPIS!");
		setResizable( false );
		setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height-50);
        //setSize(950,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelVentanaPrincipal = new JPanel();
        panelVentanaPrincipal.setLayout(new GridLayout(4,1, 200, 150));

        text1 = new JLabel("RENTAL PAPIS");
        text1.setFont(new Font("Arial", Font.BOLD, 40));
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setForeground( Color.BLACK );
        panelVentanaPrincipal.add(text1);
        
        text2 = new JLabel("Te invitamos a escoger una de las siguientes opciones");
        text2.setFont(new Font("Arial", Font.BOLD, 35));
        text2.setForeground( Color.BLACK );
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        panelVentanaPrincipal.add(text2);
        
        
        botonLog_In = new JButton("Iniciar seción con LOG-IN");
        botonLog_In.setPreferredSize(new Dimension(150, 50));
        botonLog_In.setBackground( Color.BLUE );
        botonLog_In.setForeground( Color.WHITE );
        panelVentanaPrincipal.add(botonLog_In);
        
        botonReg = new JButton("REGISTRARME, soy usuario nuevo");
        botonReg.setPreferredSize(new Dimension(150, 50));
        botonReg.setBackground( Color.BLUE );
        botonReg.setForeground( Color.WHITE );
        panelVentanaPrincipal.add(botonReg);
        
        botonLog_In.addActionListener(this);
        botonLog_In.setActionCommand("LOG-IN");
        
        botonReg.addActionListener(this);
        botonReg.setActionCommand("REGISTRAR");
        
        add(panelVentanaPrincipal);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	
	
	public void actionPerformed( ActionEvent evento )
    {
        // TODO Auto-generated method stub
        if(evento.getActionCommand( ).equals( "REGISTRAR" )) {        	
        	dispose();
            RegistrarUsuario registrar = new RegistrarUsuario( this );
            registrar.setLocationRelativeTo(null);
            registrar.setVisible(true);
        }
        else {
        	dispose();
            IniciarSesion iniciar = new IniciarSesion( this );
            iniciar.setLocationRelativeTo(null);
            iniciar.setVisible(true);
        }
        
	
    }
	
	public void registrarUsuario(String nombre, String correo, String login, String password, String tipoUsuario,
			String fechaNacimiento, String nacionalidad,int licenciaConduccion, String paisExpedicion, 
			String fechaVencimientoLicencia, int telefonoContacto, int numeroTarjetaCredito) throws IOException {
		
		empresa.CrearCliente(nombre, correo, login, password, tipoUsuario, 
				fechaNacimiento, nacionalidad, licenciaConduccion, paisExpedicion, 
				fechaVencimientoLicencia, telefonoContacto, numeroTarjetaCredito);
	}
	
	public String iniciarSesion(String login, String password) throws IOException {
		String tipoUser = app.Login(login, password);
		return tipoUser;
	}
	
	
	public static void main(String[] args)
	{
		Principal ventana = new Principal();
		ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
		
	}
}
