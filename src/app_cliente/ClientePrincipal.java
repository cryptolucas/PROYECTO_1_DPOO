package app_cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import consola.Aplicacion;
import consola.GraficasAdicional;
import consola.IniciarSesion;
import consola.Principal;
import consola.RegistrarUsuario;
import modelo.Empresa;

public class ClientePrincipal extends JFrame implements ActionListener {
	
	private JPanel panelVentanaPrincipal;
	private JLabel text1;
	private JLabel text2;
	private JLabel image2;
	private JLabel lblnada;
	private JButton botonLog_In;
	private JButton botonReg;
	private JButton boton_reservar;
	private JButton boton_centro;
	private JButton boton_sur;
	private JButton boton_norte;
	private Aplicacion app;
	private Empresa empresa;
	
	public ClientePrincipal()   {
		app = new Aplicacion();
		empresa = new Empresa();
		try {
			VentanaPrincipal();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	public void VentanaPrincipal() throws FileNotFoundException {
		empresa.CargarInformacionEmpresa();
		empresa.loaderInventarioSedeCentro();
		empresa.loaderInventarioSedeNorte();
		empresa.loaderInventarioSedeSur();

		setTitle("Bienvenidos a RENTAL PAPIS!");
		setResizable( false );
		//setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		setLayout(new BorderLayout());
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height-50);
        setSize(1350,710);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelVentanaPrincipal = new JPanel();
        panelVentanaPrincipal.setLayout(new GridLayout(2,2, 80, 80));
        
        
        ImageIcon icono1 = new ImageIcon("data/rentalPapis.jpg");
        image2 = new JLabel((new ImageIcon(icono1.getImage().getScaledInstance(850, 200, Image.SCALE_SMOOTH))));
        //panelVentanaPrincipal.add(image2);

        text1 = new JLabel("Bienvenido a Rental Papis querido USUARIO");
        panelVentanaPrincipal.add(text1);
        
        lblnada = new JLabel("MENU EXCLUSIVO PARA CLIENTES");
        panelVentanaPrincipal.add(lblnada);
        
        botonReg = new JButton("REGISTRARME, soy usuario nuevo");
        botonReg.setPreferredSize(new Dimension(150, 20));
        botonReg.setBackground( Color.BLUE );
        botonReg.setForeground( Color.WHITE );
        panelVentanaPrincipal.add(botonReg);
        
        botonLog_In = new JButton("Iniciar seción con LOG-IN");
        botonLog_In.setPreferredSize(new Dimension(150, 20));
        botonLog_In.setBackground( Color.BLUE );
        botonLog_In.setForeground( Color.WHITE );
        panelVentanaPrincipal.add(botonLog_In);
        
         
        
        botonLog_In.addActionListener(this);
        botonLog_In.setActionCommand("LOG-IN");
        
        botonReg.addActionListener(this);
        botonReg.setActionCommand("REGISTRAR");
      
        
        add(panelVentanaPrincipal, BorderLayout.CENTER);
        
        
        
        
        
        JPanel panelVentanaPrincipalIzq = new JPanel();
        panelVentanaPrincipalIzq.add(Box.createRigidArea(new Dimension(300, 250)));
        add(panelVentanaPrincipalIzq, BorderLayout.WEST);

        JPanel panelVentanaPrincipalDer = new JPanel();
        panelVentanaPrincipalDer.add(Box.createRigidArea(new Dimension(300, 250)));
        add(panelVentanaPrincipalDer, BorderLayout.EAST);
        
        JPanel panelVentanaPrincipalAba = new JPanel();
        panelVentanaPrincipalAba.add(Box.createRigidArea(new Dimension(250, 60)));
        add(panelVentanaPrincipalAba, BorderLayout.SOUTH);
        
        JPanel panelVentanaPrincipalArr = new JPanel();
        panelVentanaPrincipalArr.add(image2);
        panelVentanaPrincipalArr.add(Box.createRigidArea(new Dimension(0, 25)));
        add(panelVentanaPrincipalArr, BorderLayout.NORTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	public void registrarUsuario(String nombre, String correo, String login, String password, String tipoUsuario,
			String fechaNacimiento, String nacionalidad,String licenciaConduccion, String paisExpedicion, 
			String fechaVencimientoLicencia, String telefonoContacto, String numeroTarjetaCredito) throws IOException {
		
		empresa.CrearCliente(nombre, correo, login, password, tipoUsuario, 
				fechaNacimiento, nacionalidad, licenciaConduccion, paisExpedicion, 
				fechaVencimientoLicencia, telefonoContacto, numeroTarjetaCredito);
	}
	
	public String iniciarSesion(String login, String password) throws IOException {
		String tipoUser = app.Login(login, password);
		return tipoUser;
	}
	
	public void AgregarCarro(String marca, String placa, String modeloCarro, String color, String transmision, 
									int capacidad, String tipoMotor, String tipovehiculo, String sede) throws IOException {
		
		empresa.AgregarCarro(marca, placa, modeloCarro, color, transmision, capacidad, tipoMotor, tipovehiculo, sede);
		
	}
	
	public void EliminarCarro(String modelo, String sede) {
		empresa.EliminarCarro(modelo, sede);
	}
	
	
	public String CrearReserva(String nombre, String licencia, String cedula, String sedeOrigen, String sedeDestino, String hora_recogida, String hora_entrega, String metodo_pago,
		         int conductor_adicional, String seguros, String tipo_vehiculo) throws IOException {
		
		return empresa.CrearReserva(nombre, licencia, cedula, sedeOrigen, sedeDestino, hora_recogida, hora_entrega, metodo_pago, conductor_adicional, seguros, tipo_vehiculo);
	}
	
	public String ConsultarReserva(String id) {
		
		String str = empresa.ConsultarReserva(id);
		String[] partes = str.split(",");
		
		String ID = partes[0];
		String nombre = partes[1];
		String licencia= partes[2];
		String cedula = partes[3];
		String sede_destino = partes[4];
		String fecha_entrega = partes[5];
		String tipo_veh= partes[6];
		String preciofinal = partes[7];
		
		return "<html>El ID de la reserva es: " + ID + 
				"  <br> La reserva esta a nombre de: " + nombre +
				"   <br> La licencia de conducción registrada es:  " + licencia +
				"  <br> El documento de identidad registrado es: " + cedula +
				"  <br> La sede donde se entregara el carro es: " + sede_destino +
				"  <br> La fecha de entrega del vehiculo es: " + fecha_entrega +
				"  <br> El tipo de vehículo rentado es:  " + tipo_veh +
				"  <br> El precio final de la reserva es " + preciofinal
				+ "</html>" ;
		        	
		
	}
	
	public void RegistrarEntrega(String id, String sede) throws IOException {
		
		empresa.RecibirCarro(Integer.parseInt(id), sede);
		File archivoAEliminar = new File("data/temporal.txt");
        archivoAEliminar.delete();
	}
	
	public void EnviarMantenimiento(String placa, String sede, String fecha) throws IOException {
		empresa.EnviarAMantenimiento(placa, sede, fecha);
		
	}
	
	public void SacarMantenimiento(String placa, String sede) throws IOException {
		
		empresa.SacarMantenimiento(placa, sede);
		File archivoAEliminar = new File("data/temporal.txt");
		archivoAEliminar.delete();
	}
	
	
	public void CrearEmpleado(String login, String password, String tipoUsuario, 
			String nombre, String id, String sede) throws IOException {
		
		empresa.CrearEmpleado(login, password, tipoUsuario, nombre, id, sede);
	}
	
	
	
	
	



	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// TODO Auto-generated method stub
        if(evento.getActionCommand( ).equals( "REGISTRAR" )) {        	
        	dispose();
            RegistrarUsuarioCliente registrar = new RegistrarUsuarioCliente( this );
            registrar.setLocationRelativeTo(null);
            registrar.setVisible(true);
        }
        
      
        else {
        	dispose();
            IniciarSesionCliente iniciar = new IniciarSesionCliente( this );
            iniciar.setLocationRelativeTo(null);
            iniciar.setVisible(true);
        }
		
	}
	
	
	

	public static void main(String[] args) throws IOException
	{
		
		ClientePrincipal ventana = new ClientePrincipal();
		ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
		
	}
}
