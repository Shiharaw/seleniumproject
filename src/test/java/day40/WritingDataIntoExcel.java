package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\Booksw.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("Data");
		XSSFRow row1 = sheet1.createRow(0);
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("Sure Name");
		row1.createCell(2).setCellValue("Employe ID");
		row1.createCell(3).setCellValue("Birth Day");
		
		XSSFRow row2 = sheet1.createRow(1);
		row2.createCell(0).setCellValue("John");
		row2.createCell(1).setCellValue("Key");
		row2.createCell(2).setCellValue(123456);
		row2.createCell(3).setCellValue("22-Jun-2000");
		
		XSSFRow row3 = sheet1.createRow(2);
		row3.createCell(0).setCellValue("Gimy");
		row3.createCell(1).setCellValue("Amber");
		row3.createCell(2).setCellValue(123457);
		row3.createCell(3).setCellValue("02-Apr-1990");
		
		XSSFRow row4 = sheet1.createRow(3);
		row4.createCell(0).setCellValue("Vally");
		row4.createCell(1).setCellValue("Berner");
		row4.createCell(2).setCellValue(123458);
		row4.createCell(3).setCellValue("31-Oct-1978");
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		System.out.println("File is created");




	}

}
