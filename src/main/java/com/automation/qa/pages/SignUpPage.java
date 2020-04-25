package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.Base;

public class SignUpPage extends Base {
	
	WebDriver ldriver;
	

	public SignUpPage(WebDriver rdriver)
	//here l for local and r for remote
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement signUpPageHeader;
	
	
	
	
	public String ValidateSignUpPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateHeaderText()
	{
		return signUpPageHeader.isDisplayed();
	}
	

}
