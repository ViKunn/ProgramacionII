import java.util.Vector;

public class Empresa {

	private final int DIA_ACTUAL = 13;
	private final int MES_ACTUAL = 1;
	private final int YEAR_ACTUAL = 2024;
	private final int MAX_TURNOS_POR_DIA = 3;

	private String nombre;
	private Fecha fechaActual;
	private Vector<Turno> turnos;


	public Empresa(String nombre) {
		this.nombre = nombre;
		turnos = new Vector<>();
		fechaActual = new Fecha(DIA_ACTUAL, MES_ACTUAL, YEAR_ACTUAL);
	}


	public Turno agendarTurno(Cliente cliente, Fecha fecha, TipoTurno tipoTurno){

		if (fecha == null || cliente == null){
			return null;
		}
		if (!fecha.esPosterior(fechaActual)){
			return null;
		}
		if (elClienteYaTieneTurno(cliente)){
			return null;
		}
		if (!fechaEstaDisponible(fecha)){
			return null;
		}

		Turno turno = new Turno(cliente, fecha, tipoTurno);
		turnos.add(turno);

		reordenarTurnos();

		return turno;
	}
	public Turno reagendarTurno(Turno turno, Fecha NuevaFecha, TipoTurno tipoTurno){

		Cliente cliente = turno.getCliente();

		turnos.remove(turno);
		turno = agendarTurno(cliente, NuevaFecha, tipoTurno);

		return turno;
	}


	private Vector<Turno> getTurnos(TipoTurno tipoTurno){

		Vector<Turno> turnos = new Vector<>();

		for (Turno turno: this.turnos) {
			if (turno.getTipoTurno().equals(tipoTurno)){
				turnos.add(turno);
			}
		}

		return turnos;
	}
	private void reordenarTurnos(){
		Vector<Turno> turnosNormales = getTurnos(TipoTurno.NORMAL);
		Vector<Turno> turnosUrgentes = getTurnos(TipoTurno.URGENT);

		turnos.clear();
		turnos.addAll(turnosUrgentes);
		turnos.addAll(turnosNormales);
	}


	private boolean elClienteYaTieneTurno(Cliente cliente){
		for (Turno turno: turnos) {
			if (turno.getCliente().equals(cliente)){
				return true;
			}
		}
		return false;
	}
	private boolean fechaEstaDisponible(Fecha fecha) {
		int contadorFechasDelDia = 0;

		for (Turno turno: turnos) {
			if (turno.getFecha().esIgual(fecha)){
				contadorFechasDelDia ++;
			}
		}

		return contadorFechasDelDia < MAX_TURNOS_POR_DIA;
	}


	private Vector<Turno> getTurnosDelDia(Fecha fecha){

		Vector<Turno> turnosDelDia = new Vector<>();

		for (Turno turno: turnos) {
			if (turno.getFecha().esIgual(fecha)){
				turnosDelDia.add(turno);
			}
		}

		return turnosDelDia;
	}
	public void presentarTurnosDelDia(Fecha fecha){
		Vector<Turno> turnosDelDia = getTurnosDelDia(fecha);

		for (Turno turno: turnosDelDia) {
			System.out.println(turno);
		}
	}


	@Override
	public String toString() {
		return "Empresa{" +
				"nombre='" + nombre + '\'' +
				'}';
	}
}