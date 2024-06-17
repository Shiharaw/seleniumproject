package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("mce_0_ifr");
		
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("I am the BEST QA Manager in the field");
		
		

	}

}
