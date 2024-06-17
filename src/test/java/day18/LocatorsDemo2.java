package day18;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsDemo2 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		//Open App
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		
		//Finding number of Block-Promos on Home Page
		List<WebElement> blockpromos = driver.findElements(By.className("block-promo"));
		System.out.println("Number of Block-Promos: "+ blockpromos.size());
		
		//Find total number of images on Home Page
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total Number of Images: "+ images.size());
		
		//Find total number of Links on Home Page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links: "+ links.size());

		

	}

}
