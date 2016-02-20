package es.uniovi.asw.DBUpdate.factories;

import es.uniovi.asw.DBUpdate.persistence.PersistenceFactory;
import es.uniovi.asw.DBUpdate.persistence.impl.SimplePersistenceFactory;


public class Factories {
	
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
	public static ServiceFactory service = new SimpleserviceFactory();

	
}
