package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Test;

import censuses.factories.Factories;
import censuses.model.Usuario;

public class TestBD {

	@Test
	public void testADD() {
		
		Usuario user = new Usuario("Dario","UO230766@uniovi.es","53548918L","dario",25);
		
		assertTrue(Factories.persistence.createUsuarioDao().save(user));
		
	}

}
