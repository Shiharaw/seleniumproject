package day43.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	
	@Test
	void pqr() {
		
		System.out.println("This is pqr from C3.........");
	}
	
	@BeforeSuite
	void bs() {
		
		System.out.println("This is Before Suit method from C3.........");
	}
	
	@AfterSuite
	void af() {
		
		System.out.println("This is After Suit method from C3.........");
	}

}
