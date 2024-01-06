public class ProductoSinIVA extends Producto{

	public ProductoSinIVA(String nombre, double precio) {
		super(nombre, precio);
	}

	@Override
	double getIVA() {
		return 0;
	}

}