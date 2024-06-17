package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownWithSelectTagDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		WebElement drpContryId= driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));
		Select drpCountry = new Select(drpContryId);
		
		//1) Selecting an option from drpContryId drop down
		drpCountry.selectByVisibleText("Brazil");
		
		Thread.sleep(2000);
		//Can use the value attribute only if the value attribute present in the option tag
		drpCountry.selectByValue("IRQ");
		
		Thread.sleep(2000);
		drpCountry.selectByIndex(11);
		
		//2) Total number of options available in the drop down
		List<WebElement> options= drpCountry.getOptions();
		System.out.println("Total number of options in the Cuntory dropdown: "+options.size());
		
		//3) Print total number of options available in the drop down
		for(int i=0; i<options.size();i++) {
			
			options.get(i).getText();
			System.out.println(options.get(i).getText());
		}
		System.out.println("********************************");
		//Using enhanced loop
		for(WebElement op:options) {
			
			System.out.println(op.getText());
		}

	}

}
