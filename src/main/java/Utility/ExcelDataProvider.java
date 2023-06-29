package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataProvider {
	static int k=1;
	public static File excelFile = new File(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");
	static XSSFWorkbook workbook;
	static FileInputStream fis;
	
	@DataProvider(name="loginData")
	public static String[][] getData() throws IOException {
		String[][] data = null;
		try {
			
			fis= new FileInputStream(excelFile);
			workbook= new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			int trows=sheet.getLastRowNum();
			int tcols= sheet.getRow(0).getLastCellNum();
			data= new String[trows][tcols];
			for(int i=0; i<trows;i++) {
				for(int j=0; j<tcols;j++) {
					DataFormatter df= new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
				}
			}
			workbook.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;	
	}
public static void putData(String result, int col) throws IOException {
	
		try {
			fis= new FileInputStream(excelFile);
			workbook= new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			System.out.println(k);
			sheet.getRow(k).createCell(col).setCellValue(result);
			FileOutputStream outputStream = new FileOutputStream(excelFile);
			k++;
			workbook.write(outputStream);
			workbook.close();
			fis.close();
			outputStream.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
