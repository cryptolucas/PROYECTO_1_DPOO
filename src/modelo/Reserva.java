package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Reserva {

	
	//private Sede origen;
		//private Sede destino;
		private String temporada;
		private double tasaTemporada;
		private String fechaHoraRecogida;
		private String fechaHoraEntrega;
		private String metodoDePago;
		private int conductorAdicional;
		private String seguros;
		private int idReserva;
		private String tipoVehiculo;
		
		public Reserva(String hora_recogida, String hora_entrega, String metodo_pago,
			   int conductor_adicional, String seguros, String tipo_vehiculo){
			
			this.temporada = "baja";
			this.fechaHoraRecogida = hora_recogida;
			this.fechaHoraEntrega = hora_entrega;
			this.metodoDePago = metodo_pago;
			this.conductorAdicional = conductor_adicional;
			this.seguros = seguros;
			this.tipoVehiculo = tipo_vehiculo;
			Random random = new Random();
			this.idReserva = random.nextInt(100);
			
			
		}
		
		
		
		
		
		
		public int PrecioFinal(String hora_recogida, String hora_entrega, String seguros, String tipo_vehiculo, int conductor_adicional) {
			
			int valor_seguros = 0;
			int valor_veh = 0; 
			String temporada =  getTemporada();
			double tasatemp = 0;
			int precio_final;
			
			if (seguros.equals("1"))
				valor_seguros = 45000;
			if (seguros.equals("2"))
				valor_seguros = 70000;
			if (seguros.equals("3"))
				valor_seguros = 98000;
			

			        // Formato de fecha y hora
			 DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

			        // Convertir strings a objetos LocalDateTime
			 LocalDateTime fechaHora1 = LocalDateTime.parse(hora_recogida, formato);
			 LocalDateTime fechaHora2 = LocalDateTime.parse(hora_entrega, formato);

			        // Calcular la diferencia en días
			 long diasDeDiferencia = ChronoUnit.DAYS.between(fechaHora2, fechaHora1);
			 int diasDeDiferenciaComoInt = (int) diasDeDiferencia;
			 
			 if (tipo_vehiculo.equals("Sedan") || tipo_vehiculo.equals("Coupe") || tipo_vehiculo.equals("Hatchback") || tipo_vehiculo.equals("Compacto"))
				 valor_veh = 50000;
			 if (tipo_vehiculo.equals("Pickup") || tipo_vehiculo.equals("Station Wagon"))
				 valor_veh = 80000;
			 if (tipo_vehiculo.equals("SUV") || tipo_vehiculo.equals("Minivan"))
				 valor_veh = 65000;
			 
			 if (temporada.equals("baja"))
				 tasatemp = 0.02;
			 if (temporada.equals("alta"))
				 tasatemp = 0.05;
			 
			 int precio_sin_tasa = (valor_veh*diasDeDiferenciaComoInt) + valor_seguros + (conductor_adicional*7000);
			 precio_final = (int) (precio_sin_tasa + (precio_sin_tasa*tasatemp));
			 
			 return precio_final;
			 
			 
			 }
			
				
			
		

		public String getTemporada() {
			return temporada;
		}

		public void setTemporada(String temporada) {
			this.temporada = temporada;
		}

		public double getTasaTemporada() {
			return tasaTemporada;
		}

		public void setTasaTemporada(double tasaTemporada) {
			this.tasaTemporada = tasaTemporada;
		}

		public String getFechaHoraRecogida() {
			return fechaHoraRecogida;
		}

		public void setFechaHoraRecogida(String fechaHoraRecogida) {
			this.fechaHoraRecogida = fechaHoraRecogida;
		}

		public String getFechaHoraEntrega() {
			return fechaHoraEntrega;
		}

		public void setFechaHoraEntrega(String fechaHoraEntrega) {
			this.fechaHoraEntrega = fechaHoraEntrega;
		}

		public String getMetodoDePago() {
			return metodoDePago;
		}

		public void setMetodoDePago(String metodoDePago) {
			this.metodoDePago = metodoDePago;
		}

		public int getConductorAdicional() {
			return conductorAdicional;
		}

		public void setConductorAdicional(int conductorAdicional) {
			this.conductorAdicional = conductorAdicional;
		}

		public String getSeguros() {
			return seguros;
		}

		public void setSeguros(String seguros) {
			this.seguros = seguros;
		}

		public int getIdReserva() {
			return idReserva;
		}

		public void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}

	

}
