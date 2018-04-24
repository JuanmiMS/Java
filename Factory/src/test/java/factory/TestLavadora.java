package factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLavadora {

	@Test
	public void test_carga_frontal() {
		
		Lavadora lavadora = LavadoraFactory.creaFrontal();

		assertEquals("frontal", lavadora.tipoCarga);
		assertTrue(lavadora.tieneMandos);
		assertTrue(lavadora.tieneTambor);
	}

	@Test
	public void test_carga_superior() {
		
		Lavadora lavadora = LavadoraFactory.creaSuperior();

		
		assertEquals("superior", lavadora.tipoCarga);
		assertTrue(lavadora.tieneMandos);
		assertTrue(lavadora.tieneTambor);
	}

}
