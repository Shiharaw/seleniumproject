package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MousehoverAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/iframes");
		driver.manage().window().maximize();
		
		WebElement addRPA= driver.findElement(By.xpath("//span[normalize-space()='1. Add RPA to browser']"));
		WebElement uiAutomation= driver.findElement(By.xpath("//a[normalize-space()='UI Automation']"));
		
		Actions act = new Actions(driver);
		
		//Mouse hover action
		
		//build() ---->  create an action 
		//perform() ---->  complete an action 
		act.moveToElement(addRPA).moveToElement(uiAutomation).click().build().perform();
	}

}
