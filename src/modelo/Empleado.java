package modelo;

public class Empleado extends Usuario{
	
	private String idTrabajador;
	private String sede;
	private String nombre;
	
	
	public Empleado(String login, String password, String tipoUsuario, String nombre, String id, String sede) {
		super(login, password,tipoUsuario);
		this.nombre = nombre;
		this.idTrabajador = id;
		this.sede = sede;
	}
	

}
