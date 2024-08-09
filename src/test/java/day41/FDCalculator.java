package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

public class FDCalculator {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath =  System.getProperty("user.dir")+"\\testdata\\CalData.xlsx";
		
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		int cols = ExcelUtils.getCellCount(filePath, "Sheet1", 1);
		System.out.println(cols);		
		for(int i=1;i<=rows;i++) {
			
			//Read data from excel
			String prin= ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rOI = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String perNum = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String perType = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String freq = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expMatVal = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//Pass data into the application
			driver.findElement(By.id("principal")).sendKeys(prin);
			driver.findElement(By.name("interest")).sendKeys(rOI);
			driver.findElement(By.name("tenure")).sendKeys(perNum);
			Select perTypeDrp= new Select(driver.findElement(By.name("tenurePeriod")));
			perTypeDrp.selectByVisibleText(perType);
			Select freqDrp= new Select(driver.findElement(By.name("frequency")));
			freqDrp.selectByVisibleText(freq);
			
			//Clicked on Calculate button
			WebElement calcutate= driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]"));
			
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", calcutate);	
			
			//Validation and update excel sheet
			String actMatVal = driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(expMatVal)==Double.parseDouble(actMatVal)) {
				
				System.out.println("Actual Maturity Value is equal to Expected Maturity Value ");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColour(filePath, "Sheet1", i, 7);
			}
			else {
				
				System.out.println("Actual Maturity Value is not equal to Expected Maturity Value ");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColour(filePath, "Sheet1", i, 7);
			}
			//Clicked on Clear button
			WebElement clear = driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]"));
			js.executeScript("arguments[0].click()", clear);	
			
		}//Ending the for loop
		
		driver.quit();

	}

}
