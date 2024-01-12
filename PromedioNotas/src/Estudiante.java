// ENCAPSULAMIENTO
public class Estudiante {

	// Características/Atributos/Fields del concepto
	// Siempre son SUSTANTIVOS

	private static final int PROMEDIO_MINIMO = 70;
	private static final int NOTA_MINIMA = 0;
	private static final int NOTA_MAXIMA = 100;

	// Un estudiante TIENE...
	public String nombre;
	public String correo;
	public double nota1;
	public double nota2;
	private double promedio;

	// Constructor por defecto
	public Estudiante() {
	}

	/*  Constructores:
		Me permite inicializar una "estructura" a partir de los atributos del estudiante, usando Estudiante como un MÉTODO
		Estudiante() es un MÉTODO, que se puede usar para INICIALIZAR los datos de un objeto */

	public Estudiante(String nombre, String correo, double nota1, double nota2) {
		this.nombre = nombre;
		this.correo = correo;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	/*  Estas funciones en nuestro programa son PROPIOS del estudiante, entonces se puede añadir estas funciones
	    dentro de la clase Estudiante son comportamientos que puede tener una clase, a estos se los denomina métodos
	    Siempre son VERBOS */

	public boolean tieneNotasDentroDeRango() {
		return  (nota1 >= NOTA_MINIMA && nota1 <= NOTA_MAXIMA) &&
				(nota2 >= NOTA_MINIMA && nota2 <= NOTA_MAXIMA);
	}

	/*
	    Modificadores de Acceso:
	    - PUBLIC: es un modificador de acceso, los métodos serán (en su mayoría) PÚBLICOS
	    - PRIVATE: es un modificador de acceso, los atributos serán (en su mayoría) PRIVADOS

	    TODOS los métodos modifican/alteran/interactúan con los atributos */

	public double calcularPromedio() {
		return (nota1 + nota2)/2;
	}

	public String imprimirResultado() {
		promedio = calcularPromedio();
		if (promedio > PROMEDIO_MINIMO) {
			return "El estudiante " + nombre + " aprueba la asignatura";
		} else {
			return "El estudiante " + nombre + " reprueba la asignatura";
		}
	}

	/*
		Métodos:
		- GETTER, se caracteriza por RETORNAR
		- SETTER, se caracteriza por ASIGNAR / MODIFICAR, se usa más para modificar
	*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		// palabra reservada "this" haciendo referencia al objeto y luego del punto al atributo
		this.nombre = nombre;
	}

}

/*

- ¿Por qué hacer privados los atributos si voy a hacer métodos SET y GET para modificarlos?
- lunes: DIAGRAMACIÓN;

*/