public class Bus extends VehículoConMotor{

	public Bus(int capacidad, String matrícula) {
		super(6, capacidad, matrícula);
	}

	public void agarrarElTubo(){

	}

	@Override
	public void alistarSeguridad() {
		agarrarElTubo();
	}
}