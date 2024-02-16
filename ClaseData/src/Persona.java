import java.io.Serializable;

public class Persona  implements Serializable {

	// transient (modificador)

	private String nombre;
	private transient Aula aula;

	public Persona(String nombre){
		this.nombre = nombre;
	}

	@Override
	public String toString(){
		return super.toString() + " " + nombre;
	}

}