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

public class LoginPageTest extends Base {
	
	LandingPage landingPage;
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup() throws IOException
	{
		initializeDriver();
		landingPage = new LandingPage(driver);
		loginPage= landingPage.clickLoginButton();
		
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
	String title=loginPage.ValidateLoginPageTitle();
	Assert.assertEquals(title, "Login - My Store");	
	}
	
	
	
	@Test(priority=2)
	public void enterEmailid()
	{
		loginPage.enterEmailId(emailAddress);
		
	}
	
	@Test  (priority=3)
	public void enterPassword()
	{
		loginPage.enterpwd(password);
		
	}
	@Test  (priority=4)
	public void clickSignButton()
	{
		loginPage.clickLoginButton();
		
	}
	
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
