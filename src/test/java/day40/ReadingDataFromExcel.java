package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



//Excel File--->Workbook--->Sheets--->Rows----Cells

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		//open the file in the reading mode
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Books.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		//GetSheet method need to provide sheet name
		 XSSFSheet sheet1= workbook.getSheet("Sheet1");
		
		//GetSheetAt method need to provide sheet number
		//workbook.getSheetAt(0);
		 
		int numRows = sheet1.getLastRowNum();
		int numCells = sheet1.getRow(0).getLastCellNum();
		
		System.out.println("Number of rows: "+numRows);			//5 --> Rows are start to count from 0
		System.out.println("Number of cells: "+numCells);		//4 --> Cells are start to count from 1
		
		for(int r=0;r<=numRows;r++) {
			
			XSSFRow currentRow = sheet1.getRow(r);
			
			for(int c=0;c<numCells;c++) {
				
				XSSFCell currentCell= currentRow.getCell(c);
				currentCell.toString();		//Method get the data from the cell-- toString method convert every data to string
				System.out.print(currentCell.toString()+"\t"); 
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
		

	}

}
