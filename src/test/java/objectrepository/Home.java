package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	@FindBy(xpath = "//div[@class=\"site-header__icons-wrapper\"]/button[contains(@class,\"top\")]")
	private WebElement searchIcon;

	/**
	 * @return the searchIcon
	 */
	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public void gotoSearch() {
		searchIcon.click();
	}
}
