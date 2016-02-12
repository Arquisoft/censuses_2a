package es.uniovi.asw.DBUpdate.persistence;

import java.util.List;

import es.uniovi.asw.DBUpdate.model.Usuario;



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
	
	boolean update(Usuario a) ;
	
	boolean delete(String login) ;
	
	Usuario findByNIF(String login) ;
	
	boolean deleteUsuarios();
	
	void reiniciaID();

}