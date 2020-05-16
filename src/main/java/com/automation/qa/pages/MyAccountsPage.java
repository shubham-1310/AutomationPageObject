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
	
//	public MyAccountsPage() {
//		PageFactory.initElements(driver, this);	
//	}
	
	@FindBy(xpath="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
	@CacheLookup
	WebElement fullName;
	
	@FindBy(xpath="//span[contains(text(),'Home')]	")
	@CacheLookup
	WebElement bottomHomeButton;
	
	
	
	
	
	
	
	public String ValidateMyAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	public String ValidateUserFullName()
	{
		return fullName.getText();
	}
	
	public HomePage clickBottomHomeButton()
	{
		bottomHomeButton.click();
		return new HomePage(ldriver);
	}
	
	

}
