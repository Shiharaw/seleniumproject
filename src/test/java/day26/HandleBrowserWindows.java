package day26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		//Capture id's of browser windows
		Set<String> windowIDs = driver.getWindowHandles(); 		//Store 2 window IDs
		
		//Approch1 -Using List collection/2 browser windows
		/*
		List<String> windowidList = new ArrayList(windowIDs);	//Convert Set to List
		System.out.println(windowidList);
		
		String parentWidowID = windowidList.get(0);
		String childWindowID = windowidList.get(1);
		
		//Switch to Child Window
		driver.switchTo().window(childWindowID);
		driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
		driver.findElement(By.linkText("Contact Sales")).click();
		
		//Switch to Parent Window
		driver.switchTo().window(parentWidowID);
		driver.findElement(By.name("username")).sendKeys("Shihara");
		Thread.sleep(10000);
		*/
		
		//Approch2
		for(String winds:windowIDs) {
			
			String title = driver.switchTo().window(winds).getTitle();
				
			if (title.equals("Human Resources Management Software | OrangeHRM")) {
				
				driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
				driver.findElement(By.linkText("Book a Free Demo")).click();
			}
			
		}
		
		//Closing specific browser windows based on choice
		//Example
		//1-x, 2-y, 3-z, 4-a,5-b
		/*
		for(String winds:windowIDs) {
			
			String title = driver.switchTo().window(winds).getTitle();
				
			if (title.equals("x")||title.equals("y")||title.equals("z")) {
				
				driver.close();
			}
			
		}
		*/
		
		//Close Child window
		for(String winds:windowIDs) {
			
			String title = driver.switchTo().window(winds).getTitle();
				
			if (title.equals("Book Your Free Demo | OrangeHRM")) {
				
				driver.close();
			}
			
		}

	}

}
