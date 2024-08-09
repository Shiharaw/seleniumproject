package day43.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
	
	@Test
	void xyz() {
		
		System.out.println("This is xyz from C2.........");
	}
	
	@AfterTest
	void ft() {
		
		System.out.println("This is After Test method from C2.........");
	}

}
