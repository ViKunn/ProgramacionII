public class Turno {

	private Cliente cliente;
	private Fecha fecha;
	private TipoTurno tipoTurno;

	public Turno(Cliente cliente, Fecha fecha, TipoTurno tipoTurno) {
		this.cliente = cliente;
		this.fecha = fecha;
		this.tipoTurno = tipoTurno;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public Fecha getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Turno [" + tipoTurno +	", " + fecha + ", " + cliente.getNombre() + "]";
	}

	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}
}