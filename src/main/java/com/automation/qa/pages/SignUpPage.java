package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.qa.base.Base;

public class SignUpPage extends Base {
	
	WebDriver ldriver;
	
	

	public SignUpPage(WebDriver rdriver)
	//here l for local and r for remote
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
//	public SignUpPage() {
//		PageFactory.initElements(driver, this);	
//	}
//	
	@FindBy(xpath="//h1[@class='page-heading']")
	@CacheLookup
	WebElement signUpPageHeader;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	@CacheLookup
	WebElement titleMrRadionButton;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	@CacheLookup
	WebElement titleMrsRadionButton;
	
	@FindBy(id="customer_firstname")
	@CacheLookup
	WebElement enterCustomerFirstName;
	
	@FindBy(id="customer_lastname")
	@CacheLookup
	WebElement enterCustomerLastName;
	
	@FindBy(id="passwd")
	@CacheLookup
	WebElement enterCustomerPassword;
	
	@FindBy(id="days")
	@CacheLookup
	WebElement dateOfBirth;
	
	@FindBy(id="months")
	@CacheLookup
	WebElement monthOfBirth;
	
	@FindBy(id="years")
	@CacheLookup
	WebElement yearOfBirth;
	
	@FindBy(id="address1")
	@CacheLookup
	WebElement addressL1;
	
	@FindBy(id="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(id="id_state")
	@CacheLookup
	WebElement state;
	
	@FindBy(id="postcode")
	@CacheLookup
	WebElement postalcode;
	
	@FindBy(id="id_country")
	@CacheLookup
	WebElement country;
	
	@FindBy(id="phone_mobile")
	@CacheLookup
	WebElement mobileNum;
	
	@FindBy(id="alias")
	@CacheLookup
	WebElement addressAlias;
	
	@FindBy(id="submitAccount")
	@CacheLookup
	WebElement registerButton;
	
	
	
	public String ValidateSignUpPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public boolean validateHeaderText()
	{
		return signUpPageHeader.isDisplayed();
	}
	
	public void selectTitleMr()
	{
		titleMrRadionButton.click();
	}
	
	public void selectTitleMrs()
	{
		titleMrsRadionButton.click();
	}
	
	public void enterCustomerFirstName(String firstname)
	{
		enterCustomerFirstName.sendKeys(firstname);
	}
	
	public void enterCustomerLastName(String lastname)
	{
		enterCustomerLastName.sendKeys(lastname);
	}
	
	public void enterCustomerPassword(String password)
	{
		enterCustomerPassword.sendKeys(password);
	}

	public void selectDateOfBirth(String day)
	{
		Select d = new Select(dateOfBirth);
		d.selectByValue(day);
	}
	
	public void selectMonthOfBirth(String month)
	{
		Select m = new Select(monthOfBirth);
		m.selectByValue(month);
	}
	
	public void selectYearOfBirth(String year)
	{
		Select y = new Select(yearOfBirth);
		y.selectByValue(year);
	}
	public void enterAddressL1(String addressLine1)
	{
		addressL1.sendKeys(addressLine1);
	}
	
	public void enterCity(String cityL1)
	{
		city.sendKeys(cityL1);
	}
	
	public void selectState(String stateName)
	{
		Select st = new Select(state);
		st.selectByVisibleText(stateName);
		
	}
	
	public void enterPostalCode(String postalCode)
	{
		postalcode.sendKeys(postalCode);
	}
	
	public void selectCountry(String countryName)
	{
		Select cn = new Select(country);
		cn.selectByVisibleText(countryName);
	}
	
	public void enterMobileNum(String mobileNumber)
	{
		mobileNum.sendKeys(mobileNumber);
	}
	
	public void enterAddressReference(String aliasNameForAddress)
	{
		addressAlias.sendKeys(aliasNameForAddress);
	}
	
	public MyAccountsPage registerButtonClick()
	{
		registerButton.click();
		return new MyAccountsPage(ldriver);
	}
	
	
	
}
