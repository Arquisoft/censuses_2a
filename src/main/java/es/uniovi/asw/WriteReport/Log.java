package es.uniovi.asw.WriteReport;

import java.io.File;

public class Log implements WriteReport {

	private String fileName= "./src/main/resources/log.txt";
	private File fichero=null;
	@Override
	public Log log() {
		fichero= new File(fileName);
		return this;
	
	}
	@Override
	public void createLog() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateLog(String nuevo) {
		// TODO Auto-generated method stub
		
	}

	
	
}
