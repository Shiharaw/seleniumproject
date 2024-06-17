package day32;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunTestInIncognitoMode {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		String nopCom_title = driver.getTitle();
		
		if(nopCom_title.equals("nopCommerce demo store")) {
			
			System.out.println("Test passed");
		}else {
			
			System.out.println("Test failed");
		}

	}

}
