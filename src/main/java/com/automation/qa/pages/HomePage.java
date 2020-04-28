package com.automation.qa.pages;


import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.Base;

public class HomePage<WebElements> extends Base{
	
//	WebDriver ldriver;
//	
//	public HomePage(WebDriver rdriver)
//	//here l for local and r for remote
//	{
//		ldriver=rdriver;
//		PageFactory.initElements(rdriver, this);
//
//	}
	
	public HomePage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	@CacheLookup
	WebElement homePageLogo;
	
	@FindBy(xpath="//strong[contains(text(),'0123-456-789')]")
	@CacheLookup
	WebElement callNumber;
	
	@FindBy(xpath="//a")
	@CacheLookup
	List<WebElement>linksOnHomePage;
	
	

	
	public boolean checkLogo()
	{
		 return homePageLogo.isDisplayed();
	}
	
	
	public String validateContactNumber()
	{
		return callNumber.getText();
	}
	
	public List<WebElement> linksOnHomePage() {
		return linksOnHomePage;
		
	}
	
	
	
	
}
