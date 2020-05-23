package objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Cart {

	@FindBys({ @FindBy(xpath = "//a[@class=\"cart__product-title\"]") })
	private List<WebElement> cartItems;

	/**
	 * @return the cartItems
	 */
	public List<WebElement> getCartItems() {
		return cartItems;
	}

	public boolean verifyCart(String productInCart) {
		boolean success = false;
		if (cartItems.get(0).isDisplayed()) {
			for (WebElement cartItem : cartItems) {
				if (cartItem.getText().trim().equalsIgnoreCase(productInCart.trim())) {
					success = true;
					break;
				}
			}
		}
		return success;
	}
}
