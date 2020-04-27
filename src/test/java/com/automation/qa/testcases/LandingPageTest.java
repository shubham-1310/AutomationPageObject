package com.automation.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.qa.base.Base;
import com.automation.qa.pages.LandingPage;
import com.automation.qa.pages.LoginPage;

public class LandingPageTest extends Base {
	
	LandingPage landingPage;
	LoginPage loginPage;
	public LandingPageTest()
	{
		super();// This statement will call the constructor of Base class which initializes property file
	}
	
	
	@BeforeClass
	public void setup() throws IOException 
	{
		initializeDriver();
	    landingPage = new LandingPage(driver);
	
	}
	
	
	@Test(priority=1)
	public void landingPageTitleTest()
	{
		String title = landingPage.ValidateLandingPageTitle();
		
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority=2)
	public void siteLogoTest() {
	boolean flag=landingPage.checkLogo();
	Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginClick() {
	loginPage=landingPage.clickLoginButton();
	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
