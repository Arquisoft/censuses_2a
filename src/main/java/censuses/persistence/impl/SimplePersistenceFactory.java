package censuses.persistence.impl;

import censuses.persistence.PersistenceFactory;
import censuses.persistence.UsuarioDao;

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
