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
import com.automation.qa.pages.SignUpPage;

public class SignUpPageTest extends Base {
	
	LandingPage landingPage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	
	public SignUpPageTest()
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
	public void enterNewEmailAddress() {
		
		loginPage.enterNewUserEmailId("shibham.shibu2@gmail.com");
		signUpPage=loginPage.clickCreateAnAccountButton();
		
	}
	@Test(priority=2)
	public void validateSignUpPageTitle() {
		
		String signUpPageTitle=signUpPage.ValidateSignUpPageTitle();
		Assert.assertEquals(signUpPageTitle, "Login - My Store");	
	}
	
	@Test(priority=3)
	public void validateSignUpPageHeaderText() {
		
		Assert.assertTrue(signUpPage.validateHeaderText());
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	}
	


