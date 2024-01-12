public class Vuelo {

	// Atributos que aparecen en la información del Vuelo y del ticket al imprimir
	private final int numeroVuelo;
	private final String avion;
	private final String fecha;
	private final String origen;
	private final String destino;

	private Ticket[] ticketsVendidos;
	private int contadorTicketsVendidos;

	private Asiento[] asientosEconomicos;
	private Asiento[] asientosPremium;


	public Vuelo(String avion, String origen, String destino, String fecha, int numeroVuelo,
	             int cantidadAsientosEconomicos, int cantidadAsientosPremium) {

		this.avion = avion;
		this.origen = origen;
		this.destino = destino;
		this.fecha = fecha;
		this.numeroVuelo = numeroVuelo;

		asientosEconomicos = new Asiento[cantidadAsientosEconomicos];
		inicializarAsientos(asientosEconomicos);

		asientosPremium = new Asiento[cantidadAsientosPremium];
		inicializarAsientos(asientosPremium);

		ticketsVendidos = new Ticket[cantidadAsientosEconomicos+ cantidadAsientosPremium];  //máxima cantidad de tickets que podrían venderse dentro del vuelo
	}

	private void inicializarAsientos(Asiento[] asientos){

		for (int i = 0; i < asientos.length ; i++){
			asientos[i] = new Asiento();
		}

	}

	public Ticket comprarTicket(String nombrePasajero, int tipoTicket, int asientoDeseado){

		Ticket ticket = new Ticket(nombrePasajero, tipoTicket);

		if (tipoTicket == Ticket.ECONOMICO){
			if(esPosibleReservarAsiento(asientosEconomicos, asientoDeseado)){
				ticketsVendidos[contadorTicketsVendidos++] = ticket;
				return ticket;
			}
		} else if (tipoTicket == Ticket.PREMIUM){
			if(esPosibleReservarAsiento(asientosPremium, asientoDeseado)){
				ticketsVendidos[contadorTicketsVendidos++] = ticket;
				return ticket;
			}
		} else {
			System.out.println("No existe este tipo de ticket");
		}


		return null;
	}
	private boolean esPosibleReservarAsiento(Asiento[] asientos, int asientoDeseado){
		if(asientoEstaDisponible(asientos, asientoDeseado)){
			asientos[asientoDeseado].reservar();
			System.out.println("Asiento reservado con éxito");
			return true;
		}
		return false;
	}


	private boolean asientoEstaDisponible(Asiento[] asientos, int asientoDeseado) {

		// Comprobar que existe el número de asiento ingresado dentro del array
		if (asientoDeseado >= asientos.length || asientoDeseado < 0){
			System.out.println("No existe este asiento");
			return false;

		// Comprobar si está disponible
		} else if (asientos[asientoDeseado].estaDisponible()){
			return true;
		} else if(!asientos[asientoDeseado].estaDisponible()){
			System.out.println("El asiento no se encuentra disponible");
			return false;
		}

		// Si es que no entra en ninguno de los casos false
		return false;
	}
	private int contarAsientosDisponibles(Asiento[] asientos) {

		int contadorAsientos = 0;

		for (Asiento asiento : asientos) {
			if (asiento.estaDisponible()) {
				contadorAsientos += 1;
			}
		}
		return contadorAsientos;
	}

	private String imprimirTicketsVendidos(){

		String ticketsVendidos = "";

		for (Ticket ticketVendido: this.ticketsVendidos) {
			ticketsVendidos += ticketVendido + "\n";
		}

		return ticketsVendidos;
	}

	@Override
	public String toString(){

		String infoVuelo =                  "INFORMACIÓN DEL VUELO:  " + avion + ", " + origen + "-" + destino + ", " + fecha + ", " + numeroVuelo;
		String infoDisponibilidadAsientos = "DISPONIBILIDAD ASIENTOS:   Económicos(" + contarAsientosDisponibles(asientosEconomicos)
												                  + ")  Premium(" + contarAsientosDisponibles(asientosPremium)   + ")";

		return infoVuelo + "\n" + infoDisponibilidadAsientos + "\n\nTICKETS VENDIDOS: \n" + imprimirTicketsVendidos();
	}
}