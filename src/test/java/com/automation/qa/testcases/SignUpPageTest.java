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
import com.automation.qa.pages.MyAccountsPage;
import com.automation.qa.pages.SignUpPage;
import com.automation.qa.util.TestUtil;

public class SignUpPageTest extends Base {
	
	LandingPage landingPage;
	LoginPage loginPage;
	SignUpPage signUpPage;
	MyAccountsPage map;
	String fName;
    String lName;
	String fullName;
	
	
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
		fName= TestUtil.randomestring();
		signUpPage.enterCustomerFirstName(fName);
	}
	
	@Test(priority=6)
	public void enterCustomerLastName()
	{
		lName=TestUtil.randomestring();
		signUpPage.enterCustomerLastName(lName);
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
	
	@Test(priority=11)
	public void enterAddressLine1()
	{
		signUpPage.enterAddressL1(TestUtil.randomestring()+ ", "+ TestUtil.randomeNum());
	}
	
	@Test(priority=12)
	public void enterCityName()
	{
		signUpPage.enterCity(TestUtil.randomestring());
	}
	
	@Test(priority=13)
	public void enterStateName()
	{
		signUpPage.selectState("New York");
	}
	
	@Test(priority=14)
	public void selectCountryName()
	{
		signUpPage.selectCountry("United States");
		
	}
	
	@Test(priority=15)
	public void enterPostalCode()
	{
		signUpPage.enterPostalCode("12345");
	}
	
	@Test(priority=16)
	public void enterMobileNumber()
	{
		signUpPage.enterMobileNum("2341546"+TestUtil.randomeNum());
	}
	
	@Test(priority=17)
	public void addressReferenceName()
	{
		signUpPage.enterAddressReference(TestUtil.randomestring()+TestUtil.randomestring());
	}
	
	@Test(priority=18)
	public void clickOnRegisterButton()
	{
		map=signUpPage.registerButtonClick();
	}
	
	@Test(priority=19)
	public void testTileOfMyAccountsPage()
	{
		String mapTitle=map.ValidateMyAccountsPageTitle();
		Assert.assertEquals(mapTitle, "My account - My Store");
	}
	@Test(priority=20)
	public void validateUserName()
	{
		fullName = fName+" "+lName;
		System.out.println(fullName);
		Assert.assertEquals( fullName, map.ValidateUserFullName());
		
	}
	
 
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	}
	


