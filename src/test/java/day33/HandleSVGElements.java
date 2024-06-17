package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSVGElements {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Absolute xpath of SVG element of time>>>cannot find the element
		//driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/svg")).click();
		
		//Relative xpath given by SelectorsHub for SVG element
		//driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		
		//Relative xpath - using name tag
		driver.findElement(By.xpath("//li[4]//*[name()='svg']")).click();
		
	}

}
