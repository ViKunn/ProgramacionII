abstract class ClienteConIvaEspecial extends Cliente {

	double IVAaAplicar;

	public ClienteConIvaEspecial(String nombre, String cédula, double IvaEspecial) {
		super(nombre, cédula);
		this.IVAaAplicar = IvaEspecial;
	}

	public double getIVAaAplicar(){
		return IVAaAplicar;
	}

}