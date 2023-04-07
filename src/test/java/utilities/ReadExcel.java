package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	//Method m
	@DataProvider(name="getdata")
	public String[][] getexceldata(Method m) throws InvalidFormatException, IOException {
		File f= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		String SheetName= m.getName();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(SheetName);
		
		int totalrows = s.getLastRowNum();
		Row rowcells = s.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		String testdata[][]= new String[totalrows][totalcols];
		DataFormatter df = new DataFormatter();
		for(int i=1; i<=totalrows; i++) {
			for(int j=0; j<totalcols; j++) {
				testdata[i-1][j]= df.formatCellValue(s.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}
		return testdata;
	}

}
