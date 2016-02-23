package es.uniovi.asw.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import es.uniovi.asw.DBUpdate.factories.Factories;
import es.uniovi.asw.DBUpdate.model.Usuario;
import es.uniovi.asw.WriteReport.Log;

/**
 * Clase para leer el fichero excel
 * @author dario
 *
 */
public class LeerExcel {
	
	List<Usuario> data = new ArrayList<Usuario>();

	/**
	 * Metodo para leer el fichero execel
	 * @param fichero nombre del fichero que se quiere leer
	 * @return Listado de usuarios creados a partir del fichero
	 * @throws IOException
	 */
	public List<Usuario> leerFichero(String fichero) throws IOException{
		
		File myFile = new File(fichero+".xlsx"); 
		FileInputStream fis = new FileInputStream(myFile);
		List<Usuario> data = new ArrayList<Usuario>();
	
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
	 
		  Iterator<Row> rowIterator = mySheet.iterator();
		  
		  while (rowIterator.hasNext()) {
	        Row row = rowIterator.next();
	        
	        Iterator<Cell> cellIterator = row.cellIterator();
	        Usuario user= new Usuario();
	        int cont=0;

	        while (cellIterator.hasNext()) {
	            Cell cell = cellIterator.next();
	            
	            if(cell.getRow().getRowNum()>0){
	            	
	              switch (cell.getCellType()) {
		            case Cell.CELL_TYPE_STRING:
		            	
		            	if(cont==0){
		            		
		            		user.setNombre(cell.getStringCellValue());
		            		cont++;
		            		
		            	}else if(cont==1){
	            			
		            		cont++;

		            		try{
		            			
		            			user.setNIF(cell.getStringCellValue());

		            		}catch(IllegalArgumentException e){
		            			
		            			Log log= Factories.service.createLog();
		            			
		            			log.createLog();
		            			log.updateLog(myFile.getName(), e.getMessage().toString());
		            			log.closeLog();
		            			user.setLogin(null);

		            		}
		            		
		            	}else{
		            	
			            	try{	
			            		
			            		user.setEmail(cell.getStringCellValue());
			            		
	
		            		}catch(IllegalArgumentException e){
		            			
		            			Log log= Factories.service.createLog();
		            			
		            			log.createLog();
		            			log.updateLog(myFile.getName(), e.getMessage().toString());
		            			log.closeLog();
		            			user.setLogin(null);
	
		            		}
			            		
		            	}
		            	
		                break;
		                
		            case Cell.CELL_TYPE_NUMERIC:
		            	
		            	user.setCodColElectoral((int)cell.getNumericCellValue());
		                break;
		             default:
		            	 break;
		            }
	
	            }
		          
	        }
	        
	        if(user.getLogin()!=null){
	        	data.add(user);
	        }
	        
		  }
		  
		  return data;
	  

	}
}