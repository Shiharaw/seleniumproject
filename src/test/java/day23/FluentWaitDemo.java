package day23;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Fluent Wait Declaration
		FluentWait mywait =new FluentWait(driver);
		//Specify the timout of the wait
		mywait.withTimeout(Duration.ofSeconds(30));
		//Sepcify polling time - In that wait time period check the element is available in every 5 seconds
		mywait.pollingEvery(Duration.ofSeconds(5));
		//Specify what exceptions to ignore
		mywait.ignoring(NoSuchElementException.class);
		
		//Usage
		WebElement username = (WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.sendKeys("Admin");
		

		
		//driver.findElement(By.name("username")).sendKeys("Admin");
		//driver.findElement(By.name("password")).sendKeys("admin123");
		

	}

}
