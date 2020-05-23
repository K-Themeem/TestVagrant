package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CommonLibrary extends Base {

	public static ExtentTest logger;
	public static DriverInputData driverData = new DriverInputData();
	public static TestData testData = new TestData();
	public static InputStream input = null;
	public static ExtentReports report;
	public static String chromedriverPath;
	public static String firefoxdriverPath;
	public static String chromedriverKey;
	public static String firefoxdriverKey;
	public static final String chromeBrowser = "chrome";
	public static final String firefoxBrowser = "firefox";
	public static final int waitTime = 30;
	public static String applicationUrl;
	public static String applicationPassword;
	public static String screenShotPath;
	public static String dateFormat;
	public static final String userDirectory = System.getProperty("user.dir");
	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String nameSeparator = "_";
	public static final String screenShotType = ".png";
	public static final String extentReport = "test-output" + fileSeparator + "ExtentReport.html";
	public static final String extentReportFile = "extent-config.xml";
	public static File source;
	public static File finalDestination;

	public static ExtentReports extent = new ExtentReports(extentReport, true);

	public static String getScreenshot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat(dateFormat).format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		source = ts.getScreenshotAs(OutputType.FILE);
		String destination = screenShotPath + screenshotName + nameSeparator + dateName + screenShotType;
		finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void initData() throws IOException {
		extent.loadConfig(new File(extentReportFile));
		chromedriverPath = driverData.getPropertyValue("chromeDriverPath");
		firefoxdriverPath = driverData.getPropertyValue("geckoDriverPath");
		chromedriverKey = driverData.getPropertyValue("chromeDriverKey");
		firefoxdriverKey = driverData.getPropertyValue("geckoDriverKey");
		applicationUrl = testData.getPropertyValue("applicationURL");
		applicationPassword = testData.getPropertyValue("applicationPassword");
		screenShotPath = testData.getPropertyValue("screenshotPath");
		dateFormat = testData.getPropertyValue("dateFormat");
	}
}
