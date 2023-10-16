package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	
	private ArrayList<String[]> usuarios;
	private  HashMap<String, ArrayList<Carro>>  inventario;
	
	private HashMap<String, ArrayList<Empleado>> empleados;
	private HashMap<Integer, Reserva> reservas; 
	
	//public Restaurante () throws FileNotFoundException  {   PONER CONSTRUCTOR ACA!!!
		
		//CargarInformacionRestaurante();
		
		//int numeroPedidos = 0;
		//pedidos = new ArrayList<Pedido>();
		//this.pedidoEnCurso = false;
		//pedidosPorId = new ArrayList<HashMap<String, String>>();
		

	
	public void CargarInformacionEmpresa(String nombreSede) throws FileNotFoundException
	
	{
		String archivoUsuarios = "data/users.txt";
		//String archivoInventario = "data/inventario.txt";
		
		
		loaderUsuarios(archivoUsuarios);
		
		
		loaderInventario(); // 
		
		
	}
	
		
	public HashMap<String, ArrayList<Carro>> getInventario() {
		return inventario;
	}


	public void setInventario(HashMap<String, ArrayList<Carro>> inventario) {
		this.inventario = inventario;
	}


	public HashMap<String, ArrayList<Empleado>> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(HashMap<String, ArrayList<Empleado>> empleados) {
		this.empleados = empleados;
	}


	public HashMap<Integer, Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(HashMap<Integer, Reserva> reservas) {
		this.reservas = reservas;
	}


	public void loaderUsuarios(String archivoUsuarios) throws FileNotFoundException
	{
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios)))
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
	
	public void loaderInventario() throws FileNotFoundException
	{
		
		String	archivoInventario = "data/inventario.txt";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario)))
		{
		
		HashMap<String, ArrayList<Carro>> general = new HashMap<>();
		ArrayList<Carro> arr = new ArrayList<>();
		String llave = "Disponible";
		
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			
			int capacidad = Integer.parseInt(partes[5]);
			Carro car = new Carro(partes[0], partes[1], partes[2], partes[3], partes[4], capacidad, partes[6], partes[7]);
			arr.add(car);
			general.put(llave, arr);

			linea = br.readLine();
			
			
		}
		this.inventario = general;
		br.close();
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
	public void loaderInventarioSedeNorte() throws FileNotFoundException
	{
		String archivoInventario = "data/inventario_sede_norte.txt";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario)))
		{
		
		HashMap<String, ArrayList<Carro>> general = new HashMap<>();
		ArrayList<Carro> arr = new ArrayList<>();
		String llave = "Disponible";
		
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			
			int capacidad = Integer.parseInt(partes[5]);
			Carro car = new Carro(partes[0], partes[1], partes[2], partes[3], partes[4], capacidad, partes[6], partes[7]);
			arr.add(car);
			general.put(llave, arr);

			linea = br.readLine();
			
			
		}
		this.inventario = general;
		br.close();
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	public void loaderInventarioSedeSur() throws FileNotFoundException
	{
		String archivoInventario = "data/inventario_sede_sur.txt";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario)))
		{
		
		HashMap<String, ArrayList<Carro>> general = new HashMap<>();
		ArrayList<Carro> arr = new ArrayList<>();
		String llave = "Disponible";
		
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			
			int capacidad = Integer.parseInt(partes[5]);
			Carro car = new Carro(partes[0], partes[1], partes[2], partes[3], partes[4], capacidad, partes[6], partes[7]);
			arr.add(car);
			general.put(llave, arr);

			linea = br.readLine();
			
			
		}
		this.inventario = general;
		br.close();
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	public void loaderInventarioSedeCentro() throws FileNotFoundException
	{
		String archivoInventario = "data/inventario_sede_centro.txt";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoInventario)))
		{
		
		HashMap<String, ArrayList<Carro>> general = new HashMap<>();
		ArrayList<Carro> arr = new ArrayList<>();
		String llave = "Disponible";
		
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			
			int capacidad = Integer.parseInt(partes[5]);
			Carro car = new Carro(partes[0], partes[1], partes[2], partes[3], partes[4], capacidad, partes[6], partes[7]);
			arr.add(car);
			general.put(llave, arr);

			linea = br.readLine();
			
			
		}
		this.inventario = general;
		br.close();
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
	
		
	
	
	
		public void CrearCliente(String nombre, String correo, String login, String password, String tipoUsuario,
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
		
		
		
		public int CrearReserva (String nombre, String licencia, String cedula, String sedeOrigen, String sedeDestino, String hora_recogida, String hora_entrega, String metodo_pago,
		         int conductor_adicional, String seguros, String tipo_vehiculo) throws IOException {
			
			
			
			Reserva reserva = new Reserva(sedeOrigen, sedeDestino, hora_recogida, hora_entrega, metodo_pago, conductor_adicional, seguros, tipo_vehiculo);
			reservas.put(reserva.getIdReserva(), reserva);
			int preciofinal = reserva.PrecioFinal(sedeOrigen, sedeDestino, hora_recogida, hora_entrega, seguros, tipo_vehiculo, conductor_adicional);
			double preciotreinta = preciofinal*0.3;
			
			String rutaArchivo = "data/reservados.txt";
			String contenido = Integer.toString(reserva.getIdReserva()) + "," + nombre + "," + licencia + "," + cedula + ","+ sedeDestino + "," + hora_entrega + "," + tipo_vehiculo + "," + Integer.toString(preciofinal);
			BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true));
			writer.write(contenido);
			writer.newLine(); 
			writer.close();
			
			for (Carro carro : inventario.get("Disponible")) {
	            	
	            	if (carro.getTipovehiculo().equals(tipo_vehiculo)) {
	            		ArrayList<Carro> ca = new ArrayList<>();
	            		ca.add(carro);
	            		inventario.put("Reservados", ca);
	            		int indice = inventario.get("Disponible").indexOf(carro);
	            		inventario.get("Disponible").remove(indice);
	            	}		
						
			}	
			
			return preciofinal;
		}
		
		
		
		public void RecibirCarro(int ID) throws IOException {
			
			Reserva res = reservas.get(ID);
			String tipoveh = res.getTipoVehiculo();
			

			for (Carro carro : inventario.get("Reservados")) {
	            	
	            	if (carro.getTipovehiculo().equals(tipoveh)) {
	            		
	            		inventario.get("Disponible").add(carro); 
	            		int indice = inventario.get("Reservados").indexOf(carro);
	            		inventario.get("Reservados").remove(indice);
	            		
			}
			
			}
			
			
			try (BufferedReader br = new BufferedReader(new FileReader("data/reservados"));
		             BufferedWriter bw = new BufferedWriter(new FileWriter("temporal.txt"))) {

		            String linea;

		            // Lee cada línea del archivo
		            while ((linea = br.readLine()) != null) {
		                // Verifica si la línea cumple con la condición
		                if (obtenerCampo(linea, 0).equals(Integer.toString(ID))) {
		                    // Agrega "finalizado" al final de la línea
		                    linea += " (Finalizado)";
		                }

		                // Escribe la línea (modificada o no) en el archivo temporal
		                bw.write(linea);
		                bw.newLine(); // Agrega un salto de línea después de cada línea escrita
		            }

		            

		        // Renombra el archivo temporal al nombre original
		        renombrarArchivo("temporal.txt", "data/reservados.txt");
			}	
		}
		
		
		
		
		public String obtenerCampo(String linea, int posicion) {
	        // Divide la línea en campos utilizando algún delimitador (por ejemplo, comas)
	        String[] campos = linea.split(",");
	        // Retorna el campo en la posición especificada
	        return campos.length > posicion ? campos[posicion].trim() : "";
	    }
		
		public void renombrarArchivo(String archivoOrigen, String archivoDestino) {
	        // Renombra el archivo temporal al nombre original
	        File origen = new File(archivoOrigen);
	        File destino = new File(archivoDestino);
	    }
		
		
		public void EliminarCarro (String modelo){
			
			for (Carro carro : inventario.get("Disponible")) {
            	
            	if (carro.getModeloCarro().equals(modelo)) {
            		int indice = inventario.get("Disponible").indexOf(carro);
            		inventario.get("Disponible").remove(indice);
            		
            	
					
		}	
			
			
		}
		
		
		
		}
		
		
		
}
	
	


