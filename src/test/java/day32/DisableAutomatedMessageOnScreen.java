package day32;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMessageOnScreen {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		//3)remove "Chrome is being controlled by automated test software"
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});		
		
		
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
