package day32;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");		//Setting of headless mode of execution
		
		//After created the Chrome Options object that need be passed to the Chrome driver
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		String nopCom_title = driver.getTitle();
		
		if(nopCom_title.equals("nopCommerce demo store")) {
			
			System.out.println("Test passed");
		}else {
			
			System.out.println("Test failed");
		}
		driver.quit();
		

	}

}
