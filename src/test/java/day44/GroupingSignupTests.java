package day44;

import org.testng.annotations.Test;

public class GroupingSignupTests {
	
	@Test(priority = 1, groups = {"regression"})
	void loginByEmail() {
		
		System.out.println("This is signup by E-mail....");
	}
	
	@Test(priority = 2, groups = {"regression"})
	void loginByFacebook() {
		
		System.out.println("This is signup by Facebook....");
	}
	
	@Test(priority = 3, groups = {"regression"})
	void loginByTwitter() {
		
		System.out.println("This is signup by Twitter...");
	}


}
