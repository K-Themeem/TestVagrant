package objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SearchResults {
	@FindBys({ @FindBy(xpath = "//span[@class=\"product-card__title\"]") })
	private List<WebElement> searchResultsName;

	@FindBys({ @FindBy(xpath = "//a[@class=\"full-width-link\"]") })
	private List<WebElement> searchResults;

	/**
	 * @return the searchResultsName
	 */
	public List<WebElement> getSearchResultsName() {
		return searchResultsName;
	}

	/**
	 * @return the searchResults
	 */
	public List<WebElement> getSearchResults() {
		return searchResults;
	}

	public void openProduct(String productName) throws Exception {
		boolean success = false;
		for (int i = 0; i < searchResultsName.size(); i++) {
			if (searchResultsName.get(i).getText().equalsIgnoreCase(productName)) {
				success = true;
				searchResults.get(i).click();
				break;
			}
		}
		if (!success) {
			throw new Exception();
		}

	}

}
