package es.uniovi.asw.WriteReport;

import es.uniovi.asw.DBUpdate.persistence.PersistenceFactory;
import es.uniovi.asw.DBUpdate.persistence.impl.SimplePersistenceFactory;

public interface Factories {

	public static ServiceFactory service = new SimpleserviceFactory();

	
}
