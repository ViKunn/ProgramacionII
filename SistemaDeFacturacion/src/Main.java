import java.sql.SQLOutput;

public class Main {
	public static void main(String[] args) {

		Supermercado supermercado = new Supermercado();

		// SIN IVA
		supermercado.añadirAlStock(new Item(new ProductoSinIVA("Atún Real 100g", 1.25 ), 10));
		supermercado.añadirAlStock(new Item(new ProductoSinIVA("Leche 1L",       0.90 ), 10));

		// CON IVA
		supermercado.añadirAlStock(new Item(new ProductoConIVA("Galletas Oreo",  0.75 ), 10));
		supermercado.añadirAlStock(new Item(new ProductoConIVA("Vino",           6.80 ), 10));

		// PRUEBAS DE PROGRAMA
		// pruebaManejoCorrecto(supermercado);
		// pruebaFaltaDeStock(supermercado);
		pruebaClienteManaba(supermercado);

	}

	public static void pruebaManejoCorrecto(Supermercado supermercado){

		ClienteNormal cliente = new ClienteNormal("LUIS ESPÍN", "1700217143");

		cliente.agregarAlCarrito(supermercado, 1, 2);
		cliente.agregarAlCarrito(supermercado, 2, 3);
		cliente.agregarAlCarrito(supermercado, 3, 6);

		Factura factura = supermercado.venderProductos(cliente);
		factura.imprimir();
	}
	public static void pruebaFaltaDeStock(Supermercado supermercado){

		ClienteNormal cliente = new ClienteNormal("ALICIA ORTEGA", "1600271074");

		cliente.agregarAlCarrito(supermercado, 0, 4);       // sobran 6
		cliente.agregarAlCarrito(supermercado, 3, 5);       // falta 1 por lo que no se añade

		Factura factura = supermercado.venderProductos(cliente);
		factura.imprimir();
	}
	public static void pruebaClienteManaba(Supermercado supermercado){
		ClienteConIvaEspecial cliente = new ClienteManaba("PAMELA ESPÍN", "1600864845");

		cliente.agregarAlCarrito(supermercado, 2, 3);
		cliente.agregarAlCarrito(supermercado, 3, 6);

		Factura factura = supermercado.venderProductos(cliente);
		factura.imprimir();

	}

}


/*
	! LISTA DE PRIORIDADES PARA CORRECCIONES

	- La solución es crear una clase Cliente Normal en la que se inicialice la factura de cierta manera
	- de lo contrario si se inicializa con ClienteConIvaEspecial
	- pero para eso Cliente debe volverse una clase abstracta...

	IMPORTANTE PARA ENTENDER LA IDEA: Revisar las clases herederas de Cliente en el diagrama de clases para entender

 */