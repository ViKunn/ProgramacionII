public class Ticket {

	// que el ticket no tenga información del vuelo para reutilización de clases
	// que no exista dependencia Ticket -> Vuelo

	public static final int ECONOMICO = 10;
	public static final int PREMIUM = 100;

	private final String nombrePasajero;
	private final int tipoTicket;

	public Ticket(String nombrePasajero, int tipoTicket) {
		this.nombrePasajero = nombrePasajero;
		this.tipoTicket = tipoTicket;
	}

	private String getTipoTicket(){
		if (tipoTicket == Ticket.ECONOMICO){
			return "ECONOMICO";
		} else if (tipoTicket == Ticket.PREMIUM){
			return "PREMIUM";
		}

		return "ERROR";
	}

	@Override
	//TODO acceder al resto de detalles del ticket
	//TODO como acceder al número de asiento, aunque tal vez no
	public String toString(){
		return nombrePasajero + ", " + getTipoTicket();
	}

}