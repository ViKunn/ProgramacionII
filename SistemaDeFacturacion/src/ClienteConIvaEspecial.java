class ClienteConIvaEspecial extends Cliente {

	double IVAaAplicar;

	public ClienteConIvaEspecial(String nombre, String cédula, double IVAaAplicar) {
		super(nombre, cédula);
		this.IVAaAplicar = IVAaAplicar;
	}

	public double getIVAaAplicar(){
		return IVAaAplicar;
	}

}