package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxesDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		driver.manage().window().maximize();
		
		//Select specific check box
		//driver.findElement(By.xpath("//input[@value='red']")).click();
		
		//Total number of check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total number of check boxex: "+checkboxes.size());
		
		//Select all check boxes
		//Method 1
		/*
		for(int i=0;i<checkboxes.size();i++) {
			
			//In the list collection, can use get method to select the items from the list one by one
			checkboxes.get(i).click();
		}*/
			
		//Method 2
		/*
		for(WebElement chkbox:checkboxes) {
			chkbox.click();
		}*/
		
		//Select last 2 check boxes
		//Total number of check boxes - number of check boxes to be selected = Starting number of the check box
		//6-2=4
		for(int i=4;i<checkboxes.size();i++) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(4000);
		
		//Un-select only selected check boxes
		for(int i=0;i<checkboxes.size();i++) {
			
			if(checkboxes.get(i).isSelected())
			checkboxes.get(i).click();
		}
		
		//Select all check boxes and Un-select all check boxes
		//Select all check boxes
		for(int i=0;i<checkboxes.size();i++) {
			
			checkboxes.get(i).click();
		}
		
		Thread.sleep(4000);
		//Un-select all check boxes
		for(int i=0;i<checkboxes.size();i++) {
			
			if(checkboxes.get(i).isSelected())
			checkboxes.get(i).click();
		}
		
		//Un-select only selected check boxes
		//Select last 3 check boxes
		for(int i=3;i<checkboxes.size();i++) {
			
			checkboxes.get(i).click();
		}
		
		Thread.sleep(4000);
		//Un-select only selected check boxes
		for(int i=0;i<checkboxes.size();i++) {
			
			if(checkboxes.get(i).isSelected())
			checkboxes.get(i).click();
		}
		
		//Select first 2 check boxes and Un-select only selected check boxes
		//Select first 2 check boxes
		for(int i=0;i<2;i++) {
			checkboxes.get(i).click();
		}
		Thread.sleep(4000);
		
		//Un-select only selected check boxes
		for(WebElement Chkbox: checkboxes) {
			
			if(Chkbox.isSelected()) {
				Chkbox.click();
			}
		}

	}

}
