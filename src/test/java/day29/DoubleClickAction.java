package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement dbButton = driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
		WebElement result =driver.findElement(By.id("demo"));
				
		Actions act = new Actions(driver);
		
		act.doubleClick(dbButton).perform();
		
		String res =result.getText();
		String resId =result.getAttribute("id");
		System.out.println("Printed value is: "+res+" and ID of the element is "+resId);


		
		

	}

}
