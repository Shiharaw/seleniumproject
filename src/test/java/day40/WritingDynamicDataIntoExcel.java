package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\Dynamic.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of rows:");
		int numofRows= sc.nextInt();
		
		System.out.println("Enter number of cells:");
		int numofCells= sc.nextInt();
		
		System.out.println("Enter data:");
		for(int r=0;r<=numofRows;r++) {
			XSSFRow currentRow = sheet1.createRow(r);
			
			for(int c=0;c<numofCells;c++) {
				XSSFCell cell = currentRow.createCell(c);
				cell.setCellValue(sc.next());
				
			}
		}

		workbook.write(file);		//Attached workbook to the file
		workbook.close();
		file.close();
		System.out.println("File is created");




	}

}
