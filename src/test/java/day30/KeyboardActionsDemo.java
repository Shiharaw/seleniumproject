package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsDemo {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("text1")).sendKeys("Welcome new QA Manager Shihara Wickramasinghe");
		
		Actions act = new Actions(driver);
		//CTRL+A	Select text
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		//CTRL+C	Copy text
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		//TAB	Shift to next box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//CTRL+V	Past text
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

	}

}
