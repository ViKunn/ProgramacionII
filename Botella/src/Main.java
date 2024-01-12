public class Main {
	public static void main(String[] args) {

		//String azul = "azul";
		Botella botella = new Botella("azul", 2, "plástico", 20);
		Botella botella2 = new Botella("rojo", 3, "oro", 40);

		System.out.println("\nBOTELLA 1:");

		botella.llenar(1); //capacidadActualLitros = 0
		botella.imprimirCapacidadActual();
		botella.destapar(); //Tapado = false
		botella.llenar(10); //capacidadActualLitros = 2
		botella.imprimirCapacidadActual();
		botella.vaciar(); //capacidadActualLitros = 0
		botella.imprimirCapacidadActual();
		botella.llenar(-10); //ERROR!! //capacidadActualLitros = 0
		botella.imprimirCapacidadActual();
		botella.llenar(2); //capacidadActualLitros = 2
		botella.imprimirCapacidadActual();
		botella.tapar(); //Tapado = true
		botella.vaciar(); //capacidadActualLitros = 2
		botella.imprimirCapacidadActual();


		System.out.println("\nBOTELLA 2:");

		botella2.destapar();
		botella2.llenar();
		botella2.imprimirCapacidadActual(); //3
		botella.destapar();


		System.out.println("\nLlenando botella roja con con contenido de botella azul: ");

		botella.vaciar();
		botella.imprimirCapacidadActual(); // 0
		botella2.imprimirCapacidadActual(); // 3

		botella.llenar(botella2);

		botella.imprimirCapacidadActual(); // 2
		botella2.imprimirCapacidadActual(); // 1

	}
}