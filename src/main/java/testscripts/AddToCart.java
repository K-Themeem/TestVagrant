package testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericlibrary.Base;
import genericlibrary.CommonLibrary;
import objectrepository.Cart;
import objectrepository.Home;
import objectrepository.ProductDetail;
import objectrepository.Search;
import objectrepository.SearchResults;

public class AddToCart extends Base {
	/**
	 * @return the test data to be tested
	 * @throws IOException
	 */
	@DataProvider(name = "Add_To_Cart_Data")
	public Object[][] getData() throws IOException {
		return new Object[][] { { CommonLibrary.testData.getPropertyValue("commodityItem1") },
				{ CommonLibrary.testData.getPropertyValue("commodityItem2") } };
	}

	@Test(dataProvider = "Add_To_Cart_Data")
	public void searchAndAddToCart(String commodityName) throws Exception {
		Home home = PageFactory.initElements(driver, Home.class);
		home.gotoSearch();
		Search search = PageFactory.initElements(driver, Search.class);
		search.searchForProduct(commodityName);
		SearchResults results = PageFactory.initElements(driver, SearchResults.class);
		results.openProduct(commodityName);
		ProductDetail detail = PageFactory.initElements(driver, ProductDetail.class);
		String productTitle = detail.getProductTitle();
		Assert.assertEquals(productTitle, commodityName);
		detail.addToCart();
		detail.goToCart();
		Cart cart = PageFactory.initElements(driver, Cart.class);
		Assert.assertEquals(cart.verifyCart(productTitle), true);
	}

}
