package com.POMDemo4.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.POMDemo4.qa.base.Base;

public class HomePage extends Base{
	
	@FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
	WebElement homePageImg;
	
	public HomePage() {
		PageFactory.initElements(driver, this);		
	}
	public boolean validatePageImg() {
		return homePageImg.isDisplayed();
	}
	

}
