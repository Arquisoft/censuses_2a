package es.uniovi.asw.DBUpdate.bussines;

import es.uniovi.asw.WriteReport.Log;

public class SimpleserviceFactory implements ServiceFactory {

	@Override
	public Log createLog() {
		return new Log();
	}
	
}
