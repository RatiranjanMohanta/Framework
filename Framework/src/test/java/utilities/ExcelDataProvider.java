package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src=new File("C:\\Workspace\\20APRIL\\Framework\\TestData\\TestData.xlsx");
		//File src=new File("./TestData/TestData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unable to read excel"+e.getMessage());
		}
	}
		public String getStringData(String SheetName,int row,int column) {
			return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
			
		}
		public double getNumericData(String SheetName,int row,int column) {
			return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
		}
	}


