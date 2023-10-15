package modelo;

public class Sede {

	private String nombre;
	private String ubicacion;
	private String horarioAtencion;
	
	public Sede(String nombre, String ubicacion, String horarioAtencion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.horarioAtencion = horarioAtencion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
