package com.POMDemo4.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POMDemo4.qa.util.TakeScreenshot;
import com.POMDemo4.qa.base.Base;
import com.POMDemo4.qa.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends Base{
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initlization();
		TakeScreenshot.setExtent();
		homepage = new HomePage();
	}
	@Test
	public void validatePageImgTest() {
		extentTest = extent.startTest("validatePageImgTest");
		Assert.assertTrue(homepage.validatePageImg());
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
//	@AfterTest
//	public void endReport() {
//		extent.flush();
//		extent.close();
//	}
}
