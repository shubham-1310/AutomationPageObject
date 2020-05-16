package com.automation.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.Base;

public class LandingPage<WebElements> extends Base{
	
	WebDriver ldriver;
	
	public LandingPage(WebDriver rdriver)
	//here l for local and r for remote
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
//	public LandingPage() {
//		PageFactory.initElements(driver, this);	
//	}
	
	
	@FindBy(xpath="//a[@class='login']")
//	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
//	@CacheLookup
	WebElement siteLogo;
	
	@FindBy(xpath="//a[@class='sf-with-ul'][contains(text(),'Women')]")
//	@CacheLookup
	WebElement womentSection;
	
	@FindBy(xpath="//ul[@class='submenu-container clearfix first-in-line-xs']/li[1]/ul/li[1]")
//	@CacheLookup
	WebElement womentTshirt;
	
	
	
	

	
	
	

	
	public boolean checkLogo()
	{
		 return siteLogo.isDisplayed();
	}
	
	
	public String ValidateLandingPageTitle()
	{
		return ldriver.getTitle();
	}
	
	
	public LoginPage clickLoginButton()
	{
		loginButton.click();
		return new LoginPage(ldriver);
	}
	
	public void moveToWomenSection()
	{
		Actions a =new Actions(driver);
		Action ab= a.moveToElement(womentSection).build();
		ab.perform();
	}
	
	
	
	public void clickOnWomenTshirt()
	{
		womentTshirt.click();
	}
	


		
	}
	    
	
	
