package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		Thread.sleep(3000);
		
		
		List<WebElement> list= driver.findElements(By.xpath("//ul[@class='G43f7e']//div[contains(@class,'wM6W7d')]//span"));
		
		//FInd Number of elements in the list
		System.out.println(list.size());
		
		//Print the list
		for(int i=0;i<list.size();i++) {
			
			System.out.println(list.get(i).getText());		//Get the Web element and capture the text
			
		}
		
		//For Loop for Select options from the list
		//Order is changing time to time then cannot use drop down value's Xpath to get the element
		for(int j=1;j<list.size();j++) {
			
			String optiontext = list.get(j).getText();
			
			if(optiontext.equals("selenium download")) {
				
				list.get(j).click();
				break;
			}
			
			
		}

	}

}
