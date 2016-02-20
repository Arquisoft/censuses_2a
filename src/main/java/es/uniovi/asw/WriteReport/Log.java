package es.uniovi.asw.WriteReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Log implements WriteReport {

	private String fileName= "./src/main/resources/log.txt";
	private File fichero=null;
	private BufferedWriter bw=null;

	@Override
	public void createLog() {
		fichero= new File(fileName);
		try {
			bw = new BufferedWriter(new FileWriter(fichero,true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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

	@Override
	public void closeLog() {

		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
