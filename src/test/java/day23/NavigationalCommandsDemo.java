package day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommandsDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().to("https://www.flipkart.com/");
		System.out.println(driver.getCurrentUrl());
		
		//Go back to amazon
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		//Go to flipkart
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		//Refresh the page
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());
		
		

	}

}
