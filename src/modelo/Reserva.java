package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Reserva {

	
		private String origen; // nombre, ubi, horarioAtencion // aunq solo por nombre x ahora, no entieno la funcionalidad de lo otro, con un .equals
		private String destino; // nombre, ubi, horarioAtencion // aunq solo por nombre x ahora, no entieno la funcionalidad de lo otro, con un .equals
		private String temporada;
		private double tasaTemporada;
		private String fechaHoraRecogida;
		private String fechaHoraEntrega;
		private String metodoDePago;
		private int conductorAdicional;
		private String seguros;
		private int idReserva;
		private String tipoVehiculo;
		
		public Reserva(String sedeOrigen, String sedeDestino, String hora_recogida, String hora_entrega, String metodo_pago,
			   int conductor_adicional, String seguros, String tipo_vehiculo){
			
			this.temporada = "baja";
			this.origen = sedeOrigen;
			this.destino = sedeDestino;
			this.fechaHoraRecogida = hora_recogida;
			this.fechaHoraEntrega = hora_entrega;
			this.metodoDePago = metodo_pago;
			this.conductorAdicional = conductor_adicional;
			this.seguros = seguros;
			this.tipoVehiculo = tipo_vehiculo;
			Random random = new Random();
			this.idReserva = random.nextInt(100);
			
			
		}
		
		
		
		
		
		
		public int PrecioFinal(String sedeOrigen, String sedeDestino, 
				String hora_recogida, String hora_entrega, String seguros, String tipo_vehiculo, int conductor_adicional) {
			
			int valor_seguros = 0;
			int recargoSede = 0;
			int valor_veh = 0; 
			String temporada =  getTemporada();
			double tasatemp = 0;
			int precio_final;
			
			if (seguros.equals("1"))
				valor_seguros = 45000;
			else if (seguros.equals("2"))
				valor_seguros = 70000;
			else if (seguros.equals("3"))
				valor_seguros = 98000;
			else valor_seguros = 0;
			
			if (sedeOrigen.equals(sedeDestino))
				recargoSede = 0;
			else
				recargoSede = 15000;

			        // Formato de fecha y hora
			 DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

			        // Convertir strings a objetos LocalDateTime
			 LocalDateTime fechaHora1 = LocalDateTime.parse(hora_recogida, formato);
			 LocalDateTime fechaHora2 = LocalDateTime.parse(hora_entrega, formato);

			        // Calcular la diferencia en días
			 long diasDeDiferencia = ChronoUnit.DAYS.between(fechaHora2, fechaHora1);
			 int diasDeDiferenciaComoInt = (int) diasDeDiferencia *(-1);
			 //System.out.println(diasDeDiferenciaComoInt); // pruebas lo esta calulando negativo por eso el *(-1)
			 
			 if (tipo_vehiculo.equalsIgnoreCase("Sedan") || tipo_vehiculo.equalsIgnoreCase("Coupe") || tipo_vehiculo.equalsIgnoreCase("Hatchback") || tipo_vehiculo.equalsIgnoreCase("Compacto"))
				 valor_veh = 50000;
			 if (tipo_vehiculo.equalsIgnoreCase("Pickup") || tipo_vehiculo.equalsIgnoreCase("Station Wagon"))
				 valor_veh = 80000;
			 if (tipo_vehiculo.equalsIgnoreCase("SUV") || tipo_vehiculo.equalsIgnoreCase("Minivan"))
				 valor_veh = 65000;
			 
			 if (fechaHora2.getMonthValue() == 2 || fechaHora2.getMonthValue() == 3 || fechaHora2.getMonthValue() == 4 || fechaHora2.getMonthValue() == 5 || fechaHora2.getMonthValue() == 9 || fechaHora2.getMonthValue() == 10 ) // como determinar esto??, o sea el empleado lo manda o q 
				 tasatemp = 0.02;
			 if (fechaHora2.getMonthValue() == 1 || fechaHora2.getMonthValue() == 6 || fechaHora2.getMonthValue() == 7 || fechaHora2.getMonthValue() == 8 || fechaHora2.getMonthValue() == 11 || fechaHora2.getMonthValue() == 12 )
				 tasatemp = 0.05;
			 
			 int precio_sin_tasa = (valor_veh*diasDeDiferenciaComoInt) + valor_seguros + (conductor_adicional*7000) + recargoSede;
			 precio_final = (int) (precio_sin_tasa + (precio_sin_tasa*tasatemp));
			 
			 return precio_final;
			 
			 
			 }
			
				
			
		

		public String getTipoVehiculo() {
			return tipoVehiculo;
		}






		public void setTipoVehiculo(String tipoVehiculo) {
			this.tipoVehiculo = tipoVehiculo;
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
