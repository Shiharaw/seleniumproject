package day31;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoominZoomout {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		Thread.sleep(1000);
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");
		

	}

}
