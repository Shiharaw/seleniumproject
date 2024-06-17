package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();		//This works with code 01
		//ChromeDriver driver = new ChromeDriver();		//This works with code 02
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement nameBox = driver.findElement(By.id("name"));
		WebElement maleRBtn = driver.findElement(By.id("male"));
		
		JavascriptExecutor js =(JavascriptExecutor)driver;		//code 01 with casting
		
		//Alternative for sendKeys() method
		js.executeScript("arguments[0].setAttribute('value','John')", nameBox);
		//Alternative for click() method
		js.executeScript("arguments[0].click()", maleRBtn);		
		
		//JavascriptExecutor js =driver;						//code 02 without casting
		
	}

}
