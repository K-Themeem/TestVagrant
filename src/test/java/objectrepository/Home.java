package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author K Themeem
 * 
 *         Class for Home page
 *
 */
public class Home {
	@FindBy(xpath = "//div[@class=\"site-header__icons-wrapper\"]/button[contains(@class,\"top\")]")
	private WebElement searchIcon;

	/**
	 * @return the searchIcon
	 */
	public WebElement getSearchIcon() {
		return searchIcon;
	}

	/**
	 * method to go for searching
	 */
	public void gotoSearch() {
		searchIcon.click();
	}
}
