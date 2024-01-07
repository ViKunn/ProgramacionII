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


	public void añadirAlStock(Vector<Item> items){
		for (Item item: items) {
			añadirAlStock(item);
		}
	}
	public void añadirAlStock(Item item){
		item.setNúmeroProducto(contadorProductosEnStock);
		contadorProductosEnStock ++;
		stock.add(item);
	}
	public Vector<Item> getStock() {
		return stock;
	}
	public Item getItemDelStock(int posiciónStock){
		return stock.get(posiciónStock);
	}
	public boolean hayStockSuficiente(int posiciónStock, int cantidad){
		Item itemAComprar =	getItemDelStock(posiciónStock);
		return cantidad <= itemAComprar.getCantidad();
	}
	private void restarStock(Vector<Item> itemsAVender){
		for (Item itemAVender: itemsAVender) {
			restarStock(itemAVender);
		}
	}
	private void restarStock(Item item){
		int posiciónEnStockDeItem = item.getNúmeroProducto();
		int cantidadARestar       = item.getCantidad();

		Item itemEnStock = stock.get(posiciónEnStockDeItem);
		itemEnStock.restarCantidad(cantidadARestar);
	}
	private void restarStock(int posiciónEnStockDeItem, int cantidadARestar){
		Item itemEnStock = stock.get(posiciónEnStockDeItem);
		itemEnStock.restarCantidad(cantidadARestar);
	}
	public void imprimirStock(){
		System.out.println("STOCK\t| PRODUCTO");
		for (Item item: stock) {
			System.out.println( item.getCantidad() + "\t\t|   " + item.getNombre());
		}
	}


	public Factura venderProductos(ClienteNormal cliente){

		Factura factura = new Factura(cliente);

		for (Item itemAVender: cliente.getCarritoDeCompras()) {
			int posiciónEnStock = itemAVender.getNúmeroProducto();
			int cantidadARestar = itemAVender.getCantidad();

			restarStock(posiciónEnStock, cantidadARestar);
		}

		facturas.add(factura);
		return factura;
	}
	public Factura venderProductos(ClienteConIvaEspecial cliente){

		Factura factura = new Factura(cliente);

		for (Item itemAVender: cliente.getCarritoDeCompras()) {
			int posiciónEnStock = itemAVender.getNúmeroProducto();
			int cantidadARestar = itemAVender.getCantidad();

			restarStock(posiciónEnStock, cantidadARestar);
		}

		facturas.add(factura);
		return factura;
	}

}

// ! REVISAR ESTA IDEA

// TODO (Como idea de optimización que no sé si funcione) corregir las funciones de añadir al Stock para que reciban Producto en lugar de Item y de acuerdo con los parámetros de entrada de la función inicializar un vector de productos que van a pertenecer tanto al cliente como al supermercado de tal forma que pueda ocupar un find para determinar si un producto existe en el stock o no. Porque actualmente se inicializa directo el item pero tengo que ocupar un set I mean eso no sería dificil de cambiar en las funciones de añadir Stock pero en cuestión de busqueda y eliminación?