package es.uniovi.asw.DBUpdate.persistence.impl;

import es.uniovi.asw.DBUpdate.persistence.PersistenceFactory;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;

/**
 * Implementaci??????n de la factoria que devuelve implementaci??????n de la capa
 * de persistencia con Jdbc 
 * 
 * @author Enrique
 *
 */
public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public UsuarioDao createUsuarioDao() {
		return new UsuarioJdbcDao();
	}


	

}
