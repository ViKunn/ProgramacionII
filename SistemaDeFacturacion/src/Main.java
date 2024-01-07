public class Main {
	public static void main(String[] args) {

		Supermercado supermercado = new Supermercado();

		supermercado.añadirAlStock(new ProductoSinIVA("Atún Real 100g", 1.25), 10);
		supermercado.añadirAlStock(new ProductoSinIVA("Leche Vita 1L",  0.90), 10);
		supermercado.añadirAlStock(new ProductoConIVA("Galletas Oreo",  0.75), 10);
		supermercado.añadirAlStock(new ProductoConIVA("Vino",           6.80), 10);


		// PRUEBAS DE PROGRAMA
		pruebaManejoCorrecto(supermercado);
		// pruebaFaltaDeStock(supermercado);
		// pruebaClienteManaba(supermercado);

		supermercado.imprimirStock();

	}

	public static void pruebaManejoCorrecto(Supermercado supermercado){

		ClienteNormal cliente = new ClienteNormal("LUIS ESPÍN", "1700217143");

		cliente.agregarAlCarrito(supermercado, 1, 2);
		cliente.agregarAlCarrito(supermercado, 2, 3);
		cliente.agregarAlCarrito(supermercado, 3, 6);

		Factura factura = supermercado.generarFactura(cliente);
		factura.imprimir();
	}
	public static void pruebaFaltaDeStock(Supermercado supermercado){

		ClienteNormal cliente = new ClienteNormal("ALICIA ORTEGA", "1600271074");

		cliente.agregarAlCarrito(supermercado, 0, 4);       // sobran 6
		cliente.agregarAlCarrito(supermercado, 3, 5);       // falta 1 por lo que no se añade

		Factura factura = supermercado.generarFactura(cliente);
		factura.imprimir();
	}
	public static void pruebaClienteManaba(Supermercado supermercado){
		ClienteConIvaEspecial cliente = new ClienteManaba("PAMELA ESPÍN", "1600864845");

		cliente.agregarAlCarrito(supermercado, 2, 3);
		cliente.agregarAlCarrito(supermercado, 3, 6);

		Factura factura = supermercado.generarFactura(cliente);
		factura.imprimir();

	}


	// TODO
	public static void pruebaManejoCarritoCliente(Supermercado supermercado){

	}

}


/*
	! LISTA DE PRIORIDADES PARA CORRECCIONES

	-   Posteriormente, cuando se añadan al Stock también se debe poder verificar que productos existen dentro del Stock
	-   De esa forma en la Clase cliente también debe existir un vector de productos para poder modificar la cantidad de
		cierto producto cuando se quiera añadir o quitar
	-   Así un algoritmo de búsqueda por posición del item resulta más sencilla además de que resulta posible determinar
		la posición en un inicio

 */