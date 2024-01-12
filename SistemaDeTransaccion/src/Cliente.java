public class Cliente {

	private final String nombre;
	private Cuenta[] cuentas;
	private int numeroDeCuentas;

	public Cliente (String nombre) {
		this.nombre = nombre;
		cuentas = new Cuenta[10];
		numeroDeCuentas = 0;
	}

	public void agregarCuenta(Cuenta cuentaNueva) {
		cuentas[numeroDeCuentas++] = cuentaNueva;
	}
}