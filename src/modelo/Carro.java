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
	private String tipovehiculo;
	
	public Carro(String marca, String placa, String modeloCarro, String color, String transmision, int capacidad, String tipoMotor, String tipovehiculo) {
		this.marca = marca;
		this.placa = placa;
		this.modeloCarro = modeloCarro;
		this.color = color;
		this.transmision = transmision;
		this.capacidad = capacidad;
		this.tipoMotor = tipoMotor;
		this.tipovehiculo = tipovehiculo;
	}
	
	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipovehiculo() {
		return tipovehiculo;
	}

	public void setTipovehiculo(String tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public String getMarca() {
		return marca;
	}
}
