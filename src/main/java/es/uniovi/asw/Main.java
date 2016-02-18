package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.DBUpdate.bussines.GuardarUsuarios;
import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.Parser.LeerExcel;

public class Main {

	public static void main(String[] args) {
		
		String nombreFichero=args[0];
		
		LeerExcel fichero = new LeerExcel();
		
		try {
			
			List<Usuario> listaUsuarios=fichero.leerFichero("./src/test/resources/"+nombreFichero);
			GuardarUsuarios g = new GuardarUsuarios(listaUsuarios);
			g.guardar();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
