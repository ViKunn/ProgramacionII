public class Main {
	public static void main(String[] args) {

		// 1. PRUEBA DE INICIALIZACIÓN DEL VUELO -> copiar Constructor de la clase vuelo
		System.out.println("-> CREANDO VUELO");
		Vuelo vuelo1 = new Vuelo("Airlines", "UIO", "NYE", "14/DIC/2023",
						        3123, 4, 2);

		// 2. PRUEBA DE IMPRESIÓN DE ESTADO DEL VUELO
		System.out.println(vuelo1);

		// Caso 1 -> Vender Ticket
		// Caso 3 -> Vender asiento ECONOMICO
		// 3. PRUEBA DE VENTA DE TICKET
		System.out.println("\n-> COMPRANDO TICKET");
		Ticket ticket1 = vuelo1.comprarTicket("Alicia", Ticket.ECONOMICO, 3);

		// 4. PRUEBA DE IMPRESIÓN DE ESTADO DEL TICKET E INFORMACIÓN DEL TICKET
		System.out.println("Ticket 1: " + ticket1);

		// 5. COMPROBAR ESTADO DE VUELO DESPUÉS DE VENTA
		System.out.println("\n-> COMPROBAR ESTADO DE VUELO");
		System.out.println(vuelo1);

		// Caso 4 -> Vender asiento PREMIUM
		System.out.println("\n-> VENDIENDO ASIENTO PREMIUM (que no existe)");
		Ticket ticket2 = vuelo1.comprarTicket("Fabi", Ticket.PREMIUM, 3);
		System.out.println(ticket2);

		System.out.println("\n-> VENDIENDO ASIENTO PREMIUM (con éxito)");
		Ticket ticket3 = vuelo1.comprarTicket("Fabi", Ticket.PREMIUM, 1);
		System.out.println(ticket3);

		// Caso 2 -> Vender asiento que ya está comprado
		System.out.println("\n-> VENDIENDO UN TICKET QUE YA FUE COMPRADO");
		Ticket ticket4 = vuelo1.comprarTicket("Fernando", Ticket.ECONOMICO, 3);
		System.out.println(ticket4);


		// 2. PRUEBA DE IMPRESIÓN DE ESTADO DEL VUELO (con todos los tickets que han sido reservados)
		System.out.println("\n-> COMPROBANDO ESTADO DE VUELO");
		System.out.println(vuelo1);

	}
}


/*

PRUEBAS EN MAIN:
1.  Imprimir la información del vuelo nuevo
		Dado que tengo un origen, destino, etc...
		Cuando cree un vuelo nuevo -> Entonces podré imprimir la información del vuelo

2.  Comprar un ticket
		Dado un vuelo existente:
		Cuando compre un vuelo -> Entonces debe crear un ticket y el vuelo debe disminuir un asiento disponible

3.  Comprar un ticket duplicado/reservado
		Dado que tengo un vuelo existente y un ticket con asiento 5:
		Cuando compre un ticket con asiento 5 -> Entonces no se debe vender y la información del vuelo no cambia

4.  Comprar un ticket con vuelo lleno
		Dado un vuelo existente y todos los asientos ocupados:
		Cuando compre un ticket nuevo -> Entonces no se debe vender y la información del vuelo no cambia

5.  Cancelar un ticket
		Dado que tengo un ticket para un vuelo x:
		Cuando cancele el ticket -> Entonces cambia la disponibilidad del asiento y la información del vuelo cambia







TODO (Practicar)

- Análisis
	No pensar en la unidad sino en el conjunto completo de algo
	Top -> Down (técnicas de análisis de programación)

- Automatización de pruebas.
	Estado previo -> acción -> resultado/consecuencia

- Nivel de especificidad en el código
- Cumplimiento de pequeños objetivos


TODO (PREGUNTAS)

- Si es que un objeto no tiene comportamientos vale la pena crearlo?
- Instancia: crear un objeto único con dirección de memoria única



*/