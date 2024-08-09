package day43;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
	
	//When use hard assertions if the assertion is got failed rest of the statements will not execute
	@Test(priority = 2)
	void testHardAssertions() {
		
		System.out.println("Testing....");
		System.out.println("Testing....");
		
		//Can direct access the hard assertions
		Assert.assertEquals(1, 2);		//Hard Assertion
		
		System.out.println("Testing....");
		System.out.println("Testing....");
	}
	
	@Test(priority = 1)
	void testSoftAssertions() {
		
		System.out.println("Testing....");
		System.out.println("Testing....");
		
		//Using soft assert need to create object from SoftAssert class
		//Use the created object to access to soft assert
		SoftAssert sa = new SoftAssert(); 	 
		sa.assertEquals(1, 2);				//Soft Assertion
		
		System.out.println("Testing....");
		System.out.println("Testing....");
		
		//This is mandatory for when using soft assertions
		//This need to add at the end of the test method
		//This will give the correct result to the test
		sa.assertAll();		
	}

}
