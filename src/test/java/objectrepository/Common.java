package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author K Themeem
 * 
 *         Class for common actions in all pages
 *
 */
public class Common {
	@FindBy(xpath = "//a[@class=\"site-header__logo-link\"]")
	private WebElement appHeader;

	/**
	 * @return the appHeader
	 */
	public WebElement getAppHeader() {
		return appHeader;
	}

	public void goToMainPage() {
		appHeader.click();
	}
}
