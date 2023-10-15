package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Carro;
import modelo.Empresa;

public class Aplicacion {
	Empresa empresa = new Empresa();
	public void registrarUsuario() throws IOException
	{
		
		System.out.println("Registrese para iniciar la aplicación ");
		String nombre = input("Ingrese su nombre");
		String login = input("Ingrese su login");
		String password = input("Ingrese su password");
		
		String sedeActual = input("Ingrese la sede en la que se encuentra(norte, centro o sur)");
		empresa.CargarInformacionEmpresa(sedeActual); //sale error Index 1 out of bounds for length 1
		
		String tipoUsuario = input("Ingrese el tipo de usuario que es (cliente, empleado, administrador local, administrador general)");
		if (tipoUsuario.equalsIgnoreCase("cliente")) {
			String correo = input("Ingrese su correo");
			String fechaNacimiento = input("Ingrese su fecha de nacimiento");
			String nacionalidad = input("Ingrese su nacionalidad");
			int licenciaConduccion = Integer.parseInt(input("Ingrese su numero de licencia de conduccion"));
			String paisExpedicion = input("Ingrese el pais de expedicion de la licencia");
			String fechaVencimientoLicencia = input("Ingrese la fecha de vencimiento de su licencia");
			int telefonoContacto  = Integer.parseInt(input("Ingrese un numero de telefono de contacto"));
			int numeroTarjetaCredito = Integer.parseInt(input("Ingrese su numero de la tarjeta de credito"));
			
			empresa.CrearCliente(nombre,  correo,  login,  password,  tipoUsuario,
			 fechaNacimiento,  nacionalidad, licenciaConduccion,  paisExpedicion, 
			 fechaVencimientoLicencia,  telefonoContacto,  numeroTarjetaCredito);
			
			System.out.println("Bienvenido a la mejor empresa de alquiler de vehiculos en Bogotá \n" );
			System.out.println("A continuacion se muestran todos los carros que se encuentran en la sede");
			mostrarCarrosSede();
			String continuar = input("Desea hacer una reserva? (si, no)");
			if (continuar.equalsIgnoreCase("si")){
				String sedeDestino = input("Ingrese la sede en la que entregará el carro (norte, centro o sur)");
				String fechaHoraEntrega = input("Ingrese la fecha y hora de entrega del vehiculo (\"yyyy-MM-dd'T'HH:mm:ss\")");
				System.out.println("Seguros que ofrece la empresa");
				System.out.println("1. Seguro basico cuesta 45,000 COP");
				System.out.println("2. Seguro intermedio cuesta 70,000 COP");
				System.out.println("3. Seguro completo cuesta 98,000 COP");
				System.out.println("4. No desea seguro");
				String seguros = input("Ingrese el numero del seguro del que está interesado");
				String tipoVehiculo = input("Ingrese el tipo de vehiculo que desea reservar");
				int conducAdicional = Integer.parseInt(input("Ingrese la cantidad de conductores adicionales que manejarán el vehiculo"));
				
				
			}
			else {System.out.println("Gracias por su visita!");}
		}
		else if (tipoUsuario.equalsIgnoreCase("empleado")){
			String id = input("Ingrese su id");
			String sede = input("Ingrese la sede a la que pertenece");
			empresa.CrearEmpleado(login, password, tipoUsuario, nombre, id, sede);
		}
		//else if (tipoUsuario.equalsIgnoreCase("administrador local"){} 
		
	}

	
	
	
	private void mostrarCarrosSede() {
		for (HashMap<Boolean, ArrayList<String>> hashMap: empresa.getInventario()) {
			for (Boolean key : hashMap.keySet()) {
				ArrayList<String> values = hashMap.get(key);
				//for (String info: values) {System.out.println(key+""+info);}
				//String marca = Carro.getMarca(); 
				String linea = key +"-"+ values;
				System.out.println(linea);
			}
		}
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
