package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File("./Testdata/ApplicationData.xlsx")));
		
		} catch (Exception e) {
			
			System.out.println("Not able to load excel file,please check error log" +e.getMessage());
		}
	}
	
	public String getStringData(String SheetaName,int row,int column)
	{
		return wb.getSheet(SheetaName).getRow(row).getCell(column).getStringCellValue();
		
	
	}
   public double getNumericDataDouble(String SheetaName,int row,int column)
   {
	   
	   return wb.getSheet(SheetaName).getRow(row).getCell(column).getNumericCellValue();
		
   }
   
   public int getNumericDataInt(String SheetaName,int row,int column)
   {
	   
	   return (int) wb.getSheet(SheetaName).getRow(row).getCell(column).getNumericCellValue();
		
   }
   public int getNumberOfRows(String SheetName)
   {
	
	   return wb.getSheet(SheetName).getPhysicalNumberOfRows();
	   
   }
   public int getNumberOfColumns(String SheetName,int row)
   {
	return wb.getSheet(SheetName).getRow(row).getPhysicalNumberOfCells();
	   
   }
}
