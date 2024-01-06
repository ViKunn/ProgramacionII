public class ProductoConIVA extends Producto {

	private final double IVA = 0.12;

	public ProductoConIVA(String nombre, double precio) {
		super(nombre, precio);
	}

	@Override
	double getIVA() {
		return IVA;
	}

}