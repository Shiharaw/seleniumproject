package day32;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);	//Accept SSL certificates
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		String title= driver.getTitle();
		System.out.println("Title of the page is "+title);
		
		

	}

}
