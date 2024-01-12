public class Main {
	public static void main(String[] args) {

		Calculadora calculadora = new Calculadora();

		calculadora.realizarOperación(new Suma(), 13.5, 0.5);
		calculadora.realizarOperación(new Suma(), new Binario(10), new Binario(11));

	}
}