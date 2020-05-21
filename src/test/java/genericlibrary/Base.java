package genericlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * 
 * @author K Themeem
 * 
 *         Base class to accommodate all base operations
 *
 */
public class Base {
	public static WebDriver driver;
	public Common commonLib = null;

	/*
	 * 
	 * Method to initialize data for testing from property file which executes
	 * before starting the suite
	 */
	@BeforeSuite
	public void initializeData() throws IOException {
		commonLib = new Common();
		commonLib.initData();
	}

	/**
	 * Method to open browser
	 */
	@BeforeClass
	@Parameters("browserName")
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase(Common.chromeBrowser)) {
			System.setProperty(Common.chromedriverKey, Common.chromedriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase(Common.firefoxBrowser)) {
			System.setProperty(Common.firefoxdriverKey, Common.firefoxdriverPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Common.waitTime, TimeUnit.SECONDS);
		driver.get(Common.applicationUrl);
	}

	/**
	 * 
	 * Method to login to App
	 */
	@BeforeMethod
	public void logintoApp(ITestResult result) {
		System.out.println("Login");
	}

	/**
	 * 
	 * Method to logout from app
	 * 
	 * @throws IOException
	 */
	@AfterMethod
	public void logoutFromApp() throws IOException {
		FileUtils.copyFile(Common.source, Common.finalDestination);
		Common.extent.flush();
		System.out.println("logout");
	}

	/**
	 * 
	 * Method to close browser
	 */
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * 
	 * Method to close input data which executes after the suite
	 */
	@AfterSuite
	public void closeInputData() throws IOException {
		if (Common.input != null)
			Common.input.close();
		Common.extent.close();
	}

}
