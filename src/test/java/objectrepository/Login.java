package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibrary.UIInteraction;

public class Login {
	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[@class=\"btn btn--narrow\"]")
	private WebElement enterBtn;

	/**
	 * @return the passwordField
	 */
	public WebElement getPasswordField() {
		return passwordField;
	}

	/**
	 * @return the enterBtn
	 */
	public WebElement getEnterBtn() {
		return enterBtn;
	}

	public void loginToTheApp(String password) {
		UIInteraction.waitForElement(passwordField);
		passwordField.sendKeys(password);
		enterBtn.click();
	}
}