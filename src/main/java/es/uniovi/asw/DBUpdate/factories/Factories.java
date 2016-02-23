package es.uniovi.asw.DBUpdate.factories;

import es.uniovi.asw.DBUpdate.bussines.ServiceFactory;
import es.uniovi.asw.DBUpdate.bussines.SimpleserviceFactory;
import es.uniovi.asw.DBUpdate.persistence.PersistenceFactory;
import es.uniovi.asw.DBUpdate.persistence.impl.SimplePersistenceFactory;

/**
 * Factoria para poder usar la persistencia y los servicios
 * 
 * @author dario
 *
 */
public class Factories {
	
	public static PersistenceFactory persistence = new SimplePersistenceFactory();
	public static ServiceFactory service = new SimpleserviceFactory();

	
}
