public class Carro extends VehículoConMotor{

	public Carro(int capacidad, String matrícula) {
		super(4, capacidad, matrícula);
	}

	public void ponerCinturón() {

	}

	@Override
	public void alistarSeguridad() {
		ponerCinturón();
	}
}