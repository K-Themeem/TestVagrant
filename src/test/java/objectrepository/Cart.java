package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {
	@FindBy(xpath = "//a[@class=\"cart__product-title\"]")
	private WebElement cartItem;

	/**
	 * @return the cartItem
	 */
	public WebElement getCartItem() {
		return cartItem;
	}

	public boolean verifyCart(String productInCart) {
		boolean success = false;
		if (cartItem.isDisplayed()) {
			if (cartItem.getText().equalsIgnoreCase(productInCart)) {
				success = true;
			}
		}
		return success;
	}
}
