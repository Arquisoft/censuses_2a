package es.uniovi.asw.DBUpdate.factories;

import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;
import es.uniovi.asw.DBUpdate.persistence.impl.UsuarioJdbcDao;
import es.uniovi.asw.WriteReport.Log;

public class SimpleserviceFactory implements ServiceFactory {

	@Override
	public Log createLog() {
		return new Log();
	}
	
}
