package day43;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1)Login 	---> @BeforeClass
2)Search 	---> @Test
3)Adv Search 	---> @Test
4)Logout 	---> @AfterClass
*/


public class AnnotationsDemo1 {
	
	@BeforeClass
	void login(){
		
		System.out.println("This is Login.....");
	}
	
	@Test(priority = 1)
	void search() {
		
		System.out.println("This is Search.....");
	}
	
	@Test(priority = 2)
	void advanceSearch() {
		
		System.out.println("This is Advance Search.....");
	}
	
	@AfterClass
	void logout() {
		
		System.out.println("This is Logout.....");
	}
}
