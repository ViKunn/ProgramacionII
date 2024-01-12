public class Moto extends VehículoConMotor{

	public Moto(String matrícula) {
		super(2, 2, matrícula);
	}

	public void ponerCasco(){

	}

	@Override
	public void alistarSeguridad() {
		ponerCasco();
	}
}