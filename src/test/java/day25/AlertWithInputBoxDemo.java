package day25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertWithInputBoxDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//Declare Explicit wait
		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//3) alert with input box along with OK and cancel/Use explicit wait*****************
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		//Use of Explicit wait
		Alert alertwindow = mywait.until(ExpectedConditions.alertIsPresent());
				
		//Print the alert text
		System.out.println(alertwindow.getText());
		alertwindow.sendKeys("Senu");
				
		//Click OK button of the alert
		alertwindow.accept();
				
		//Validation
		String actula_text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String expected_text = "You entered: Senu";
				
		if(actula_text.equals(expected_text)) {
			
			System.out.println("Test Passed");
		} 
		else{
			
			System.out.println("Test Failed");
		}
				
		//Click Cancel button of the alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		alertwindow = mywait.until(ExpectedConditions.alertIsPresent());
		alertwindow.dismiss();
				
		//Validation
		actula_text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		expected_text = "You entered: null";
				
		if(actula_text.equals(expected_text)) {
					
			System.out.println("Test Passed");
		} 
		else{
					
			System.out.println("Test Failed");
		}


	}

}
