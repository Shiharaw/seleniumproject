package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1) Find total number of rows
		//Approch1
		int rows = driver.findElements(By.xpath("//table[@name =\"BookTable\"]//tr")).size();
		System.out.println("Tatol number of raws of the table - "+rows);
		
		//Approch2 - Only have 1 table
		int rows2 = driver.findElements(By.tagName("tr")).size();
		System.out.println("Tatol number of raws of the table - "+rows2);
		
		//2) Find total number of columns
		int column = driver.findElements(By.xpath("//table[@name =\"BookTable\"]//th")).size();
		System.out.println("Tatol number of columns of the table - "+column);
		
		//3) Read specific raw and column data
		String bookname4 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("Name of the book 4 - "+bookname4);
				
		//4) Read the data from all rows and columns
		for(int r=2;r<=rows;r++){
			
			for(int c=1;c<=column;c++) {
				
				//Dynamic xpath - r and c are changing
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				//Give tab space after value
				System.out.print(value+"\t");				
			}
			//To print in table format
			System.out.println();
		}
		
		//5) Print Book names whose author is Amit
		for(int r=2;r<=rows;r++) {
			
			String author =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			if(author.equals("Amit")) {
				
				String bookname= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println(bookname);
		
			}
			
		}
		
		//6) Find the total price of all books
		int totalprice =0;
		for(int r=2;r<=rows;r++) {
			
			String price =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();	
			//System.out.println(price);
						
			totalprice =totalprice + Integer.parseInt(price);
		}
		System.out.println("Total Price of Books: "+totalprice);

	}

}
