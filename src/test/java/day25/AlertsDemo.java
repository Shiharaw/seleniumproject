package day25;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//Declare Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//1) alert with OK***********************
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		//Work alert window without explicit wait
		Alert alertwindow = driver.switchTo().alert();
		alertwindow.getText();
		Thread.sleep(2000);
		System.out.println(alertwindow.getText());
		alertwindow.accept();
		
		
	}

}
