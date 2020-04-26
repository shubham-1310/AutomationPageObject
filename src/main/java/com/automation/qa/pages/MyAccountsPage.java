package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
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
	
	public String ValidateMyAccountsPageTitle()
	{
		return driver.getTitle();
	}

}
