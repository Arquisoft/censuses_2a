package es.uniovi.asw.WriteReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Clase para crear el log
 * @author dario
 *
 */
public class Log implements WriteReport {

	private String fileName= "./src/main/resources/log.txt";
	private File fichero=null;
	private BufferedWriter bw=null;

	/**
	 * Metodo para crear el fichero log en caso de que no exista o abrirlo
	 */
	@Override
	public void createLog() {
		fichero= new File(fileName);
		try {
			bw = new BufferedWriter(new FileWriter(fichero,true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para actualizar e fichero de log
	 * @param fichero nombre del fichero en el que se produjo un error
	 * @param causa causa por a cual se produjo el error
	 */
	@Override
	public void updateLog(String fichero,String causa) {

		 Calendar fecha = GregorianCalendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy hh:mm:ss");
		try {
			bw.append("\nFecha: "+sdf.format(fecha.getTime()).toString()+" Causa: "+causa+" al leer fichero "+fichero);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo para cerrar el fichero
	 */
	@Override
	public void closeLog() {

		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
