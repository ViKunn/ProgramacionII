import java.util.Vector;

public class Factura {

	private Cliente cliente;
	private double subTotalIVA;
	private double subTotal;
	private double total;
	private double IVAaAplicar;
	private final Vector<Item> items;


	private Factura(Cliente cliente) {
		this.cliente = cliente;
		this.items = cliente.getCarritoDeCompras();
		subTotal = calcularSubTotal();
	}

	public Factura(ClienteNormal cliente) {
		this((Cliente) cliente);
		subTotalIVA = calcularSubTotalIVA();
		total = calcularTotal();
	}
	public Factura(ClienteConIvaEspecial cliente){
		this((Cliente) cliente);
		subTotalIVA = calcularSubTotalIVA(cliente);
		total = calcularTotal();
	}

	private double calcularSubTotal(){

		double total = 0;
		double precio;
		double cantidad;

		for (Item item: items) {

			precio = item.getPrecio();
			cantidad = item.getCantidad();

			total +=  precio * cantidad;
		}

		return total;
	}

	private double calcularSubTotalIVA() {

		double total;
		double precio;
		double IVA;

		for (Item item: items){
			IVAaAplicar = item.getIVA();
			precio = item.getPrecioTotal();
			subTotalIVA +=  precio * IVAaAplicar;
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

	private double calcularTotal(){
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