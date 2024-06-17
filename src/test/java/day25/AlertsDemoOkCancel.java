package day25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsDemoOkCancel {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//Declare Explicit wait
		WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		
		
		//2) alert with OK and cancel/Use explicit wait*****************
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		
		//Alert is not a web element and we cannot inspect the element
		//Use Explicit wait when work with alert window
		//Some times the alert window is take some time to load. therefore we use Explicit wait 
		//Alert is alert type element and we capture this as alert type element
		Alert alertwindow2 = mywait.until(ExpectedConditions.alertIsPresent());
		
		//Print the alert window text
		System.out.println(alertwindow2.getText());
		//Close alert window by using OK button
		alertwindow2.accept();
		
		//Close alert window by using Cancel button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(2000);
		alertwindow2 = mywait.until(ExpectedConditions.alertIsPresent());
		alertwindow2.dismiss();

	}

}
