package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	
	private ArrayList<String[]> usuarios;
	private  ArrayList<HashMap<Boolean, ArrayList<String>>>  Inventario;
	private HashMap<String, ArrayList<Empleado>> empleados;
	private ArrayList<Reserva> reservas;
	
	//public Restaurante () throws FileNotFoundException  {   PONER CONSTRUCTOR ACA!!!
		
		//CargarInformacionRestaurante();
		
		//int numeroPedidos = 0;
		//pedidos = new ArrayList<Pedido>();
		//this.pedidoEnCurso = false;
		//pedidosPorId = new ArrayList<HashMap<String, String>>();
		
		

	
	public void CargarInformacionEmpresa() throws FileNotFoundException
	
	{
		String archivoUsuarios = "data/users.txt";
		String archivoInventario = "data/inventario.txt";
		
		
		loaderUsuarios(archivoUsuarios);
		loaderInventario(archivoInventario);
		
		
	}
	
		
	public void loaderUsuarios(	String archivoIngredientes) throws FileNotFoundException
	{
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes)))
		{
		ArrayList<String[]> usuarios = new ArrayList<>();
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			String[] comps = new String[3];
			String username = partes[0];
			String password = partes[1];
			String tipousuario = partes[2];
			comps[0]=username;
			comps[1]=password;
			comps[2]=tipousuario;
			usuarios.add(comps);
			
			linea = br.readLine();
			
			
		}
		this.usuarios = usuarios;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	public void loaderInventario(String archivoIngredientes) throws FileNotFoundException
	{
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes)))
		{
		ArrayList<HashMap<Boolean, ArrayList<String>>> general = new ArrayList<>();
		ArrayList<String> inventario = new ArrayList<>();
		HashMap<Boolean, ArrayList<String>> map = new HashMap<>();
		boolean disponible = true;
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			inventario.add(partes[0]);
			inventario.add(partes[1]);
			inventario.add(partes[2]);
			inventario.add(partes[3]);
			inventario.add(partes[4]);
			inventario.add(partes[5]);
			inventario.add(partes[6]);
			
			map.put(disponible, inventario);
			general.add(map);
			

			linea = br.readLine();
			
			
		}
		this.Inventario = general;
		br.close();
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
		
	
	
	
		public static void CrearCliente(String nombre, String correo, String login, String password, String tipoUsuario,
						String fechaNacimiento, String nacionalidad,int licenciaConduccion, String paisExpedicion, 
						String fechaVencimientoLicencia, int telefonoContacto, int numeroTarjetaCredito) throws IOException{
			
			if (tipoUsuario.equals("cliente")){
			
				Cliente nuevoCliente = new Cliente(nombre, correo, login, password, tipoUsuario, fechaNacimiento, nacionalidad,
												licenciaConduccion, paisExpedicion, fechaVencimientoLicencia, telefonoContacto,
												numeroTarjetaCredito);}
			
				String rutaArchivo = "data/users.txt";
				String contenido = login + "," + password + "," + tipoUsuario ;
				BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
				writer.write(contenido);
				writer.newLine(); 
				writer.close();
				
				
				String ruta2 = "data/clientes.txt";
				String contenido2 = nombre + "," + correo + "," + fechaNacimiento + "," + nacionalidad + "," +
							licenciaConduccion + "," + paisExpedicion + "," +  fechaVencimientoLicencia + "," + telefonoContacto
							+ "," + numeroTarjetaCredito;
				BufferedWriter writer1 = new BufferedWriter(new FileWriter(ruta2, true));
				writer1.write(contenido2);
				writer1.newLine(); 
				writer1.close();
			
		}
		
		
	
		public void CrearEmpleado(String login, String password, String tipoUsuario, String nombre, String id, String sede) throws IOException {
			
			if(tipoUsuario.equals("empleado")){
				
				Empleado nuevoEmpleado = new Empleado(login,password,tipoUsuario,nombre,id,sede);
				
				
					String rutaArchivo = "data/users.txt";
					String contenido = login + "," + password + "," + tipoUsuario ;
					BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
					writer.write(contenido);
					writer.newLine(); 
					writer.close();
					
					
					String ruta2 = "data/empleados.txt";
					String contenido2 = nombre + "," + id + "," + sede;
					BufferedWriter writer1 = new BufferedWriter(new FileWriter(ruta2, true));
					writer1.write(contenido2);
					writer1.newLine(); 
					writer1.close();
	
			}
			
				
			}
		
		
		
		public void CrearReserva (String hora_recogida, String hora_entrega, String metodo_pago,
		         int conductor_adicional, String seguros, String tipo_vehiculo) {
			
			
			
			Reserva reserva = new Reserva(hora_recogida, hora_entrega, metodo_pago, conductor_adicional, seguros, tipo_vehiculo);
			reserva.PrecioFinal(hora_recogida, hora_entrega, seguros, tipo_vehiculo, conductor_adicional);
			
		
		}
		
		
		
		
	
	

}
