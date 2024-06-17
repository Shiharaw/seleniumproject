package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipeFileUploadDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//Multiple file upload CV.text
		String file1 = "C:\\Users\\shiha\\Desktop\\CV\\CV.txt";
		String file2 = "C:\\Users\\shiha\\Desktop\\CV\\Linkdin Training.txt";
				
		driver.findElement(By.name("filesToUpload")).sendKeys(file1+"\n"+file2);
		
		//Validate number of files
		int NumofFiles= driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();
		
		if(NumofFiles ==2) {
			
			System.out.println("Uploaded file count is correct");
		}else {
			
			System.out.println("Uploaded file count is incorrect");
		}
		
		//Validate file names uploaded
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("CV.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText().equals("Linkdin Training.txt")) {
			
			System.out.println("Uploaded file names are matching");			
		}else {
			System.out.println("Uploaded file names are not matching");
		}

	}

}
