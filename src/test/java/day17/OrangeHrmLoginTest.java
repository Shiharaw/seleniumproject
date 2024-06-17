package day17;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmLoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Launch browser
		//To Launch Browser need below step

		//Create object of ChromeDriver to use the methods in the ChromeDriver
		//This is should not create in ChromeDriver class
		//ChromeDriver driver = new ChromeDriver();
				
		//This should create in WebDriver Interface
		//It will help to work with any BrowserDriver
		WebDriver driver = new ChromeDriver();
						
		//2) open url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
				
		//TO maximize the web page
		driver.manage().window().maximize();
				
		//3) Provide username  - Admin
		//Write in 2 methods
		//WebElement textUserame = driver.findElement(By.name("username"));
		//textUserame.sendKeys("Admin");
		//Write in single method
		driver.findElement(By.name("username")).sendKeys("Admin");
				
		//4) Provide password  - admin123
		driver.findElement(By.name("password")).sendKeys("admin123");
				
		//5) Click on Login button 
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
				
		//6) Verify the title of dashboard page
		String Act_title = driver.getTitle();
		String Exp_title = "OrangeHRM";
				
		if(Act_title.equals(Exp_title)) {
			
			System.out.println("Title Test passed");
		}
		else {
			System.out.println("Title Test failed");
		}
				
		//Label validation after successful login
		String Act_lebel = "";
				
		try {
		Act_lebel = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		}
		catch(NoSuchElementException e) { 

		}
				
		String Exp_lebel = "Dashboard";
				
		if(Act_lebel.equals(Exp_lebel)) {
					
			System.out.println("Lebel Test passed");
		}
		else {
					
			System.out.println("Lebel Test failed");
		}
				
				
		//7) close browser
		//Close method give some errors then use quit method
		//driver.close(); 
		driver.quit();

	}

}
