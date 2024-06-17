package day26;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		driver.findElement(By.xpath("//*[@id='Wikipedia1_wikipedia-search-form']/div/span[2]/span[2]/input")).click();
		
		List<WebElement> linkList= driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']/a"));
		
		System.out.println(linkList.size());
		
		for(int i=0;i<linkList.size();i++) {
			
			linkList.get(i).click();
			System.out.println(linkList.get(i).getText());
		}
		
		//Close All open browser windows
		Set<String> windowIDs = driver.getWindowHandles();
		
		for(String winds:windowIDs) {
			
			String title = driver.switchTo().window(winds).getTitle();
			System.out.println("Page Titles - "+title);
			if(
					title.equals("Selenium - Wikipedia")
					||title.equals("Selenium in biology - Wikipedia")
					||title.equals("Selenium (software) - Wikipedia")
					||title.equals("Selenium disulfide - Wikipedia")
					||title.equals("Selenium dioxide - Wikipedia")){
				
				driver.close();
			}
			
			
		}


	}

}
