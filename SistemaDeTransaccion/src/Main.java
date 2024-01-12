public class Main {
	public static void main(String[] args) {

		//! Creación de la cuenta de clientes en un banco
		Banco pichincha = new Banco("Pichincha");
		Cuenta cuenta1 = pichincha.abrirCuenta(new Cliente("Carlos"), 200);

		System.out.println("CREAR BANCO Y CREAR UNA CUENTA");
		System.out.println(cuenta1);

		//! Crear cuenta sin monto mínimo de 20
		Cuenta cuentaFallida = pichincha.abrirCuenta(new Cliente("Fernando"), 0);

		System.out.println("\nCREAR UNA CUENTA SIN MONTO MINIMO");
		System.out.println(cuentaFallida);

		//! Transferir dinero entre cuentas con saldo
		Cuenta cuenta2 = pichincha.abrirCuenta(new Cliente("Fernando"), 2000);

		System.out.println("\nTRANSFERIR DINERO ENTRE CUENTAS CON SALDO");
		hacerYImprimirInfoTransaccion(pichincha, cuenta1, cuenta2, 20);

		//! Transferir dinero entre cuentas sin saldo
		Cuenta cuenta3 = pichincha.abrirCuenta(new Cliente("Alexa"), 30);

		System.out.println("\nTRANSFERIR DINERO ENTRE CUENTAS SIN SALDO");
		hacerYImprimirInfoTransaccion(pichincha, cuenta3, cuenta1, 40);

		//! Transferir con monto negativo
		System.out.println("\nTRANSFERIR CON MONTO NEGATIVO");
		hacerYImprimirInfoTransaccion(pichincha, cuenta1, cuenta2, -20);

		//! Transferir a cuenta null
		System.out.println("\nTRANSFERIR DESDE UNA CUENTA QUE NO EXISTE");
		hacerYImprimirInfoTransaccion(pichincha, cuentaFallida, cuenta1, -20);

		System.out.println("\nTRANSFERIR HACIA UNA CUENTA QUE NO EXISTE");
		hacerYImprimirInfoTransaccion(pichincha, cuenta1, cuentaFallida, -20);

		System.out.println("\nTRANSFERIR ENTRE CUENTAS QUE NO EXISTEN");
		Cuenta otraCuentaFallida = pichincha.abrirCuenta(new Cliente("Fer"), 0);
		hacerYImprimirInfoTransaccion(pichincha, cuentaFallida, otraCuentaFallida, -20);

		//! Cada transferencia cuesta 0.40 ctvs
		System.out.println("\nCADA TRANSFERENCIA CUESTA 0.40 ctvs");
		hacerYImprimirInfoTransaccion(pichincha, cuenta1, cuenta2, 179.2);

		//TODO transferir de un banco a otro
		Banco banco1 = new Banco("BANCO 1");
		Banco banco2 = new Banco("BANCO 2");
		
	}

	private static void hacerYImprimirInfoTransaccion(Banco banco, Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
		System.out.println(cuentaOrigen);
		System.out.println(cuentaDestino);

		System.out.println("TRANSFIRIENDO..." + monto);

		Transaccion transaccion = banco.transferir(cuentaOrigen, cuentaDestino, monto);
		System.out.println(cuentaOrigen);
		System.out.println(cuentaDestino);
		System.out.println("\n" + transaccion);
	}

}