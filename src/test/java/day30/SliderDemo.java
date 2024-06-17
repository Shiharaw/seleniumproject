package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		//min-slider
		WebElement minSlider= driver.findElement(By.xpath("//span[1]"));
		minSlider.getLocation();	//getLocation method to get y x coordinates
		System.out.println("Default location of the Min-Slider "+minSlider.getLocation());
		
		act.dragAndDropBy(minSlider,100,0).perform();
		System.out.println("After move, location of the Min-Slider "+minSlider.getLocation());
		
		//max-slider
		WebElement maxSlider= driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default location of the Max-Slider "+maxSlider.getLocation());
		
		act.dragAndDropBy(maxSlider,-100,0).perform();
		System.out.println("After move, location of the Min-Slider "+maxSlider.getLocation());
		
	}

}
