package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.Base;

public class MyAccountsPage extends Base{
	
	

	WebDriver ldriver;
	
	

	public MyAccountsPage(WebDriver rdriver)
	//here l for local and r for remote
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
	@CacheLookup
	WebElement fullName;
	
	
	
	
	
	
	
	public String ValidateMyAccountsPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public String ValidateUserFullName()
	{
		return fullName.getText();
	}
	
	

}
