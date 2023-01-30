package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLS {
	@DataProvider(name="Data")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String sheetName=m.getName();
		String[][] testdata = null;
		File f=new File(System.getProperty("C:\\Users\\HP\\eclipse-workspace\\Guru99\\src\\test\\java"
				+ "\\utilities\\ReadXLS.java"));
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheetname=wb.getSheet(sheetName);
		
		int totalRows=sheetname.getLastRowNum();
		Row rowcells=sheetname.getRow(0);
		int totalcol=rowcells.getLastCellNum();
		
		DataFormatter format=new DataFormatter();
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalcol;j++) {
				testdata[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
			}
		}
		return testdata;
	}

}
