package test;

import junit.framework.TestCase;
import org.junit.Test;

import armario.*;

public class AlmacenajeTest extends TestCase {

	@Test
	public void testUsarCamisetaYSeEnsucia() {
		// DADO
		Camiseta camiseta = new Camiseta();

		// CUANDO
		camiseta.usar();

		// ENTONCES
		assertEquals(true, camiseta.estaSucia());
	}

}