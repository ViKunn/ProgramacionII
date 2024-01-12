public class Asiento {

	// private int numeroAsiento;
	private boolean disponible;

	public Asiento() {
		disponible = true;
	}
	public boolean estaDisponible(){
		return disponible;
	}
	public void reservar(){
		disponible = false;
	}
	public void cancelar(){
		disponible = true;
	}

}