package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibrary.UIInteraction;

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

	public String getProductTitle() {
		return productTitleField.getText();
	}

	public void addToCart() {
		addToCartBtn.click();
	}
	
	public void goToCart() {
		UIInteraction.waitForElement(getGoToCartLink());
		goToCartLink.click();
	}
	
}
