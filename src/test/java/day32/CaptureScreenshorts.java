package day32;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class CaptureScreenshorts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//1)capture full page
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		//get full screen short in source file, but source file location is we do not know
		File soursefile1= ts.getScreenshotAs(OutputType.FILE);
		//System.getProperty("User.Dir") - This will return the current users directory
		File targetfile1= new File(System.getProperty("user.dir")+"\\screenshorts\\Fullscreennopcommerce.png");
		
		//Source file copy to target file
		soursefile1.renameTo(targetfile1);
		
		
		//2)capture the screenshot from the specific section
		WebElement fetrProds= driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File soursefile2= fetrProds.getScreenshotAs(OutputType.FILE);
		//System.getProperty("User.Dir") - This will return the current users directory
		File targetfile2= new File(System.getProperty("user.dir")+"\\screenshorts\\FetrProds.png");
		
		//Source file copy to target file
		soursefile2.renameTo(targetfile2);
		
		
		//2)capture the screenshot of the web element
		WebElement nopcomLogo= driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		File soursefile3= nopcomLogo.getScreenshotAs(OutputType.FILE);
		//System.getProperty("User.Dir") - This will return the current users directory
		File targetfile3= new File(System.getProperty("user.dir")+"\\screenshorts\\NopcomLogo.png");
		
		//Source file copy to target file
		soursefile3.renameTo(targetfile3);
		

	}

}
