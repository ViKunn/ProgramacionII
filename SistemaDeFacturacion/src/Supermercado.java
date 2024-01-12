import java.util.Dictionary;
import java.util.Vector;

public class Supermercado {
	private Vector<Factura> facturas;
	private Vector<Item> stock;


	private int contadorProductosEnStock;

	public Supermercado() {
		this.facturas = new Vector<>();
		this.stock = new Vector<>();
		this.contadorProductosEnStock = 0;
	}


	public void añadirAlStock(Vector<Item> items) {
		for (Item item : items) {
			añadirAlStock(item);
		}
	}
	public void añadirAlStock(Item item) {
		item.setNúmeroProducto(contadorProductosEnStock);
		stock.add(item);
		contadorProductosEnStock++;
	}
	public void añadirAlStock(Producto producto, int cantidad) {
		Item item = new Item(producto, cantidad);
		item.setNúmeroProducto(contadorProductosEnStock);
		stock.add(item);
		contadorProductosEnStock++;
	}


	public void aumentarElStock(int posición, int cantidadPorAñadir) {
		Item item = stock.get(posición);
		item.aumentarCantidad(cantidadPorAñadir);
	}
	public void disminuirElStock(int posición, int cantidadPorDisminuir) {
		Item itemEnStock = stock.get(posición);
		itemEnStock.disminuirCantidad(cantidadPorDisminuir);
	}
	public void disminuirElStock(Item item) {
			int posiciónEnStock = item.getNúmeroProducto();
			int cantidadARestar = item.getCantidad();

			disminuirElStock(posiciónEnStock, cantidadARestar);
	}
	public void disminuirElStock(Vector<Item> items){
		for (Item item: items) {
			disminuirElStock(item);
		}
	}


	public Item getItemDelStock(int posiciónStock){
		return stock.get(posiciónStock);
	}
	public boolean hayStockSuficiente(int posiciónStock, int cantidad){
		Item itemAComprar =	getItemDelStock(posiciónStock);
		return cantidad <= itemAComprar.getCantidad();
	}

	public void imprimirStock(){
		System.out.println("STOCK\t| PRODUCTO");
		for (Item item: stock) {
			System.out.println( item.getCantidad() + "\t\t|   " + item.getNombre());
		}
	}

	// se venden los productos
	private void venderProductos(Factura factura, Cliente cliente){
		disminuirElStock(cliente.getCarritoDeCompras());
		facturas.add(factura);
	}

	// la factura se genera de acuerdo con el tipo de cliente que ingresa


	public Factura generarFactura(ClienteNormal clienteNormal){
		Factura factura = new Factura(clienteNormal);
		venderProductos(factura, clienteNormal);
		return factura;
	}
	public Factura generarFactura(ClienteConIvaEspecial clienteConIvaEspecial){
		Factura factura = new Factura(clienteConIvaEspecial);
		venderProductos(factura, clienteConIvaEspecial);
		return factura;
	}

}

/*

	TODO añadir una función que permita retirar productos del stock y que por ende se actualice la posición de item en el vector de stock
	public void retirarDelStock(Producto producto)

	TODO corregir para que el método reciba cliente y aplique el constructor dependiendo del tipo de cliente que ingresa
	private Factura venderProductos(Cliente cliente)

*/