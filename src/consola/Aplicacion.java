package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Empresa;

public class Aplicacion {

	public void registrarUsuario() throws IOException
	{
		Empresa empresa = new Empresa();
		//empresa.CargarInformacionEmpresa();
		System.out.println("Inicie Sesión para iniciar una reserva ");
		String nombre = input("Ingrese su nombre: ");
		String login = input("Ingrese su login: ");
		String password = input("Ingrese su password: ");
		String tipoUsuario = input("Ingrese el tipo de usuario que es (cliente, empleado, administrador local, administrador general): ");
		if (tipoUsuario.equalsIgnoreCase("cliente")) {
			String correo = input("Ingrese su correo: ");
			String fechaNacimiento = input("Ingrese su fecha de nacimiento: ");
			String nacionalidad = input("Ingrese su nacionalidad: ");
			int licenciaConduccion = Integer.parseInt(input("Ingrese su numero de licencia de conduccion: "));
			String paisExpedicion = input("Ingrese el pais de expedicion de la licencia: ");
			String fechaVencimientoLicencia = input("Ingrese la fecha de vencimiento de su licencia: ");
			int telefonoContacto  = Integer.parseInt(input("Ingrese un numero de telefono de contacto: "));
			int numeroTarjetaCredito = Integer.parseInt(input("Ingrese su numero de la tarjeta de credito: "));
			
			Empresa.CrearCliente(nombre,  correo,  login,  password,  tipoUsuario,
			 fechaNacimiento,  nacionalidad, licenciaConduccion,  paisExpedicion, 
			 fechaVencimientoLicencia,  telefonoContacto,  numeroTarjetaCredito);
		}
		else if (tipoUsuario.equalsIgnoreCase("empleado")){
			String id = input("Ingrese su id: ");
			String sede = input("Ingrese la sede a la que pertenece: ");
			empresa.CrearEmpleado(login, password, tipoUsuario, nombre, id, sede);
		}
		//else if (tipoUsuario.equalsIgnoreCase("administrador local"){} 
		
	}

	
	
	





	private String input(String string) {
		try
		{
			System.out.print(string + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) throws IOException
	{
		Aplicacion consola = new Aplicacion();
		consola.registrarUsuario();
	}
}
