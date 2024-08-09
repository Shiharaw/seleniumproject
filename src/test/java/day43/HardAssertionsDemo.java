package day43;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsDemo {
	
	@Test
	void test() {
		//Compare strings and numbers both
		
		//Assert.assertEquals("xyz","xyz");		//Passed
		//Assert.assertEquals(123,345);			//Failed
		//Assert.assertEquals("abc", 123);		//Failed
		//Assert.assertEquals("123",123);		//Failed
		
		//Assert.assertNotEquals(123, 123); 	//Failed
		//Assert.assertNotEquals(123, 345); 	//Passed
		
		//Assert.assertTrue(true); 				//Passed
		//Assert.assertTrue(false); 			//Failed
		//Assert.assertTrue(1==2); 				//Failed
		//Assert.assertTrue(1==1); 				//Passed
		
		//Assert.assertFalse(1==2); 			//Passed
		//Assert.assertFalse(2==2); 			//Failed
		
		Assert.fail();		//Without checking anything, fail the test
	}

}
