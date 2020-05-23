package genericlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectrepository.Common;
import objectrepository.Login;
import objectrepository.Welcome;

/**
 * 
 * @author K Themeem
 * 
 *         Base class to accommodate all base operations
 *
 */
public class Base {
	public static WebDriver driver;
	public CommonLibrary commonLib = null;

	/**
	 * Method to initialize data for testing from property file which executes
	 * before starting the suite
	 * 
	 * @throws IOException
	 */

	@BeforeSuite
	public void initializeData() throws IOException {
		commonLib = new CommonLibrary();
		commonLib.initData();
	}

	/**
	 * Method to open browser
	 */
	@BeforeTest
	@Parameters("browserName")
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase(CommonLibrary.chromeBrowser)) {
			System.setProperty(CommonLibrary.chromedriverKey, CommonLibrary.chromedriverPath);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase(CommonLibrary.firefoxBrowser)) {
			System.setProperty(CommonLibrary.firefoxdriverKey, CommonLibrary.firefoxdriverPath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(CommonLibrary.waitTime, TimeUnit.SECONDS);
		driver.get(CommonLibrary.applicationUrl);
	}

	@BeforeClass
	/**
	 * 
	 * Method to login to App
	 */
	public void logintoApp() {
		Welcome welcome = PageFactory.initElements(driver, Welcome.class);
		welcome.gotoLoginPage();
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginToTheApp(CommonLibrary.applicationPassword);
	}

	/**
	 * 
	 * Method to go to main page
	 * 
	 * @throws IOException
	 */
	@AfterMethod
	public void goToMainPage() {
		CommonLibrary.extent.flush();
		Common common = PageFactory.initElements(driver, Common.class);
		common.goToMainPage();
	}

	/**
	 * 
	 * Method to logout from application
	 */
	@AfterClass
	public void logoutFromApp() {
		System.out.println("Logout");
	}
	
	/**
	 * Method to close browser
	 */
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * 
	 * Method to close input data which executes after the suite
	 */
	@AfterSuite
	public void closeInputData() throws IOException {
		if (CommonLibrary.input != null)
			CommonLibrary.input.close();
		CommonLibrary.extent.close();
	}

}
