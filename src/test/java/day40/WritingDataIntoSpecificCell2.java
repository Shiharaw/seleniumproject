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

public class WritingDataIntoSpecificCell2 {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\File2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("DynamicData");
		
		XSSFRow rowNum= sheet1.createRow(7);
		XSSFCell cellNum = rowNum.createCell(5);
		
		cellNum.setCellValue("Shihara");

		workbook.write(file);		//Attached workbook to the file
		workbook.close();
		file.close();
		System.out.println("File is created");




	}

}
