package day22;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommandsDemo {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		 driver.manage().window().maximize();
		 
		 //isDisplayed() isEnabled()
		 //Method 1
		 //Check the Logo Element
		 WebElement logo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 logo.isDisplayed();
		 System.out.println("Display status of Logo: "+logo.isDisplayed());
		 
		 //Method 2
		 Boolean Status= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		 System.out.println(Status);
		 
		 //Check the Search box is enable
		 WebElement SearchBox = driver.findElement(By.xpath("//form[@id='small-search-box-form']"));
		 SearchBox.isDisplayed();
		 SearchBox.isEnabled();
		 System.out.println("Display Status: "+SearchBox.isDisplayed());
		 System.out.println("Enable Status: "+SearchBox.isEnabled());
		 
		 //isSelected()
		 WebElement MaleRd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		 WebElement FemaleRd = driver.findElement(By.xpath("//input[@id='gender-female']"));
		 
		 //Before Selection
		 System.out.println("Before Selection...........");
		 System.out.println(MaleRd.isSelected());
		 System.out.println(FemaleRd.isSelected());
		 
		 //After select the Male Radio Button
		 MaleRd.click();
		 System.out.println("After Selected the Male Radio Button...........");
		 System.out.println(MaleRd.isSelected());
		 System.out.println(FemaleRd.isSelected());
		 
		 //After select the Female Radio Button
		 FemaleRd.click();
		 System.out.println("After Selected the Female Radio Button...........");
		 System.out.println(MaleRd.isSelected());
		 System.out.println(FemaleRd.isSelected());
		 
		 
		 

	}

}
