package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Welcome {
	@FindBy(xpath = "//div[@class=\"password-login\"]/a")
	private WebElement passwordIcon;

	/**
	 * @return the passwordIcon
	 */
	public WebElement getPasswordIcon() {
		return passwordIcon;
	}
	
	public void gotoLoginPage() {
		passwordIcon.click();
	}
}
