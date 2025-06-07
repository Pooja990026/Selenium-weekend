package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
/**
 * This method is used to read string data from the excel for the given sheetname and row and coloumn
 * @param sheename
 * @param rowIndex
 * @param colIndex
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String getStringDataFromExcel(String sheename,int rowIndex,int colIndex,int numdata, boolean data, int date) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resource/Testdata/Testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheename).getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
	}
	public boolean getBooleanDataFromExcel(String sheename,int rowIndex,int colIndex,int numdata, boolean data, int date) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resource/Testdata/Testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheename).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
}
	public double getnumberDataFromExcel(String sheename,int rowIndex,int colIndex,int numdata, boolean data, int date) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resource/Testdata/Testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheename).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
}
	public LocalDateTime getFromExcel(String sheename,int rowIndex,int colIndex,int numdata, boolean data, int date) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resource/Testdata/Testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheename).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}
}
