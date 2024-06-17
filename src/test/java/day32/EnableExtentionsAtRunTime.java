package day32;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtentionsAtRunTime {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		File SelectotsHub = new File("D:\\selenium\\CRXFiles\\SelectorsHub.crx");
		options.addExtensions(SelectotsHub);
		
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://text-compare.com/");

	}

}
