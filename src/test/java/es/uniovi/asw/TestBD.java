package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.DBUpdate.factories.Factories;
import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;


public class TestBD {

	/*
	@BeforeClass	
	public static void reiniciarBD(){
		
		UsuarioDao dao= Factories.persistence.createUsuarioDao();
		dao.deleteUsuarios();
		dao.reiniciaID();
		
	}*/
	
	private Usuario user = new Usuario("Dario Suarez","UO230766@uniovi.es","53548918L",25);
	private Usuario user1 = new Usuario("Victor","correo1","69853214T",12);
	private Usuario user2 = new Usuario("Pepe","correo2","87485963J",30);
	private Usuario user3 = new Usuario("Juan","correo3","71503695A",02);
	
	@Test
	public void testADD() {
		
		
		assertTrue(Factories.persistence.createUsuarioDao().save(user));
		assertTrue(Factories.persistence.createUsuarioDao().save(user1));
		assertTrue(Factories.persistence.createUsuarioDao().save(user3));
		assertTrue(Factories.persistence.createUsuarioDao().save(user2));
		
		System.out.println(user.toString());
		
		assertFalse(Factories.persistence.createUsuarioDao().save(user2));
		assertFalse(Factories.persistence.createUsuarioDao().save(user1));
		assertFalse(Factories.persistence.createUsuarioDao().save(user));
		assertFalse(Factories.persistence.createUsuarioDao().save(user3));
		
	}
	
	@Test
	public void testRemove(){
		
		UsuarioDao dao=Factories.persistence.createUsuarioDao();
		
		assertTrue(dao.delete(user1.getNIF()));
		assertEquals(3,dao.getUsuarios().size());
		assertTrue(dao.delete(user.getNIF()));
		assertEquals(2,dao.getUsuarios().size());
		assertTrue(dao.delete(user2.getNIF()));
		assertEquals(1,dao.getUsuarios().size());
		assertTrue(dao.delete(user3.getNIF()));
		assertEquals(0,dao.getUsuarios().size());
		
	}

}
