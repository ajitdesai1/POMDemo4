package com.POMDemo4.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POMDemo4.qa.base.Base;
import com.POMDemo4.qa.util.Xls_Reader;

public class BookStoreLogin extends Base{

	@FindBy(xpath = "//h5[contains(text(),'Book Store Application')]")
	WebElement bookStoreMenuSelect;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement loginBtn;
	
	@FindBy(id = "userName")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement logout;
	
	public BookStoreLogin() {
		PageFactory.initElements(driver,this);
	}
	public void selectBookStorefromHomePage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");		
		bookStoreMenuSelect.click();
		Thread.sleep(2000);
	}
	public void login() throws InterruptedException {

		loginBtn.click();
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/POMDemo4/qa/util/SampleExcel.xlsx");
		String usernameXls = reader.getCellData("Sheet1", 0, 2);
		String passwordXls = reader.getCellData("Sheet1", 1, 2);
		
		username.sendKeys(usernameXls);
		password.sendKeys(passwordXls);
		loginBtn.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(2000);
	}
	

}
