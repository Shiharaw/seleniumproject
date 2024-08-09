package day42;

import org.testng.annotations.Test;

/*
 1 Open app
 2 Login app
 3 Logout app
 */

public class FirstTestCase {
	
	@Test(priority =1)
	void openapp() {
		
		System.out.println("opening the application.....");
	}
	
	@Test(priority =2)
	void login() {
		
		System.out.println("login to the application.....");
	}
	
	@Test(priority =3)
	void logout() {
		
		System.out.println("logout from the application.....");
	}

}
