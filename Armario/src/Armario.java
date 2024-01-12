import java.util.Vector;

public class Armario {

	private int capacidadArmario;
	private Vector camisetas;
	private boolean abierto;


	public Armario(int capacidadArmario) {
		this.capacidadArmario = capacidadArmario;
		camisetas = new Vector<Camiseta>();
		//camisetas = new Camiseta[capacidadArmario];
	}


	public void guardarCamiseta(Camiseta camiseta) {
		if (camiseta.estaGuardada()) {
			System.out.println("La camiseta ya está guardada actualmente");
			return;

		} else if(!abierto){
			System.out.println("No se puede guardar, el armario está cerrado");
			return;

		}else if (camisetas.size() < capacidadArmario) {
			camisetas.addElement(camiseta);
			camiseta.guardar();
			return;

		} else {
			System.out.println("El armario no tiene más capacidad");
			return;
		}
	}

	public Camiseta sacarCamiseta(Camiseta camiseta) {

		int indexCamiseta;

		if (!camiseta.estaGuardada()){
			System.out.println("La camiseta no está dentro del armario");
			return null;

		} else if (camisetas.contains(camiseta)) {

			indexCamiseta = camisetas.indexOf(camiseta);
			camisetas.get(indexCamiseta);
		}

		//camisetas.get();
		//camisetas.remove();

		camisetas.contains(camiseta);


		camiseta.sacar();

		return camiseta;
	}
	public Camiseta sacarCamiseta(int numeroCamiseta) {
		Camiseta camiseta = new Camiseta();
		return camiseta;
	}

	public void abrir() {
		if (abierto) {
			System.out.println("El armario ya está abierto actualmente");
			return;
		}
		abierto = true;
	}
	public void cerrar() {
		if (!abierto) {
			System.out.println("El armario ya está cerrado actualmente");
			return;
		}
		abierto = false;
	}

	@Override
	public String toString() {

		return "Capacidad: " + String.valueOf(camisetas.size());
	}
}