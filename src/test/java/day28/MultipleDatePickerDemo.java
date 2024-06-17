package day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleDatePickerDemo {

	//Method 1: Select month and year method
	static void selectYearAndMonth(WebDriver driver, String month, String year) {
		
		while(true) {
			
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year)) {
				
				break;
			}
			//Click next button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
	}
	
	
	//method 2: Select date
	static void selectDate(WebDriver driver, String date) {
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
		
		for(WebElement DT:allDates) {
			
			if(DT.getText().equals(date)) {
				
				DT.click();
				break;
			}
		}
		
	}
	
	//method 3: Select future date
	static void selectFutureDate(WebDriver driver, String month, String year, String date) {
		
		//Select month and year
		while(true) {
			
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year)) {
				
				break;
			}
			//Click next button
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//Select date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
		
		for(WebElement DT:allDates) {
			
			if(DT.getText().equals(date)) {
				
				DT.click();
				break;
			}
		}
	}
	
	//method 4: Select passed date
		static void selectPassedDate(WebDriver driver, String month, String year, String date) {
			
			//Select month and year method
			while(true) {
				
				String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				
				if(mon.equals(month) && yr.equals(year)) {
					
					break;
				}
				//Click previous button
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			
			//Select date
			List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
			
			for(WebElement DT:allDates) {
				
				if(DT.getText().equals(date)) {
					
					DT.click();
					break;
				}
			}
		}
		
		
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);		//Switch to the frame
		
		
		//Select Date1
		String year ="2025";
		String month ="July";
		String date = "14";
		
		//Open the date picker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//Select month and year
		selectYearAndMonth(driver, month, year);
		//Select date
		selectDate(driver, date);
		
		
		//Select Date2
		//Open the date picker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//Select month and year
		selectYearAndMonth(driver, "October", "2025");
		//Select date
		selectDate(driver, "20");
		
		
		//Select Future Date
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		selectFutureDate(driver, "February", "2026", "28");
		
		//Select Passed Date
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		selectPassedDate(driver, "January", "2007", "6");

	}

}
