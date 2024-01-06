public class Main {
	public static void main(String[] args) {

		Supermercado supermercado = new Supermercado();

		// SIN IVA
		supermercado.añadirAlStock(new Item(new ProductoSinIVA("Atún Real 100g", 1.25 ), 10)); // 10
		supermercado.añadirAlStock(new Item(new ProductoSinIVA("Leche 1L",       0.90 ), 10)); //  8

		// CON IVA
		supermercado.añadirAlStock(new Item(new ProductoConIVA("Galletas Oreo",  0.75 ), 10)); //  7
		supermercado.añadirAlStock(new Item(new ProductoConIVA("Vino",           6.80 ), 10)); //  4

		// PRUEBAS DE PROGRAMA
		// pruebaManejoCorrecto(supermercado);
		// pruebaFaltaDeStock(supermercado);   //Si es que falta stock el producto no se añade

		Cliente cliente = new ClienteManaba("PAMELA ESPÍN", "1600864845");

	}

	public static void pruebaManejoCorrecto(Supermercado supermercado){

		Cliente cliente = new Cliente("LUIS ESPÍN", "1700217143");

		cliente.agregarAlCarrito(supermercado, 1, 2);
		cliente.agregarAlCarrito(supermercado, 2, 3);
		cliente.agregarAlCarrito(supermercado, 3, 6);

		Factura factura = supermercado.venderProductos(cliente);
		// factura.imprimir();
	}
	public static void pruebaFaltaDeStock(Supermercado supermercado){

		Cliente cliente = new Cliente("ALICIA ORTEGA", "1600271074");

		cliente.agregarAlCarrito(supermercado, 0, 4);       // sobran 6
		cliente.agregarAlCarrito(supermercado, 3, 5);       // falta 1 por lo que no se añade

		Factura factura = supermercado.venderProductos(cliente);
		factura.imprimir();
	}

}

/*

		- Configurar diferentes tasas de IVA para productos en la región de la costa y Manabí.
		- Realizar compras con clientes de diferentes provincias.
		- Verificar que el IVA se aplique correctamente según la provincia.

*/