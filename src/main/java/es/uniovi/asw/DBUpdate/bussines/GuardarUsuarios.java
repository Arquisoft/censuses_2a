package es.uniovi.asw.DBUpdate.bussines;

import java.util.List;

import es.uniovi.asw.DBUpdate.factories.Factories;
import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.DBUpdate.persistence.UsuarioDao;

/**
 * Clase Para llamar al encargado de guardar los usuarios en la base de datos
 * @author dario
 *
 */
public class GuardarUsuarios {
	
	private List<Usuario> usuarios;

	public GuardarUsuarios(List<Usuario> usuarios) {
		
		this.usuarios = usuarios;
		
	}
	
	public void guardar(){
		
		UsuarioDao dao= Factories.persistence.createUsuarioDao();
		
		for(Usuario user : usuarios){
			
			System.out.println(user.toString());
			dao.save(user);
			
		}
		
	}
	
}
