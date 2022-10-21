package exceldriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("E:\\Udemy_Files\\Data.xlsx");
		// FileInputStream Arg
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		System.out.println(sheets);
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// identify the testcase by scanning entire first row
				Iterator<Row> rows = sheet.rowIterator();
				Row row = rows.next();
				Iterator<Cell> ce = row.cellIterator();
				int k= 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Data1")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
			}
		}

	}

}
