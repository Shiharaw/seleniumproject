package day43;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
1)Login 	---> @BeforeMethod
2)Search 	---> @Test
3)Logout 	---> @AfterMethod
4)Login 	---> @BeforeMethod
5)Adv Search 	---> @Test
6)Logout 	---> @AfterMethod
*/


public class AnnotationsDemo2 {
	
	@BeforeMethod
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
	
	@AfterMethod
	void logout() {
		
		System.out.println("This is Logout.....");
	}
}
