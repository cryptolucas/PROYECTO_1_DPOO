package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Carro;
import modelo.Empresa;
import modelo.Reserva;


public class Aplicacion {
	
	
	Empresa empresa = new Empresa();
	
	
	public void MostrarMenu() {
		System.out.println("Bienevenido a RENTAL_PAPIS, la mejor empresa para rentar un carro...\n ");
		System.out.println("A continuación te invitamos a probar una de las siguientes opciones...\n");
		System.out.println("1. Registrarme. Soy usuario nuevo...");
		System.out.println("2. Iniciar sesión por Log-in");
		System.out.println("3. Salir de la aplicacion");
	
		
	}
	 
	
	public void ejecutarAplicacion() throws IOException
	{
		System.out.println("RENTA CARROS");
		
		try
		{
			
			MostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			
			if (opcion_seleccionada == 1) {
				registrarUsuario();
			}
				
			else if (opcion_seleccionada == 2) {
		    	//Login();
		    }

			else if (opcion_seleccionada == 3){
				System.out.println("Saliendo de la aplicación ...");
			}
			
			else{
				System.out.println("Por favor seleccione una opción válida.");
			}
				
		    }
		
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
			
		}
			
		}
		
		
	
	
	
	public void registrarUsuario() throws IOException
	{
		
		System.out.println("Registrese para iniciar la aplicación ");
		String nombre = input("Ingrese su nombre");
		String login = input("Ingrese el login que desea utilizar");
		String password = input("Ingrese su password (Recuerde anotarla de forma segura): ");
//		
//		String tipoUsuario = "cliente"; //el q se registra aca es unicamente el cliente..
//		if (tipoUsuario.equalsIgnoreCase("cliente")) {
////			String correo = input("Ingrese su correo");
////			String fechaNacimiento = input("Ingrese su fecha de nacimiento");
////			String nacionalidad = input("Ingrese su nacionalidad");
////			String licenciaConduccion = Integer.parseInt(input("Ingrese su numero de licencia de conduccion"));
////			String paisExpedicion = input("Ingrese el pais de expedicion de la licencia");
////			String fechaVencimientoLicencia = input("Ingrese la fecha de vencimiento de su licencia");
////			String telefonoContacto  = Integer.parseInt(input("Ingrese un numero de telefono de contacto"));
////			String numeroTarjetaCredito = Integer.parseInt(input("Ingrese su numero de la tarjeta de credito"));
//			
//			empresa.CrearCliente(nombre,  correo,  login,  password,  tipoUsuario,
//			 fechaNacimiento,  nacionalidad, licenciaConduccion,  paisExpedicion, 
//			 fechaVencimientoLicencia,  telefonoContacto,  numeroTarjetaCredito);
//			System.out.println("******************************");
//			System.out.println("Cliente creado exitosamente!!");
//			System.out.println("******************************");
//		}
	}
			
			
	
	public String Login(String login, String password) throws IOException {
		
//		System.out.println("Bienvenido a la mejor empresa de alquiler de vehiculos en Bogotá \n" );
//    	System.out.println("Si eres administrador general, tu login es: German Romero y tu password es: 456");
//    	System.out.println("Si eres administrador local de la sede norte, tu login es: Hugo Boss y tu password es: admin123");
//    	System.out.println("Si eres administrador local de la sede centro, tu login es: Alvaro Uribe y tu password es: elboss");
//    	System.out.println("Si eres administrador local de la sede sur, tu login es: Maria y tu password es: gato123");
    	
		//String login = input("Ingrese su nombre de usuario para el login");
		//String password = input("Ingrese su contraseña");
		boolean checklogin = false;
		String tipouser = null;
		
		
			
		try (BufferedReader br = new BufferedReader(new FileReader("data/users.txt"))) {
            String linea;

            while ((linea = br.readLine())!= null) {
            	String[] partes = linea.split(",");
            	
            	if (partes[0].equals(login) && partes[1].equals(password)) {
            		checklogin = true;
            		tipouser = partes[2];}
            		
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Error al leer el archivo.");
        }
		
		if (checklogin == true && tipouser.equals("cliente")) 
			return "cliente";
//			System.out.println("                                                                                   ");
//			System.out.println("El precio por día para rentar un carro tipo SEDAN o COUPE o HATCHBACK es de $50,000");
//			System.out.println("El precio por día para rentar un carro tipo SUV o MINIVAN es de $65,000");
//			System.out.println("El precio por día para rentar un carro tipo PICKUP o STATION WAGON es de $80,000");
//			System.out.println("                                                                                   ");
//			System.out.println("1. Realizar una reserva");
//			System.out.println("2. Consultar una reserva por Id");
//			String continuar = input("Ingrese la opcion que desea hacer");
//			
//			if (continuar.equalsIgnoreCase("1"))  {
//				String nombre = input("Escribe tu nombre");
//				String licencia = input("Escribe el numero de tu licencia de conduccion");
//				String cedula = input("Ingresa tu Cedula de Ciudadania");
//				String sedeOrigen = input("Ingrese la sede en la que recibirá el carro (norte, centro o sur)");
//				if (sedeOrigen.equalsIgnoreCase("norte"))
//					empresa.loaderInventarioSedeNorte();
//				else if (sedeOrigen.equalsIgnoreCase("sur"))
//					empresa.loaderInventarioSedeSur();
//				else if (sedeOrigen.equalsIgnoreCase("centro"))
//					empresa.loaderInventarioSedeCentro();
//				String sedeDestino = input("Ingrese la sede en la que entregará el carro (norte, centro o sur)");
//				String fechaHoraRecogida = input("Ingrese la fecha y hora de recogida del vehiculo (\"yyyy-MM-dd'T'HH:mm:ss\")");
//				String fechaHoraEntrega = input("Ingrese la fecha y hora de entrega del vehiculo (\"yyyy-MM-dd'T'HH:mm:ss\")");
//				String metodopago = input("Ingrese su metodo de pago (Nequi, Daviplata, Tarjeta de credito, Tarjeta de debito) ");
//				int conducAdicional = Integer.parseInt(input("Ingrese la cantidad de conductores adicionales que manejarán el vehiculo"));
//				System.out.println("******************************");
//				System.out.println("Seguros que ofrece la empresa");
//				System.out.println("1. Seguro basico cuesta 45,000 COP");
//				System.out.println("2. Seguro intermedio cuesta 70,000 COP");
//				System.out.println("3. Seguro completo cuesta 98,000 COP");
//				System.out.println("4. No desea seguro");
//				System.out.println("******************************");
//				String seguros = input("Ingrese el numero del seguro del que está interesado");
//				String tipoVehiculo = input("Ingrese el tipo de vehiculo que desea reservar 'Sedan', 'Coupe', 'Hatchback', 'Pickup' , 'Station Wagon', 'SUV', 'Minivan' ");
//				System.out.println("                                                                                   ");
//				
//				int precioTotal = empresa.CrearReserva(nombre, licencia, cedula, sedeOrigen, sedeDestino, fechaHoraRecogida, fechaHoraEntrega, metodopago,
//										conducAdicional, seguros, tipoVehiculo);
//				double precioTreinta = precioTotal*0.3;
//				System.out.println("******************************");
//				System.out.println("El 30% del precio total que debe pagar ahora es " + String.valueOf(precioTreinta));
//				System.out.println("El precio total del alquiler del vehiculo tipo " + tipoVehiculo + " es de " + Integer.toString(precioTotal));
//				System.out.println("******************************");
//				
//			}
//			else if (continuar.equalsIgnoreCase("2")) {
//				String id = input("Ingresa el ID de la reserva");
//				System.out.println("                                                                                   ");
//				System.out.println("La reserva que usted consulto tiene los siguientes datos (IdReserva,nombre,licencia,cedula,sedeDestino,hora_entrega,tipo_vehiculo,preciofinal)");
//				System.out.println(empresa.ConsultarReserva(id));
//			}
//			
//			}
		
		else if (checklogin == true && tipouser.equals("administradorl")) 
			return "administradorl";
			
//			System.out.println("Hola Administrador! Que desea hacer...");
//			String opc1 = input("1. Agregar un nuevo empleado a la nómina de mi sede");
//			
//			if (opc1.equals("1")) {
//				String username = input("Cree un login para el empleado");
//				String contraseña = input("Cree una contraseña para el empleado");
//				String name = input("Escriba el nombre del empleado");
//				String id = input("Cree un ID alfanumérico para el empleado");
//				String sede = input("Ingrese la sede en la cual trabajará el nuevo empleado (sur, norte,centro)");
//				System.out.println("                                                                                   ");
//				empresa.CrearEmpleado(username, contraseña, "empleado", name, id, sede);
//				System.out.println("Empleado creado exitosamnte");
//			}
//
//		}
		
		
		else if (checklogin == true && tipouser.equals("empleado")) 
			return "empleado";
			
//			System.out.println("Hola Empleado! Que desea hacer...");
//
//			System.out.println("1. Desea registrar la entrega de un carro en su sede?");
//			System.out.println("2. Desea consultar una reserva por id?");
//			System.out.println("3. Desea enviar a mantenimiento un vehículo?");
//			System.out.println("4. Desea sacar de mantenimiento un vehículo?");
//	
//			String opc1 = input("Ingrese el numero de la opcion que desea realizar");
//
//			if (opc1.equals("1")) {
//				
//				int id = Integer.parseInt(input("Ingrese el id de la reserva"));
//				String sede = input("Desde que sede recibes el carro?");
//				empresa.RecibirCarro(id, sede);
//				File archivoAEliminar = new File("data/temporal.txt");
//	            archivoAEliminar.delete();
//	            System.out.println("                                                                                   ");
//				System.out.println("Entrega exitosa del carro");
//			}
//			else if (opc1.equals("2")) {
//				
//				String id = input("Ingresa el ID de la reserva");
//				System.out.println("                                                                                   ");
//				System.out.println("La reserva que usted consulto tiene los siguientes datos (IdReserva,nombre,licencia,cedula,sedeDestino,hora_entrega,tipo_vehiculo,preciofinal)");
//				System.out.println(empresa.ConsultarReserva(id));
//				
//				
//
//			}
//			else if (opc1.equals("3")) {
//				
//				String placa = input("Ingresa la placa del carro que enviaras a mantenimeinto");
//				String sede = input("Recuerdanos la sede donde trabajas (norte,sur,centro)");
//				String fechaes = input("¿Para que fecha estimada estara disponible el vehiculo?");
//				empresa.EnviarAMantenimiento(placa, sede, fechaes);
//				System.out.println("                                                                                   ");
//				System.out.println("Enviado exitosamente");
//
//			}
//			
//			else if (opc1.equals("4")) {
//				
//				String placa = input("Ingresa la placa del carro que enviaras a mantenimeinto");
//				String sede = input("Recuerdanos la sede donde trabajas (norte,sur,centro)");
//				empresa.SacarMantenimiento(placa, sede);
//				File archivoAEliminar = new File("data/temporal.txt");
//	            archivoAEliminar.delete();
//	            System.out.println("                                                                                   ");
//				System.out.println("Sacado exitosamente");
//				
//
//			}
//			
//			
//		}
		
		else if (checklogin == true && tipouser.equals("administradorg")) 
			return "administradorg";
			
//			empresa.loaderInventario();
//			System.out.println("¿Que tal jefe? Que desea hacer el dia de hoy...");
//			String opc = input("Escriba 1 para añadir un carro al inventario o 2 para eliminar un carro del invenatrio");
//			if (opc.equals("1")) {
//				String marca = input("Ingrese la marca del nuevo carro");
//				String placa = input("Ingrese la placa del nuevo carro");
//				String modeloCarro = input("Ingrese el modelo del nuevo carro");
//				String color = input("Ingrese el color del nuevo carro");
//				String transmision = input("Ingrese el tipo de transmision del nuevo carro");
//				int capacidad = Integer.parseInt(input("Ingrese la capacidad del nuevo carro"));
//				String tipoMotor = input("Ingrese el tipo de motor del nuevo carro");
//				String tipovehiculo = input("Ingrese el tipo de vehiculo del nuevo carro ('Sedan', 'Coupe', 'Hatchback', 'Pickup' , 'Station Wagon', 'SUV', 'Minivan')");
//				String sedeAnadir = input("Ingrese la sede a la que quiere añadir el nuevo carro (norte,centro,sur)");
//				empresa.AgregarCarro(marca, placa, modeloCarro, color, transmision, capacidad, tipoMotor, tipovehiculo, sedeAnadir);
//				System.out.println("                                                                                   ");
//				System.out.println("Se ha agregado un carro nuevo exitosamente");
//				}
//			else if (opc.equals("2")) {
//				String modeloCarro = input("Ingrese el modelo del carro que desea eliminar");
//				String sede = input("Ingrese la sede del carro que desea elminiar");
//				empresa.EliminarCarro(modeloCarro, sede);
//				System.out.println("                                                                                   ");
//				System.out.println("Se ha elmiminado un carro existormanete");
//				}
//			
//
//		}
		else return "error";
		
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
		consola.ejecutarAplicacion();
	}
}
