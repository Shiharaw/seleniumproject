package day33;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1) Link  href ="https://xyz.com"
2) https://xyz.com -----> hit the server ---->return status code
3) status code >= 400 -----> broken link 
   status code < 400 -----> not a broken link 
*/

public class BrokenLinks {

	public static void main(String[] args) {
		int numBrokenLinks =0;
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//capture all links from the web site
		List <WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: "+links.size());
		
		for(WebElement linkElement:links) {
			
			String herfAttValue = linkElement.getAttribute("href");
			if(herfAttValue==null || herfAttValue.isEmpty()) {
				
				System.out.println("herf attribute value is null or empty. So not possible to check");
				//continue;
			}
			
			//Hit URL to the server
			try {
				URL linkUrl = new URL(herfAttValue);		//Convert herfAttValue String to URL format
				HttpURLConnection conn= (HttpURLConnection)linkUrl.openConnection();	//Open connection to the server
				conn.connect();		//connect to server and sent request to server
			
				if(conn.getResponseCode()>=400) {
				
					System.out.println(herfAttValue+"---->This is a broken link");
					numBrokenLinks++;
				}else {
				
					System.out.println(herfAttValue+"---->This is not a broken link");
				}
			
			}catch(Exception e) {
				
			}
			
		}
		System.out.println("Number of broken links: "+numBrokenLinks);

	}

}
