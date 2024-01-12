public class Main {
	public static void main(String[] args) {

		// Se crea un objeto de clase Estudiante y se inicializa para evitar error de nullpointer

		// Inicialización SIN constructor
		/*

		Estudiante estudiante1 = new Estudiante();
		estudiante.nombre = "Jaimito";
		estudiante.correto = "jaimito.com"
		estudiante1.nota1 = -2;
		estudiante1.nota2 = 90;

		 */

		// Inicialización CON constructor
		Estudiante estudiante1 = new Estudiante("Jaimito", "jaimito.com");
		estudiante1.nota1 = -2;     // Nota fuera de rango
		estudiante1.nota2 = 90;

		Estudiante estudiante2 = new Estudiante("Juan", "juanito.com");
		estudiante2.nota1 = 70;
		estudiante2.nota2 = 90;


		if (estudiante1.tieneNotasDentroDeRango()) {
			estudiante1.calcularPromedio();
			System.out.println(estudiante1.imprimirResultado());
		} else {
			System.out.println("\nERROR: Una de las notas de " + estudiante1.nombre + " esta fuera del rango.");
		}

		if (estudiante2.tieneNotasDentroDeRango()) {
			estudiante2.calcularPromedio();
			System.out.println(estudiante2.imprimirResultado());
		} else {
			System.out.println("\nERROR: Una de las notas de " + estudiante2.nombre + " esta fuera del rango.");
		}
	}
}