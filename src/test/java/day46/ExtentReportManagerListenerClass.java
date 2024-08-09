package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManagerListenerClass implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;	//UI of the report
	public ExtentReports extent;				//population common info on the report
	public ExtentTest test;						//creating test case entries in the report and update status of the test method
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReport.html");	//Specify report location
		
		sparkReporter.config().setDocumentTitle("Automation Report");	//Title of the report
		sparkReporter.config().setReportName("Functional Report");		//Name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Envioranment", "QA");
		extent.setSystemInfo("Teater Name", "Shihara");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		  
		}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());		//Create new entry in the report
		test.log(Status.PASS, "Test case passed is:"+ result.getName());	//Update status p/f/s
		}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is:"+ result.getName());
		test.log(Status.FAIL, "Test case failed cause is:"+ result.getThrowable());
		
		}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skiped is:"+ result.getName());
		  
		}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();		//This will write all details to the report
		  
		}
		

}
