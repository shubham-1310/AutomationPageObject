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
import com.automation.qa.util.TestUtil;

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
		
		loginPage.enterNewUserEmailId(TestUtil.randomestring()+TestUtil.randomeNum()+".@gmail.com");
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
	
	@Test(priority=4)
	public void customertitleSelectMale()
	{
		signUpPage.selectTitleMr();
	}
	
	@Test(priority=5)
	public void enterCustomerFirstName()
	{
		signUpPage.enterCustomerFirstName(TestUtil.randomestring());
	}
	
	@Test(priority=6)
	public void enterCustomerLastName()
	{
		signUpPage.enterCustomerLastName(TestUtil.randomestring());
	}
	
	@Test(priority=7)
	public void enterCustomerPassword()
	{
		signUpPage.enterCustomerPassword(TestUtil.randomeNum()+TestUtil.randomestring());;
	}
	
	@Test(priority=8)
	public void enterDateOfBirth()
	{
		signUpPage.selectDateOfBirth("1");
	}
	
	@Test(priority=9)
	public void enterMonthOfBirth()
	{
		signUpPage.selectMonthOfBirth("1");
	}
	
	@Test(priority=10)
	public void enterYearOfBirth()
	{
		signUpPage.selectYearOfBirth("1990");
	}
	
	
	

//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	
	}
	


