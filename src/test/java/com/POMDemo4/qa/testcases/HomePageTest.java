package com.POMDemo4.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POMDemo4.qa.base.Base;
import com.POMDemo4.qa.pages.HomePage;

public class HomePageTest extends Base{
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initlization();
		homepage = new HomePage();
	}
	@Test
	public void validatePageImgTest() {
		Assert.assertTrue(homepage.validatePageImg());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
