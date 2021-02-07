package com.POMDemo4.qa.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POMDemo4.qa.util.TakeScreenshot;
import com.POMDemo4.qa.base.Base;
import com.POMDemo4.qa.pages.SBookStoreLogin;
import com.relevantcodes.extentreports.LogStatus;

public class SBookStoreLoginTest extends Base{
	SBookStoreLogin bookStoreLogin; 
	public SBookStoreLoginTest() {
		super();
		TakeScreenshot.setExtent();
	}
	@BeforeTest
	public void setUp() {
		initlization();
		bookStoreLogin = new SBookStoreLogin();
	}
	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		
		extentTest = extent.startTest("SBookStoreLogin");
		bookStoreLogin.login();
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report
			String screenshotPath = TakeScreenshot.getScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
																							// report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
		}
		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
		driver.quit();
	}
	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

}
