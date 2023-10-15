package modelo;

public class Carro {
	
	
	private String marca;
	private String placa;
	private String modeloCarro;
	private String color;
	private String transmision;
	private int capacidad;
	private String tipoMotor;
	private boolean disponible;
	
	public Carro(String marca, String placa, String modeloCarro, String color, String transmision, int capacidad, String tipoMotor) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}
}
