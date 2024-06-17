package day31;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPageDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scroll down by pixel number
		//js.executeScript("window.scrollBy(0,1000)", "");
		//System.out.println(js.executeScript("return window.pageYOffset", ""));
		
		//Scroll page till element is visible
		WebElement comEle= driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		//js.executeScript("arguments[0].scrollIntoView();",comEle);
		//System.out.println(js.executeScript("return window.pageYOffset",""));
		
		//Scroll page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset", ""));
		
		Thread.sleep(5000);
		//Scroll page to the initial point of the page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset", ""));

	}

}
