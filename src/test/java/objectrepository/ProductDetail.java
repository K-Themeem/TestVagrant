package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibrary.UIInteraction;

/**
 * 
 * @author K Themeem
 * 
 *         Page class for ProductDetail
 *
 */
public class ProductDetail {
	@FindBy(xpath = "//h1[@class=\"product-single__title\"]")
	private WebElement productTitleField;

	@FindBy(xpath = "//button[@name=\"add\"]")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//a[contains(@class,\"cart-popup__cta-link\")]")
	private WebElement goToCartLink;

	/**
	 * @return the productTitle
	 */
	public WebElement getProductTitleField() {
		return productTitleField;
	}

	/**
	 * @return the addToCartBtn
	 */
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	/**
	 * @return the goToCartLink
	 */
	public WebElement getGoToCartLink() {
		return goToCartLink;
	}

	/**
	 * Method to get the product title
	 * 
	 * @return product name in product detail page
	 */
	public String getProductTitle() {
		return productTitleField.getText().trim();
	}

	/**
	 * Method to add product to cart
	 */
	public void addToCart() {
		addToCartBtn.click();
	}

	/**
	 * Method to open cart
	 */
	public void goToCart() {
		UIInteraction.waitForElement(getGoToCartLink());
		goToCartLink.click();
	}

}
