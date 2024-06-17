package day32;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockingAdds {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		File uBlock = new File("D:\\selenium\\CRXFiles\\uBlock-Origin.crx");
		options.addExtensions(uBlock);
		
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://text-compare.com/");


	}

}
