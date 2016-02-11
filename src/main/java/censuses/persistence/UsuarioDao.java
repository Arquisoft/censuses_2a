package censuses.persistence;

import java.util.List;

import censuses.model.Usuario;


/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * 
 * En esta versi��n aparecen los otros m��todos b��sicos de un servicio 
 * de persistencia
 * 
 * @author alb
 *
 */
public interface UsuarioDao {

	List<Usuario> getUsuarios();
	
	boolean save(Usuario a) ;
	
	void update(Usuario a) ;
	
	void delete(String login) ;
	
	Usuario findByLogin(String login) ;
	
	void deleteUsuarios();
	
	void reiniciaID();

}