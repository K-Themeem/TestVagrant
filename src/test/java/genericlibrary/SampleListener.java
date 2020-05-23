package genericlibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class SampleListener extends Common implements ITestListener {

	String screenshotPath = null;

	public void onFinish(ITestContext context) {
	}

	public void onStart(ITestContext context) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		logger = Common.extent.startTest(result.getName());
		try {
			screenshotPath = getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
		logger.log(LogStatus.FAIL, logger.addScreenCapture(userDirectory + fileSeparator + screenshotPath));
		extent.endTest(Common.logger);
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		logger = Common.extent.startTest(result.getName());
		logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		extent.endTest(Common.logger);
	}

}
