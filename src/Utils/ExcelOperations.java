package Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	
	public static HashMap<String,String> userDetails = new HashMap<String,String>();
	
	public static List<String> readExcel(String fileName,String sheetName) throws IOException {
	
		File file = new File(System.getProperty("user.dir")+"\\src\\dataEngine\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook errorMsgWorkBook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		List<String> errorMsg = new ArrayList<String>();
		
		if(fileExtensionName.equals(".xlsx")){
			errorMsgWorkBook = new XSSFWorkbook(inputStream);
		  }else if(fileExtensionName.equals(".xls")){
		    	errorMsgWorkBook = new HSSFWorkbook(inputStream);
		  }
		
		Sheet sheet = errorMsgWorkBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    for (int i = 0; i < rowCount; i++) {
	        Row row = sheet.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	            errorMsg.add(row.getCell(j).getStringCellValue());
	        }
	    } 
		return errorMsg;
		
	}

	public static HashMap<String,String> readExcelForInputData(String fileName,String sheetName,int rowNumber) throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\dataEngine\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook errorMsgWorkBook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//HashMap<String,String> errorMsg = new HashMap<String,String>();
		
		if(fileExtensionName.equals(".xlsx")){
			errorMsgWorkBook = new XSSFWorkbook(inputStream);
		  }else if(fileExtensionName.equals(".xls")){
		    	errorMsgWorkBook = new HSSFWorkbook(inputStream);
		  }
		
		Sheet sheet = errorMsgWorkBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	   
	    	Row headers = sheet.getRow(0);
	        Row row = sheet.getRow(rowNumber);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            System.out.println(headers.getCell(j).getStringCellValue()+"||"+row.getCell(j).getStringCellValue());
	            userDetails.put(headers.getCell(j).getStringCellValue(),row.getCell(j).getStringCellValue());
	        }
	   
			return userDetails;
			
		}

	public static int getNumberOfRowsOfExcel(String fileName,String sheetName) throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\src\\dataEngine\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook errorMsgWorkBook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		HashMap<String,String> errorMsg = new HashMap<String,String>();
		
		if(fileExtensionName.equals(".xlsx")){
			errorMsgWorkBook = new XSSFWorkbook(inputStream);
		  }else if(fileExtensionName.equals(".xls")){
		    	errorMsgWorkBook = new HSSFWorkbook(inputStream);
		  }
		
		Sheet sheet = errorMsgWorkBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rowCount;
		
	}
	
	
	
}
