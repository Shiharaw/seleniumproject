package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommandsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='nopCommerce']")).click();
		Thread.sleep(5000);
		driver.close();		//Close current browser window only
		
		
		//driver.get("https://demo.nopcommerce.com/");
		//driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[normalize-space()='nopCommerce']")).click();
		//Thread.sleep(5000);
		//driver.quit(); 		//Close all browser windows

	}

}
