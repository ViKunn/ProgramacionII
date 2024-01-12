public class Botella {

	private String color;
	private double capacidadMáximaLitros;
	private double capacidadActualLitros;
	private String material;
	private double pesoOnzas;
	private boolean tapado;


	public Botella(String color, double capacidadMáximaLitros, String material, double pesoOnzas) {
		this.color = color;
		this.capacidadMáximaLitros = capacidadMáximaLitros;
		this.material = material;
		this.pesoOnzas = pesoOnzas;
		tapado = true;
		capacidadActualLitros = 0;
	}


	public void llenar(){
		llenar(capacidadMáximaLitros);
	}
	public void llenar(Botella otraBotella){
		if(otraBotella.estaTapado() || estaTapado()){
			return;
		}
		double cantidadATransferir = obtenerCapacidadResidual();
		if(cantidadATransferir > otraBotella.capacidadActualLitros)
			cantidadATransferir = otraBotella.capacidadActualLitros;
		llenar(cantidadATransferir);
		otraBotella.vaciar(cantidadATransferir);
	}
	public void llenar(double cantidadALlenar) {
		if(estaTapado()) {
			return;
		}
		if(cantidadALlenar < 0) {
			return;
		}
		capacidadActualLitros =
				seRebasaLaCapacidad(cantidadALlenar) ?
						capacidadMáximaLitros:
						cantidadALlenar + capacidadActualLitros;
	}

	private double obtenerCapacidadResidual() {
		return capacidadMáximaLitros - capacidadActualLitros;
	}

	private boolean seRebasaLaCapacidad(double cantidadALlenar) {
		return cantidadALlenar + capacidadActualLitros > capacidadMáximaLitros;
	}
	private boolean estaTapado() {
		return tapado;
	}

	public void vaciar() {
		vaciar(capacidadMáximaLitros);
	}
	public void vaciar(double cantidadAVaciar) {
		if(estaTapado()) {
			return;
		}
		if(cantidadAVaciar < 0) {
			return;
		}
		capacidadActualLitros -= cantidadAVaciar;
	}

	public void tapar() {
		tapado = true;
	}
	public void destapar() {
		tapado = false;
	}

	public void imprimirCapacidadActual() {
		System.out.println(color + ": " + capacidadActualLitros + "L.");
	}

}