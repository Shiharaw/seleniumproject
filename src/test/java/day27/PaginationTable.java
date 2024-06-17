package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		
		//Login
		WebElement username = driver.findElement(By.name("username"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("demo");
		
		WebElement login= driver.findElement(By.xpath("//button"));
		login.click();
		
		//Close Security Notification
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
			
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		//Select Customer
		driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
		driver.findElement(By.xpath("//li[1]/a[contains(text(),'Customers')]")).click();
		
		//get "Showing 1 to 10 of 20312 (2032 Pages)"
		String pagesText = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		//Get number of pages
		int total_pages = Integer.parseInt(pagesText.substring(pagesText.indexOf("(")+1,pagesText.indexOf("Pages")-1));
		System.out.println("Total Number of Pages: "+total_pages);
		Thread.sleep(10000);
		
		
		for(int p=1;p<=5;p++) {
			
			if(total_pages>1) {
				
				WebElement active_Page = driver.findElement(By.xpath("//*[@class='pagination']/li//*[text()="+p+"]"));
				System.out.println("ActivePage: "+ active_Page.getText());
				active_Page.click();
				Thread.sleep(2000);
				
			}
			
			int numOfrows= driver.findElements(By.xpath("//*[@id='form-customer']/div[1]//tbody/tr")).size();
			System.out.println("Total Number of Rows in the Active Page: "+numOfrows);
			
			for(int r=1;r<=numOfrows;r++) {
				
			String custName	= driver.findElement(By.xpath("//*[@id='form-customer']/div[1]//tbody/tr["+r+"]/td[2]")).getText();
			String email	= driver.findElement(By.xpath("//*[@id='form-customer']/div[1]//tbody/tr["+r+"]/td[3]")).getText();
			String Status	= driver.findElement(By.xpath("//*[@id='form-customer']/div[1]//tbody/tr["+r+"]/td[5]")).getText();
			
			System.out.print(custName+"   "+email+"   "+Status );
				
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		

	}

}
