package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownWithoutSelectTagDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://codepen.io/RobotsPlay/pres/pyNLdL");
		driver.manage().window().maximize();
		
		//Click on the drop down
		driver.findElement(By.xpath("//div[@class='dropdown-list']")).click();
		//List<WebElement> options = driver.findElements(By.xpath("//ul/li/a/div[@class='form-check']"));
		
		//Find total number of options
		/*System.out.println("Total number of options: "+options.size());
		
		//Print all the options from drop down
		for(int i=0;i<options.size();i++) {
			
			System.out.println(options.get(i).getText());
		}
		
		//Select 2nd option from the drop down
		
*/
	}

}
