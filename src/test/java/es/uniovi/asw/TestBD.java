package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.DBUpdate.factories.Factories;
import es.uniovi.asw.DBUpdate.model.Usuario;


public class TestBD {

	@Test
	public void testADD() {
		
		Usuario user = new Usuario("Dario","UO230766@uniovi.es","53548918L",25);
		Factories.persistence.createUsuarioDao().reiniciaID();
		assertTrue(Factories.persistence.createUsuarioDao().save(user));
		Usuario prubaUser=Factories.persistence.createUsuarioDao().findByNIF(user.getNIF());
		System.out.println(prubaUser.toString());
		//assertFalse(Factories.persistence.createUsuarioDao().save(user));
		
	}

}
