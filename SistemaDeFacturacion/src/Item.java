public class Item {

	private Producto producto;
	private int cantidad;
	private int númeroProducto;

	public Item(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Item(int númeroProducto, Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.númeroProducto = númeroProducto;
	}


	public Producto getProducto() {
		return producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public int getNúmeroProducto() {
		return númeroProducto;
	}


	public String getNombre(){
		return producto.getNombre();
	}
	public double getIVA(){
		return producto.getIVA();
	}
	public double getPrecio(){
		return producto.getPrecio();
	}
	public double getPrecioTotal() {
		return (producto.precio)*(cantidad);
	}


	public void setNúmeroProducto(int númeroProducto) {
		this.númeroProducto = númeroProducto;
	}


	public void restarCantidad(int cantidadARestar) {
		this.cantidad = cantidad - cantidadARestar;
	}
}