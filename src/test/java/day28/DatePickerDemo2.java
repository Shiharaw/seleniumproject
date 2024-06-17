package day28;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.checkerframework.checker.index.qual.LessThan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {
	
	//User define method for converting month from String-----> Month
	static Month convertMonth(String month) {
		
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth = monthMap.get(month);
		
		if(vmonth==null) {
			
			System.out.println("This is invalied month....");
		}
		
		return vmonth;
		
	}
	
	static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate) {
		
		//Select year
		WebElement drpYear= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(drpYear);
		selectYear.selectByVisibleText(requiredYear);
		
		while(true){
			
			//Select month
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			//Convert Required month and Display month in to Month objects
			Month expectedMonth= convertMonth(requiredMonth);
			Month currentMonth = convertMonth(displayMonth);
			
			//Compare months
			//Result<0 passed month
			//Result>0 future month
			//Result=0 months are equal
			
			int result = expectedMonth.compareTo(currentMonth);
			
			if(result==0) {
				break;
			}else if(result<0){
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		
		//Select date
		List<WebElement> allDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement DT:allDates) {
			
			if(DT.getText().equals(requiredDate)) {
				
				DT.click();
				
			}
			
		}
	}

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		String requiredYear ="1990";
		String requiredMonth ="October";
		String requiredDate = "22";
		
		selectDate(driver, requiredYear, requiredMonth, requiredDate);
		
	}

}
