package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Open App
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Find element by XPath using Text Function
		String productname1 = driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
		System.out.println(productname1);
		
		//Find element by XPath using normalize-space Function
		String productname2 = driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).getText();
		System.out.println(productname2);
		
		//Find element using Absolute XPath
		String productname3 = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText();
		System.out.println(productname3);

	}

}
