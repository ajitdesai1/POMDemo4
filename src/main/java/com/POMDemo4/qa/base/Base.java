package com.POMDemo4.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.POMDemo4.qa.util.Util;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public Base() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("D:\\EclipseInstallFolder\\EclipseWorkspace\\POMDemo4\\src\\main\\java\\com\\POMDemo4\\qa\\config\\config.properties");
		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void initlization() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\EclipseInstallFolder\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", "D:\\EclipseInstallFolder\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Util.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.implicitWaitTimeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
