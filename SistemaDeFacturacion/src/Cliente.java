import java.util.Vector;

public class Cliente {

	private final String nombre;
	private final String cédula;
	private Vector<Item> carritoDeCompras;

	public Cliente(String nombre, String cédula) {
		this.nombre = nombre;
		this.cédula = cédula;
		this.carritoDeCompras = new Vector<>();
	}


	public String getNombre() {
		return nombre;
	}
	public String getCédula() {
		return cédula;
	}
	public Vector<Item> getCarritoDeCompras() {
		return carritoDeCompras;
	}


	public void agregarAlCarrito(Supermercado supermercado, int posiciónItem, int cantidad) {

		if (!supermercado.hayStockSuficiente(posiciónItem, cantidad)){
			return;
		}

		Item itemDelStock = supermercado.getItemDelStock(posiciónItem);
		Item itemAComprar = new Item(itemDelStock.getNúmeroProducto(),  itemDelStock.getProducto(), cantidad);

		carritoDeCompras.add(itemAComprar);
	}
	public void imprimirCarritoCompras(){
		System.out.println("CANT \t| PRODUCTO");
		for (Item item: carritoDeCompras) {
			System.out.println( item.getCantidad() + "\t\t|   " + item.getNombre());
		}
	}
}

//  TODO    public void retirarItem(Producto producto, int cantidad)