package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Open App
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Find element by CSS with Tag and ID
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");
		
		//Find element by CSS with Tag and Class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("HP");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("HP");
		
		//Find element by CSS with Tag and Attribute
		//driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Lenovo");
		//driver.findElement(By.cssSelector("[type='text']")).sendKeys("Lenovo");
		//driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Dell");
		//driver.findElement(By.cssSelector("[name='q']")).sendKeys("Dell");
		
		//Find element by CSS with Tag Class and Attribute
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("HP");
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("HP");

	}

}
