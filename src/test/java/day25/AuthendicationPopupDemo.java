package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthendicationPopupDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//Declare Explicit wait
		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Basic url - https://the-internet.herokuapp.com/basic_auth
		//url with username/password injection - https://admin:adin@the-internet.herokuapp.com/basic_auth
		
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		String actual_text =driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
		String expected_text ="Congratulations! You must have the proper credentials.";
		
		if(actual_text.equals(expected_text)) {
			
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
			
		}
		

	}

}
