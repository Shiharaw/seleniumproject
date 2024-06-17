package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFramesDemo {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();


		//Without switching the relevant frame try to access the element
		/*
		String iframedemo1 = driver.findElement(By.xpath("/html/body/section/div/h5")).getText();
		System.out.println(iframedemo1);
		
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
		WebElement nestedframe= driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		String nestediframe = driver.findElement(By.xpath("//h5[contains(text(),'Nested iFrames')]")).getText();
		System.out.println(nestediframe);
		*/
		
		
		//After switching the relevant frame try to access the element
		//Access frame by Name or ID
		driver.switchTo().frame("singleframe");
		String iframedemo = driver.findElement(By.xpath("/html/body/section/div/h5")).getText();
		System.out.println(iframedemo);
		
		//switch back to the main page
		driver.switchTo().defaultContent();
		
		//Access frame by xpath
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
		WebElement nestedframe= driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(nestedframe);
		String nestediframe = driver.findElement(By.xpath("//h5[contains(text(),'Nested iFrames')]")).getText();
		System.out.println(nestediframe);
		

		
		
		

	}

}
