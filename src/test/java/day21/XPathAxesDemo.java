package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Open app
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Find element by XPath Axes
		
		//Self - select the current node
		String Self = driver.findElement(By.xpath("//div[contains(@class,'float-end')]/self::div")).getText();
		System.out.println(Self);
		String Self2 = driver.findElement(By.xpath("//div[contains(@class,'float-start')]/self::div")).getText();
		System.out.println("Self2"+Self2);
		
		//Parent - select the Parent of the current node
		String Parent = driver.findElement(By.xpath("//div[contains(@class,'float-end')]/parent::div")).getText();
		System.out.println("Parent"+Parent);
		
		//Child - select the Child of the current node
		String Child = driver.findElement(By.xpath("//div[contains(@class,'float-end')]/child::ul")).getText();
		System.out.println("Child"+Child);
		
		//Grand parent - select the Ancestor of the current node
		String Ancestor = driver.findElement(By.xpath("//div[contains(@class,'float-end')]/ancestor::nav")).getText();
		System.out.println("Ancestor"+Ancestor);
		
		//Grand children - select the Descendant of the current node
		String Descendant = driver.findElement(By.xpath("//div[contains(@class,'float-end')]/descendant::li[1]")).getText();
		System.out.println("Descendant"+Descendant);
		
		//Following Sibling- select the Following of the current node
		String Following = driver.findElement(By.xpath("//div[contains(@class,'float-start')]/following::div")).getText();
		System.out.println("Following"+Following);
		
		//Preceding Sibling- select the Preceding of the current node
		String Preceding = driver.findElement(By.xpath("//div[contains(@class,'float-end')]/preceding::div[2]")).getText();
		System.out.println("Preceding"+Preceding);
		

	}

}
