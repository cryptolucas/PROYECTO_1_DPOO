package modelo;

public class Cliente extends Usuario{
	
	
	
	private String nombre;
	private String correo;
	private String fechaNacimiento;
	private String nacionalidad;
	private int licenciaConduccion; // solo usuario?
	private String paisExpedicion; // solo usuario?
	private String fechaVencimientoLicencia; // solo usuario?
	private int telefonoContacto;
	private int numeroTarjetaCredito; 
	
	
	public Cliente(String nombre, String correo, String login, String password, String tipoUsuario,
						String fechaNacimiento, String nacionalidad,int licenciaConduccion, String paisExpedicion, 
						String fechaVencimientoLicencia, int telefonoContacto, int numeroTarjetaCredito) {
		
		super(login, password, tipoUsuario);
		this.nombre = nombre;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.licenciaConduccion = licenciaConduccion;
		this.paisExpedicion = paisExpedicion;
		this.fechaVencimientoLicencia = fechaVencimientoLicencia;
		this.telefonoContacto = telefonoContacto;
		this.numeroTarjetaCredito = numeroTarjetaCredito;
		

	}

}
