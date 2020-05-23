package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author K Themeem
 * Page class of Welcome page
 *
 */
public class Welcome {
	@FindBy(xpath = "//div[@class=\"password-login\"]/a")
	private WebElement passwordIcon;

	/**
	 * @return the passwordIcon
	 */
	public WebElement getPasswordIcon() {
		return passwordIcon;
	}
	
	/**
	 * Method to go to login page
	 */
	public void gotoLoginPage() {
		passwordIcon.click();
	}
}
