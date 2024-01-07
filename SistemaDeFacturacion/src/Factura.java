import java.util.Vector;

public class Factura {

	private Cliente cliente;
	private double subTotalIVA;
	private double subTotal;
	private double total;
	private double IVAaAplicar;
	private final Vector<Item> items;

	public Factura() {
		this.subTotalIVA = 0;
		this.subTotal = 0;
		this.total = 0;
		items = new Vector<>();
	}
	public Factura(ClienteNormal cliente) {
		this.cliente = cliente;
		this.items = cliente.getCarritoDeCompras();
		subTotal = calcularSubTotal();
		subTotalIVA = calcularSubTotalIVA();
		total = calcularTotal();
	}
	public Factura(ClienteConIvaEspecial cliente){
		this.cliente = cliente;
		this.items = cliente.getCarritoDeCompras();
		IVAaAplicar = cliente.getIVAaAplicar();
		subTotal = calcularSubTotal();
		subTotalIVA = calcularSubTotalIVA(cliente);
		total = calcularTotal();
	}


	public double calcularSubTotal(){

		double precio;
		double cantidad;

		for (Item item: items) {

			precio = item.getPrecio();
			cantidad = item.getCantidad();

			subTotal +=  precio * cantidad;
		}

		return subTotal;
	}
	public double calcularSubTotalIVA(){

		double precio;
		double IVA;

		for (Item item: items) {
			IVA = item.getIVA();
			precio = item.getPrecioTotal();
			subTotalIVA +=  precio * IVA;
		}

		return subTotalIVA;
	}
	private double calcularSubTotalIVA(ClienteConIvaEspecial cliente){

		double precio;
		double IVAaAplicar;

		for (Item item : items) {
			IVAaAplicar = item.getIVA();

			if (IVAaAplicar != 0){
				IVAaAplicar = cliente.getIVAaAplicar();
			}

			precio = item.getPrecioTotal();
			subTotalIVA += precio * IVAaAplicar;
		}

		return subTotalIVA;
	}
	public double calcularTotal(){
		return total = subTotal + subTotalIVA;
	}


	public void imprimir(){

		System.out.println("--------------------------------------------------");
		System.out.println("NOMBRE: " + cliente.getNombre() + "\t\t\tCÉDULA: " + cliente.getCédula());
		System.out.println("--------------------------------------------------");
		System.out.println("PRODUCTO        | CANT    | P.U.       | P.T.");
		System.out.println("--------------------------------------------------");
		for (Item item: items) {

			int     cantidad        = item.getCantidad();
			String  producto          = item.getNombre();
			double  precioUnitario  = item.getPrecio();
			double  precioTotal     = item.getPrecioTotal();  // se calcula el precio total de la cantidad que se quiere
			// de un producto

			System.out.printf("%-15s | %-7d | %-10.2f | %-10.2f%n",
					producto, cantidad, precioUnitario, precioTotal);
		}
		System.out.println("--------------------------------------------------");
		System.out.printf("                  SUBTOTAL               %-10.2f \n" +
						"                  IVA                    %-10.2f \n" +
						"                  TOTAL                  %-10.2f \n",
				subTotal, subTotalIVA, total);
		System.out.println("--------------------------------------------------");

	}
}