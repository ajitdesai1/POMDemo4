package com.POMDemo4.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.POMDemo4.qa.base.Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TakeScreenshot extends Base{
	
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/FailedTestsScreenshot/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	
	public static void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		// System.getProperty("user.dir") will get the project path
		// "true" if you would like to replace the existing file, else "false".
		extent.addSystemInfo("Host Name", "AD Windows"); // these details will be shown on extent report and you can add
															// multiple values
		extent.addSystemInfo("User Name", "AD");
		extent.addSystemInfo("Enviroment", "QA");
	}
	

}
