public class ProductoConIVA extends Producto {

	private final double IVA = 0.12;

	public ProductoConIVA(String nombre, double precio) {
		super(nombre, precio);
	}

	@Override
	public double getIVA() {
		return IVA;
	}

}