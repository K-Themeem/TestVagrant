package genericlibrary;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class UIInteraction extends Common {

	WebDriverWait wait = new WebDriverWait(driver, waitTime);

	public void click(WebElement element) {
		try {
			element.click();
			logger.log(LogStatus.PASS, "Click passed for element" + element);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Click failed for element" + element);
			throw new NoSuchElementException();
		}
	}

	public void enterMessage(WebElement element, String message) {
		try {
			element.sendKeys(message);
			logger.log(LogStatus.PASS, "Enter " + message + " passed for element" + element);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Enter " + message + " failed for element" + element);
			throw new NoSuchElementException();
		}
	}

	public void waitForElement(WebElement element) {
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
