public abstract class Vehículo {

	private int númeroDeLlantas;
	private int capacidad;
	private Asiento[] asientos;

	public Vehículo(int númeroDeLlantas, int capacidad){
		this.númeroDeLlantas = númeroDeLlantas;
		this.capacidad = capacidad;
		asientos = new Asiento[capacidad];
	}

	public void acelerar(){

	}
	public void frenar(){

	}
	public abstract void alistarSeguridad();
}