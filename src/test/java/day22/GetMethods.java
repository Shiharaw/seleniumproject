package day22;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * get(url)
getTitle()
getCurrentURL()
getPageSource()
getWindowHandle()
getWindowHandles()
*/

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		//Get the title of the web page
		driver.getTitle();
		System.out.println("Title of the web page: "+driver.getTitle());
		
		//Get the current URL of the web page
		driver.getCurrentUrl();
		System.out.println("Current URL: "+driver.getCurrentUrl());
		
		//Get the web page ID
		driver.getWindowHandle();
		System.out.println("Current Web page ID: "+driver.getWindowHandle());
		
		////Get the web page IDs of 2 pages
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Thread.sleep(5000);
		Set<String> windowids =driver.getWindowHandles();
		for(String windowid:windowids) {
			System.out.println(windowid);
		}
		
		//Get the page source of the current web page
		String ps=driver.getPageSource();
		System.out.println("Current WEB Page Source...............");
		System.out.println(ps.contains("html"));
		System.out.println(ps);
		
		
		
				

	}

}
