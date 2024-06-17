package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsDemo1 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		//Open App
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		
		//SearchBox
		driver.findElement(By.id("search")).sendKeys("t-shirt");
		
		//Click Search
		driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
		
		//LinkText
		driver.findElement(By.linkText("t-shirt for men")).click();
		
		//Partial LinkText
		driver.findElement(By.partialLinkText("Radiant ")).click();
		

		

	}

}
