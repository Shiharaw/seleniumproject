package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button= driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
		
		//right click on button
		Actions act = new Actions(driver);
		
		//building/creation an action and storing into a variable
		Action myAction= act.contextClick(button).build();
		//performing/completing an action
		myAction.perform();
		

	}

}
