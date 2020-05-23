package genericlibrary;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIInteraction extends CommonLibrary {

	static WebDriverWait wait = new WebDriverWait(driver, waitTime);

	public static void waitForElement(WebElement element) {
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
