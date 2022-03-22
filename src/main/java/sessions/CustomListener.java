package sessions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class CustomListener extends Basepage implements ITestListener {
	public Logger log = Logger.getLogger(CustomListener.class);

	@Override
	public void onTestStart(ITestResult result) {
		log.info(result.getName() + " started");
		test = report.startTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(result.getName() + " Test is passed");
		String pathForScreenshot = Utils.captureScreenshot();

		test.log(LogStatus.PASS, result.getName() + " extent Test is passed");
		test.log(LogStatus.PASS, test.addScreenCapture(pathForScreenshot));


	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info(result.getName() + " Test is Failed");
		String pathForScreenshot = Utils.captureScreenshot();
		log.info("Screenshot store at : " + pathForScreenshot);
		test.log(LogStatus.FAIL, result.getName() + " extent Test is Failed");
		test.log(LogStatus.INFO, result.getThrowable().getMessage());
		test.log(LogStatus.FAIL, test.addScreenCapture(pathForScreenshot));
		
//		test.addScreenCapture("")
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, result.getName() + " extent Test is skipped");
		
//		test.log(LogStatus., null);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.endTest(test);
		report.flush();
	}

}
