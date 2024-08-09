package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.dockerjava.api.command.CreateConfigCmd;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class WritingDataIntoSpecificCell1 {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\File1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("DynamicData");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter row number:");
		int rowNum= sc.nextInt();
		
		System.out.println("Enter cell number:");
		int cellNum= sc.nextInt();
		
		System.out.println("Enter data:");
		sheet1.createRow(rowNum).createCell(cellNum).setCellValue(sc.next());

		workbook.write(file);		//Attached workbook to the file
		workbook.close();
		file.close();
		System.out.println("File is created");




	}

}
