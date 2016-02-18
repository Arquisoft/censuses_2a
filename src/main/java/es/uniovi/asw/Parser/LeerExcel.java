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


import es.uniovi.asw.DBUpdate.model.Usuario;





public class LeerExcel {

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
		            		
		            		user.setEmail(cell.getStringCellValue());
		            		cont++;
		            		
		            	}else{
		            		
		            		user.setNIF(cell.getStringCellValue());
		            		
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
	        
	        System.out.println("");
		  }
		  
		  return data;
	  
	}
}