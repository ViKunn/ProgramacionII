public class Cuenta {

	private final String numero;
	private double saldo;

	public Cuenta(String numero, float montoApertura) {
		this.numero = numero;
		saldo = montoApertura;
	}

	@Override
	public String toString() {
		return "NumeroCuenta: " + numero + "    $ " + saldo;
	}

	public void transferir(double montoPorTransferir) {
		saldo -= montoPorTransferir;
	}
	public void depositar(double montoPorTransferir) {
		saldo += montoPorTransferir;
	}

	public boolean tieneSaldoSuficiente(double monto) {
		return saldo >= monto;
	}

}