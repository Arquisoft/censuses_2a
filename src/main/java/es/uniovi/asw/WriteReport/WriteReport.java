package es.uniovi.asw.WriteReport;

public interface WriteReport {
	
	public void createLog();
	
	public void updateLog(String error,String nuevo);
	
	public void closeLog();
	
}
