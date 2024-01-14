public class Main {
	public static void main(String[] args) {

		Empresa empresa = new Empresa("XYZ");

		// 1. Reservar turno para un cliente
		System.out.println("1. RESERVAR TURNO PARA UN CLIENTE\n");
		reservarTurnoShouldReturnTurnoWhenFechaIsPosteriorAFechaActual(empresa);

		// 2. Solo se puede entregar un turno por cliente
		System.out.println("\n\n\n2. SOLO SE PUEDE ENTREGAR UN TURNO POR CLIENTE\n");
		reservarTurnoShouldReturnOneTurnoNullWhenClienteTriesReservarTurnoMoreThanOnce(empresa);

		// 3. Se puede hacer una cancelación de turno para poder tomar otro
		System.out.println("\n\n\n3. SE PUEDE REAGENDAR TURNOS\n");
		reagendarTurnoShouldReturnADifferentTurnoWhenTurnoIsGiven(empresa);

		// 4.  Existen turnos NORMAL y URGENTE, cambian la prioridad, es decir, si un turno urgente se genera al final,
		//     este deberá atenderse primero, esto se demuestra en la impresión de los turnos del día
		System.out.println("\n\n\n4. EL TIPO DE TURNO CAMBIA LA PRIORIDAD\n");
		reservarTurnoShouldChangeThePriorityOfTheTurnosInVectorTurnosForThatDayWhenATipoDeTurnoIsGiven(empresa);

		// 5.  Solo se pueden entregar hasta 3 turnos por día.
		System.out.println("\n\n\n5. SOLO SE PUEDEN ENTREGAR HASTA 3 TURNOS AL DIA\n");
		reservarTurnoShouldReturnNullWhenThereIsAlreadyThreeTurnosThatDay(empresa);

	}

	public static void reservarTurnoShouldReturnTurnoWhenFechaIsPosteriorAFechaActual(Empresa empresa){

		Cliente pamela = new Cliente("Pamela");
		TipoTurno NORMAL = TipoTurno.NORMAL;

		Fecha fechaAnterior = new Fecha(12, 1, 2024);
		Fecha fechaActual   = new Fecha(13, 1, 2024);
		Fecha fechaPosterior= new Fecha( 1, 3, 2024);


		System.out.println("FECHA ANTERIOR: " + fechaAnterior);
		Turno turno1 = empresa.agendarTurno(pamela, fechaAnterior, NORMAL);
		System.out.println(turno1);


		System.out.println("\nFECHA ACTUAL: " + fechaActual);
		Turno turno2 = empresa.agendarTurno(pamela, fechaActual, NORMAL);
		System.out.println(turno2);


		System.out.println("\nFECHA POSTERIOR: " + fechaPosterior);
		Turno turno3 = empresa.agendarTurno(pamela, fechaPosterior, NORMAL);
		System.out.println(turno3);

	}
	public static void reservarTurnoShouldReturnOneTurnoNullWhenClienteTriesReservarTurnoMoreThanOnce(Empresa empresa){

		Cliente paul = new Cliente("Paul");
		TipoTurno NORMAL = TipoTurno.NORMAL;

		Fecha fecha1 = new Fecha(14,1,2024);
		Fecha fecha2 = new Fecha(16,1,2024);

		Turno turno1 = empresa.agendarTurno(paul, fecha1, NORMAL); // se imprime
		Turno turno2 = empresa.agendarTurno(paul, fecha2, NORMAL); // null

		System.out.println(turno1);
		System.out.println(turno2);

	}
	public static void reagendarTurnoShouldReturnADifferentTurnoWhenTurnoIsGiven(Empresa empresa){

		Cliente alicia = new Cliente("Alicia");
		TipoTurno NORMAL = TipoTurno.NORMAL;

		Fecha fecha = new Fecha(14,1,2024);
		Fecha nuevaFecha = new Fecha(15,1,2024);


		Turno turno = empresa.agendarTurno(alicia, fecha, NORMAL);
		System.out.println(turno);

		turno = empresa.reagendarTurno(turno, nuevaFecha, NORMAL);
		System.out.println(turno);
	}
	public static void reservarTurnoShouldChangeThePriorityOfTheTurnosInVectorTurnosForThatDayWhenATipoDeTurnoIsGiven(Empresa empresa){

		Cliente luis = new Cliente("Luis"); // NORMAL
		Cliente pame = new Cliente("Pame"); // URGENTE
		Cliente vivi = new Cliente("Vivi"); // NORMAL

		TipoTurno urgent = TipoTurno.URGENT;
		TipoTurno normal = TipoTurno.NORMAL;

		Fecha fecha = new Fecha(13,2,2024);

		Turno turnoLuis = empresa.agendarTurno(luis, fecha, normal);
		Turno turnoPame = empresa.agendarTurno(pame, fecha, normal);
		Turno turnoVivi = empresa.agendarTurno(vivi, fecha, urgent);

		empresa.presentarTurnosDelDia(fecha);
	}
	public static void reservarTurnoShouldReturnNullWhenThereIsAlreadyThreeTurnosThatDay(Empresa empresa){

		Cliente luis = new Cliente("Luis"); // NORMAL
		Cliente pame = new Cliente("Pame"); // URGENTE
		Cliente vivi = new Cliente("Vivi"); // NORMAL
		Cliente paul = new Cliente("Paul"); // URGENTE

		TipoTurno urgent = TipoTurno.URGENT;
		TipoTurno normal = TipoTurno.NORMAL;

		Fecha fecha = new Fecha(13,2,2024);

		Turno turnoLuis = empresa.agendarTurno(luis, fecha, normal);
		Turno turnoPame = empresa.agendarTurno(pame, fecha, normal);
		Turno turnoVivi = empresa.agendarTurno(vivi, fecha, urgent);


		Turno turnoPaul = empresa.agendarTurno(paul, fecha, TipoTurno.URGENT);  // should be null
		System.out.println("Turno Paul: " + turnoPaul);


		System.out.println("\nTURNOS AGENDADOS ESE DIA");
		empresa.presentarTurnosDelDia(fecha);


	}

}