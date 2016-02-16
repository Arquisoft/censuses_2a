package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.DBUpdate.factories.Factories;
import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;


public class TestBD {

	
	@BeforeClass	
	public static void reiniciarBD(){
		
		UsuarioDao dao= Factories.persistence.createUsuarioDao();
		dao.deleteUsuarios();
		dao.reiniciaID();
		
	}
	
	@Test
	public void testADD() {
		
		Usuario user = new Usuario("Dario","UO230766@uniovi.es","53548918L",25);
		assertTrue(Factories.persistence.createUsuarioDao().save(user));
		Usuario prubaUser=Factories.persistence.createUsuarioDao().findByNIF(user.getNIF());
		//System.out.println(prubaUser.toString());
		assertFalse(Factories.persistence.createUsuarioDao().save(user));
		
	}

}
