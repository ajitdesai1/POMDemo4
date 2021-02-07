package com.POMDemo4.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POMDemo4.qa.base.Base;
import com.POMDemo4.qa.pages.BookStoreLogin;

public class BookStoreLoginTest extends Base{
	BookStoreLogin bookStoreLogin; 
	public BookStoreLoginTest() {
		super();
	}
	@BeforeTest
	public void setUp() {
		initlization();
		bookStoreLogin = new BookStoreLogin();
	}
	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		bookStoreLogin.selectBookStorefromHomePage();
		bookStoreLogin.login();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
