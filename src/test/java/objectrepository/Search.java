package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author K Themeem
 * 
 * Page class of Search page
 *
 */
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
	
	/**
	 * Method to search for the product
	 * @param productName
	 */
	public void searchForProduct(String productName) {
		searchBox.sendKeys(productName);
		searchIcon.click();
	}
}
