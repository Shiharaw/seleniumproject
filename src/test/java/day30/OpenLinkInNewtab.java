package day30;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;
import com.sun.tools.javac.util.List;

public class OpenLinkInNewtab {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement regLink= driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions act = new Actions(driver);
		
		//CTRL+Registration link
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		//Switch to Registration page
		List<String> windIds = new ArrayList(driver.getWindowHandles());
		
		//Registration page
		driver.switchTo().window(windIds.get(1));		//Switch to Registration page
		driver.findElement(By.name("FirstName")).sendKeys("Shihara");
		
		//Home Page
		driver.switchTo().window(windIds.get(0));
		driver.findElement(By.name("q")).sendKeys("Books");
		


	}

}
