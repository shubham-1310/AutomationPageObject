package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement signUpPageHeader;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement titleMrRadionButton;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement titleMrsRadionButton;
	
	@FindBy(id="customer_firstname")
	WebElement enterCustomerFirstName;
	
	@FindBy(id="customer_lastname")
	WebElement enterCustomerLastName;
	
	@FindBy(id="passwd")
	WebElement enterCustomerPassword;
	
	@FindBy(id="days")
	WebElement dateOfBirth;
	
	@FindBy(id="months")
	WebElement monthOfBirth;
	
	@FindBy(id="years")
	WebElement yearOfBirth;
	
	
	
	
	
	
	
	
	
	
	public String ValidateSignUpPageTitle()
	{
		return driver.getTitle();
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
}
