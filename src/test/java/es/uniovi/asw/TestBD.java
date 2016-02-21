package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.DBUpdate.factories.Factories;
import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;
import es.uniovi.asw.WriteReport.Log;


public class TestBD {

	/*
	@BeforeClass	
	public static void reiniciarBD(){
		
		UsuarioDao dao= Factories.persistence.createUsuarioDao();
		dao.deleteUsuarios();
		dao.reiniciaID();
		
	}*/
	
	private static Usuario user ;
	private static Usuario user1 ;
	private static Usuario user2 ;
	private static Usuario user3 ;
	
	@BeforeClass	
	public static void crearUsuarios(){
		
		user = new Usuario("Dario Suarez","UO230766@uniovi.es","71778298J",25);
		try{
		user1 = new Usuario("Victor","correo1@mail.es","53548918L",12);
		}catch(IllegalArgumentException e){
			
			Log log= Factories.service.createLog();
			
			log.createLog();
			log.updateLog("testDB", e.getMessage().toString());
			log.closeLog();
			
		}
		user2 = new Usuario("Pepe","correo2@gmail.com","83656825Y",30);
		
		try{
		user3 = new Usuario("Juan","correo3","75603564m",02);
	
		}catch(IllegalArgumentException e){
			
			Log log= Factories.service.createLog();
			
			log.createLog();
			log.updateLog("testDB", e.getMessage().toString());
			log.closeLog();
			
		}
	}
	
	@Test
	public void testFind() {
		
		assertNotNull(Factories.persistence.createUsuarioDao().findByNIF(user.getNIF()));
		assertNotNull(Factories.persistence.createUsuarioDao().findByNIF(user2.getNIF()));

	}
	
	@Test
	public void testADD() {
		
		
		assertTrue(Factories.persistence.createUsuarioDao().save(user));
		//assertTrue(Factories.persistence.createUsuarioDao().save(user3));
		assertTrue(Factories.persistence.createUsuarioDao().save(user2));
		
		System.out.println(user.toString());
		
		assertFalse(Factories.persistence.createUsuarioDao().save(user2));
		assertFalse(Factories.persistence.createUsuarioDao().save(user));
		//assertFalse(Factories.persistence.createUsuarioDao().save(user3));
		
	}
	
	@Test
	public void testRemove(){
		
		UsuarioDao dao=Factories.persistence.createUsuarioDao();
		
		assertTrue(dao.delete(user.getNIF()));
		assertEquals(1,dao.getUsuarios().size());
		assertTrue(dao.delete(user2.getNIF()));
		assertEquals(0,dao.getUsuarios().size());
		//assertTrue(dao.delete(user3.getNIF()));
		//assertEquals(0,dao.getUsuarios().size());
		
	}

}
