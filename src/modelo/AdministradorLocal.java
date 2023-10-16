package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class AdministradorLocal {
	
	private String nombre;
	private String sede;
	private String password;
	
	public AdministradorLocal(String nombre, String sede, String pass) {
		this.nombre = nombre;
		this.sede = sede;
		this.password = pass;
	}
	
	
	public ArrayList<String[]> NominaSede()
	{
		ArrayList<String[]> arr = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("data/empleados.txt")))
		{
		
		
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(",");
			if (partes[2].equals(this.sede)) {
				String[] v = new String[3];
				v[0] = partes[0];
				v[1] = partes[1];
				v[2]= partes[2];  
				arr.add(v);
				
			
			}
			

			linea = br.readLine();
			
			
		}
		br.close();
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			return arr;
		}
	
	

}
