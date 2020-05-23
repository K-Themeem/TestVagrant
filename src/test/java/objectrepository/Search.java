package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {
	@FindBy(xpath ="//input[@name=\"q\"]")
	private WebElement searchBox;
	
	@FindBy(xpath ="//*[@class=\"icon icon-search\"]")
	private WebElement searchIcon;

	/**
	 * @return the searchBox
	 */
	public WebElement getSearchBox() {
		return searchBox;
	}

	/**
	 * @return the searchIcon
	 */
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	public void searchForProduct(String productName) {
		searchBox.sendKeys(productName);
		searchIcon.click();
	}
}
