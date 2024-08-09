package day44;

import org.testng.annotations.Test;

public class GroupingPaymentTests {
	
	@Test(priority = 1, groups = {"sanity","regression","functional"})
	void paymentInRuppes() {
		
		System.out.println("Payment in Ruppes.....");
	}
	
	@Test(priority = 2, groups = {"sanity","regression","functional"})
	void paymentInDollers() {
		
		System.out.println("Payment in Dollers.....");
	}

}
