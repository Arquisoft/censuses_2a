package es.uniovi.asw.Parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import es.uniovi.asw.DBUpdate.model.Usuario;

public class GenerarCarta {
	
	private List<Usuario> listaUsuarios = null;
	
	public GenerarCarta(List<Usuario> listaUsuarios){
		this.listaUsuarios=listaUsuarios;
	}
	
	
	public void crearCarta() throws IOException{
			
		BufferedWriter bw;
		for(Usuario user : listaUsuarios){
			String ruta = "./src/main/resources/"+user.getLogin() + ".txt" ;
			 
			File carta = new File(ruta);
			bw = new BufferedWriter(new FileWriter(carta));
			bw.write("Usuario "+ user.getLogin() +"\nClave acesso " + user.getPassword());
			bw.close();
		}
		
	}
	
	

}
