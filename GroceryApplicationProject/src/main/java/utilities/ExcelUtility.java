package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility {
	
	public static FileInputStream  f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	
	
	public static String readStringData(int row, int col , String sheet) throws IOException
	{
		///Users/silpasureshbabu/eclipse-workspace/GroceryApplicationProject/src/test/resources/GroceryTestData.xlsx
		
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		
		return c.getStringCellValue();
		
	}
	

	public static double readIntegerData(int row, int col ,String sheet) throws IOException 
	{

		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		
		XSSFRow r = s.getRow(row);
		XSSFCell c = r.getCell(col);
		
		return c.getNumericCellValue();
		//int val =  (int) c.getNumericCellValue();
		//return  String valueOf(val);
		
	}

}
