package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibrary.Base;

public class AddToCart extends Base {
	
	@Test()
	public void searchAndAddToCart() {
		System.out.println("First test");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), /*"ecom.optimus – Opening Soon"*/"Themeem");
	}
	
	@Test()
	public void searchAndAddToCart1() {
		System.out.println("Second test");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "ecom.optimus – Opening Soon");
	}
	
	@Test()
	public void searchAndAddToCart2() {
		System.out.println("Third test");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), /*"ecom.optimus – Opening Soon"*/"Themeem");
	}
}
