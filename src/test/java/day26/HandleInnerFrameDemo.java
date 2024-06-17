package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleInnerFrameDemo {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Frame1
		WebElement frame1= driver.findElement(By.xpath("//*[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.name("mytext1")).sendKeys("SSS111");
		
		driver.switchTo().defaultContent();
		
		//Frame3
		WebElement frame3= driver.findElement(By.xpath("//*[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.name("mytext3")).sendKeys("SSS333");
		
		//iframe
		//Use index to find the iframe because inside the Frame3 only have one frame 
		//Index of the frame is starting from  0
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='i8']/div[3]/div")).click();
		
		driver.switchTo().defaultContent();
		
		//Frame2
		WebElement frame2= driver.findElement(By.xpath("//*[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.name("mytext2")).sendKeys("SSS222");
		
		

	}

}
