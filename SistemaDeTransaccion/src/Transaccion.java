import java.time.LocalDateTime;

public class Transaccion {

	private final LocalDateTime fecha;
	private final Cuenta cuentaOrigen;
	private final Cuenta cuentaDestino;
	private final double monto;

	public Transaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.monto = monto;
		fecha = LocalDateTime.now();
	}

	@Override
	public String toString(){
		return "TRANSACCION" + "\n" +
				"Fecha: " + fecha + "\n" +
				"CuentaOrigen: " + cuentaOrigen + "\n" +
				"CuentaDestino: " + cuentaDestino + "\n" +
				"Monto: " + monto;
	}
}