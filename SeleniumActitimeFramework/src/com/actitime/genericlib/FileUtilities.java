package com.actitime.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtilities {
	String excelPath = "./testdata/testData.xlsx";
	String propertyFilePath = "./testdata/CommonData.properties";
	
	/**
	 * @return Properties
	 * @throws Throwable
	 * its return Object of the Properties File & load all the Keys
	 */
	public Properties getPropertiesFileObj() throws Throwable{
		FileInputStream fis = new FileInputStream(propertyFilePath);
        Properties pObj = new Properties();
        pObj.load(fis);
        return pObj;
	}	
/** 
 * @param sheetName , rowNum colNum
 * @return String
 * @throws Throwable
 * its used to read the data from ExcelFile based on user argumnet
 */
	public String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 * its used to write data back to excel based on user argumnet
	 */
public void setExcelData(String sheetName, int rowNum, int colNum, 
		                                 String data) throws Throwable{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		 Cell cel = row.createCell(colNum);
		 cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
		wb.close();
	}

}
