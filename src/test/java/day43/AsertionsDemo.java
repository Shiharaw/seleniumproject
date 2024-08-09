package day43;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;


//When use if else condition to validate the test, print based on the condition as "Test is failed" but method testTitle1() shows as passed.
//When use TestNG assertions to validate the test, method testTitle2() shows as failed.
public class AsertionsDemo {
	
	//Validate test with if else condition
	@Test(priority = 1)
	void testTitle1() {
		
		String exp_title = "Opencart";
		String act_title = "Openshop";
		
		if(exp_title.equals(act_title)) {
			
			System.out.println("Test is passed");
		}
		else {
			
			System.out.println("Test is failed");
		}
	}
	
	//Validate test with TestNG Assertions only
	@Test(priority = 2)
	void testTitle2() {
		
		String exp_title = "Opencart";
		String act_title = "Openshop";
		
		Assert.assertEquals(exp_title, act_title);
	}
	
	//Validate test with if else condition and TestNG assertions both
	@Test(priority = 3)
	void testTitle3() {
		
		String exp_title = "Opencart";
		String act_title = "Openshop";
		
		if(exp_title.equals(act_title)) {
			
			System.out.println("Test is passed");
			Assert.assertTrue(true);
		}
		else {
			
			System.out.println("Test is failed");
			Assert.assertTrue(false);
		}
	}

}
