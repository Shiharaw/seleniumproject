package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUploadDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//Single file upload CV.text
		driver.findElement(By.name("filesToUpload")).sendKeys("C:\\Users\\shiha\\Desktop\\CV\\CV.txt");
		
		System.out.println(driver.findElement(By.xpath("//ul[@id='fileList']")).getText());
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']")).getText().equals("CV.txt")) {
			
			System.out.println("CV.txt is successfully uploaded");
		}else {
			
			System.out.println("CV.txt is not successfully uploaded");
		}
		

	}

}
