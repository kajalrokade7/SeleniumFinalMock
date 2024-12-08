package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtilityExcel 
{
	public static String Exceldata(String s, int row, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Documents\\Dws.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(s);
		String data =sheet.getRow(row).getCell(column).toString();
		return data;
	}
	public static String Exceldata2(String s, int row, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Documents\\Dws.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(s);
		String data =sheet.getRow(row).getCell(column).toString();
		
		return data;
	}
	public static String Excel2(String s, int row, int column) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Documents\\Dws.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(s);
		String s3 = sheet.getRow(row).getCell(column).toString();
		double d = Double.parseDouble(s3);
		int i = (int)d;
		String s1 = ""+i;
		return s1;
		
		
		
		
       
	}
	
		
}
