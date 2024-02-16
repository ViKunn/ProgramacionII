public class Fecha {

	private static final int DIAS = 30;
	private static final int MESES = 12;

	private int day;
	private int month;
	private int year;

	public Fecha(int day, int month, int year) {

		if (day > DIAS || month > MESES){
			return;
		}

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public boolean esIgual(Fecha otraFecha){
		return (this.day == otraFecha.day)
				&& (this.month == otraFecha.month)
				&& (this.year == otraFecha.year);
	}
	public boolean esPosterior(Fecha otraFecha){
		if (this.year > otraFecha.year){
			return true;
		}
		else if (this.year == otraFecha.year){
			if (this.month > otraFecha.month){
				return true;
			}
			else if (this.month == otraFecha.month){
				return this.day > otraFecha.day;
			}
		}
		return false;
	}


	@Override
	public String toString() {

		String fecha = "";

		fecha += (day < 10) ? ("0" + day) : (day);
		fecha += "/";

		fecha += (month < 10) ? ("0" + month) : (month);
		fecha += "/";

		fecha += year;

		return fecha;
	}
}