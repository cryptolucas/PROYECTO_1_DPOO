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
import java.io.File;
import java.io.FileNotFoundException;
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
	
	public Principal()   {
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
	
	
	public static void main(String[] args) 
	{
		Principal ventana = new Principal();
		ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
		
	}
}
