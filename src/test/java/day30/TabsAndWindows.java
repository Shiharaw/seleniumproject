package day30;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/");
		
		//Open next URL in another tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.orangehrm.com/en/");
		
		//Open next URL in another window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.nopcommerce.com/");

	}

}
