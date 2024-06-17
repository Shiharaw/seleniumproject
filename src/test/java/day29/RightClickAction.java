package day29;

import java.awt.Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button= driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
		
		//right click on button
		Actions act = new Actions(driver);
		act.contextClick(button).perform();
		
		//click on Copy
		driver.findElement(By.xpath("//li[3]/span")).click();
		
		//close alert box
		driver.switchTo().alert().accept();
		
			

	}

}
