package day45;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import org.testng.Assert;



public class ParalleTest {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String br, String url) throws InterruptedException {
		
		switch (br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		//If the browser is invalid no need to execute rest of the code
		//Therefore we use "return" it will stop all and exit the code
		default: System.out.println("Invalid browser");	return; 
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 1)
	void testLogo() {
		
		boolean logoStatus = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logoStatus,true);

	}
	
	@Test(priority = 2)
	void testTitle() {
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		
	}
	
	@Test(priority = 3)
	void testURL() {
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	void tearDown() {
		
		driver.close();
	}

}
