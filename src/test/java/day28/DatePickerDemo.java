package day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);		//Switch to the frame
		
		//Approach1 -Direct approach
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/19/2022");		//mm/dd/yyyy
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='datepicker']")).clear();
		
		
		//Approach2
		String year ="2025";
		String month ="July";
		String date = "14";
		
		//Open he date picker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//Select month and year
		while(true) {
			
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year)) {
				
				break;
				
			}
			
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

}
