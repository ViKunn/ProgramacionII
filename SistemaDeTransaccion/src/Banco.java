import java.sql.SQLOutput;

public class Banco {

	public static final double MONTO_MINIMO_APERTURA = 20;
	private final String nombre;
	private Cliente[] clientes;
	private int numeroDeClientes;
	private Transaccion[] transacciones;
	private int numeroDeTransacciones;

	public Banco(String nombre) {
		this.nombre = nombre;
		clientes = new Cliente[10];
		numeroDeClientes = 0;
		numeroDeTransacciones = 0;
		transacciones = new Transaccion[20];
	}

	public Cuenta abrirCuenta(Cliente clientePotencial, float montoApertura){

		if (!cumpleMontoMinimo(montoApertura)){
			System.out.println("No aceptamos clientes pobres");
			return null;
		}

		// Registrar Cliente
		registrarCliente(clientePotencial);

		// Crear la cuenta
		Cuenta cuentaNueva;
		cuentaNueva= new Cuenta("ABC123", montoApertura);

		//Asociar Cliente con la cuenta
		clientePotencial.agregarCuenta(cuentaNueva);

		// Devolver cuenta
		return cuentaNueva;
	}
	private static boolean cumpleMontoMinimo(float montoApertura) {
		return montoApertura >= MONTO_MINIMO_APERTURA;
	}
	private void registrarCliente(Cliente clientePotencial) {
		clientes[numeroDeClientes++]	= clientePotencial;
	}

	public Transaccion transferir(Cuenta cuentaOrigen, Cuenta cuentaDestino, double montoPorTransferir) {

		double costoTransacción = 0.40;
		double valorADebitar = costoTransacción + montoPorTransferir;

		if (cuentaOrigen == null && cuentaDestino == null){
			System.out.println("TRANSACCIÓN FALLIDA: Las cuentas especificadas no existen");
			return null;
		}
		if (cuentaOrigen == null){
			System.out.println("TRANSACCIÓN FALLIDA: No existe la cuenta de origen");
			return null;
		}
		if (cuentaDestino == null) {
			System.out.println("TRANSACCIÓN FALLIDA: No existe la cuenta de destino");
			return null;
		}
		if (montoPorTransferir <= 0){
			System.out.println("TRANSACCIÓN FALLIDA: El monto a transferir debe ser positivo");
			return null;
		}
		if (!cuentaOrigen.tieneSaldoSuficiente(valorADebitar)){
			System.out.println("TRANSACCIÓN FALLIDA: Saldo insuficiente");
			return null;
		}

		cuentaOrigen.transferir(valorADebitar);
		cuentaDestino.depositar(montoPorTransferir);

		Transaccion transaccion = new Transaccion(cuentaOrigen, cuentaDestino, montoPorTransferir);
		transacciones[numeroDeTransacciones++] = transaccion;

		return transaccion;

	}
}