public class Main {

	public static void main(String[] args) {

		// MVP -> Producto mínimo viable


		Camiseta camiseta = crearUnaCamiseta();

		usarCamisetaYSeEnsucia(camiseta);
		soloPoderUsarCamisetaLimpia(camiseta);
		seRompeCamisetaDespuésDe3Lavadas(camiseta);
		seDestruyeCamisetaDespuésDe5Arregladas(camiseta);


		/****************************/

		Armario armario = new Armario(5);

		armario.guardarCamiseta(camiseta); //no se puede, está cerrado
		armario.abrir();
		armario.guardarCamiseta(camiseta); //no se puede, la camiseta está sucia o en mal estado
		armario.cerrar();
		armario.abrir();

		Camiseta camiseta3 = armario.sacarCamiseta(1);

		System.out.println(armario);


	}

	//1 Crear una camiseta
	private static Camiseta crearUnaCamiseta() {
		Camiseta camiseta = new Camiseta();
		System.out.println("Requerimiento 1 atendido");
		return camiseta;
	}

	//2 Usar una camiseta hace que se ensucie
	private static void usarCamisetaYSeEnsucia(Camiseta camiseta) {
		System.out.println(camiseta);
		camiseta.usar();
		System.out.println(camiseta);
		System.out.println("Requerimiento 2 atendido");
	}

	//3 Solo se puede usar camisetas limpias/en buen estado
	private static void soloPoderUsarCamisetaLimpia(Camiseta camiseta) {
		camiseta.usar();//No se debería poder usar
		camiseta.lavar();
		camiseta.usar(); // ya debería dejar usar
		System.out.println("Requerimiento 3 atendido");
	}

	//4 Con tres lavadas, se rompe
	private static void seRompeCamisetaDespuésDe3Lavadas(Camiseta camiseta) {
		camiseta.lavar();
		camiseta.lavar(); //TODO: Consultar si esto es posible
		System.out.println(camiseta);
		System.out.println("Requerimiento 4 atendido");
	}

	//5 Con cinco arreglos, se destruye, queda inservible
	private static void seDestruyeCamisetaDespuésDe5Arregladas(Camiseta camiseta) {
		camiseta.usar(); // no debería porque está en mal estado
		camiseta.arreglar();
		for (int arregladas = 0; arregladas < 4; arregladas++) {
			camiseta.arreglar(); //TODO: Consultar si esto es posible
			camiseta.usar();
			for (int lavadas = 0; lavadas < 3; lavadas++)
				camiseta.lavar();
			System.out.println(camiseta); // no se puede arreglar más después del 6to uso
		}
	}

}


/*

REGLAS DEL PROGRAMA

1) solo se puede poner una vez y cada vez que se usa se ensucia
2) solamente se puede usar una camiseta limpia y en buen estado
3) cada 3 lavadas -> se rompe
4) después de la 5ta arreglada ya no se puede arreglar

*/