package genericlibrary;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author K Themeem
 * 
 *         Class to accommodate UI interactions
 *
 */
public class UIInteraction extends CommonLibrary {

	static WebDriverWait wait = new WebDriverWait(driver, waitTime);

	/**
	 * Method to wait for a particular element
	 * 
	 * @param element
	 */
	public static void waitForElement(WebElement element) {
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
