public class ProductoSinIVA extends Producto{

	public ProductoSinIVA(String nombre, double precio) {
		super(nombre, precio);
	}

	@Override
	public double getIVA() {
		return 0;
	}

}