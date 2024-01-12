public abstract class VehículoConMotor extends Vehículo {

	private String matrícula;

	public VehículoConMotor(int númeroDeLlantas, int capacidad, String matrícula) {
		super(númeroDeLlantas, capacidad);
		this.matrícula = matrícula;
	}

	public void arrancar(){

	}
	public void encender(){

	}
	public void apagar(){

	}
}