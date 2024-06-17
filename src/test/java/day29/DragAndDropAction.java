package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

public class DragAndDropAction {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement rome= driver.findElement(By.id("box6"));
		WebElement Italy= driver.findElement(By.id("box106"));
		WebElement washington= driver.findElement(By.id("box3"));
		WebElement unitedStates= driver.findElement(By.id("box103"));
		
		
		//Drag and Drop
		act.dragAndDrop(rome, Italy).perform();
		act.dragAndDrop(washington, unitedStates).perform();

	}

}
