package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.Base;

public class LoginPage extends Base {
WebDriver ldriver;
	
	
	public LoginPage(WebDriver rdriver)
	//here l for local and r for remote
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="passwd")
	WebElement pwd;
	
	@FindBy(xpath="//p[@class='submit']//span[1]")
	WebElement loginButton;
		
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	WebElement invalidEmailText;
	
	@FindBy(id="email_create")
	WebElement newUserEmailId;
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccountButton;
	
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void enterEmailId(String email)
	{
		emailId.sendKeys(email);
	}
	
	public void enterpwd(String password)
	{
		pwd.sendKeys(password);
	}
	
	public MyAccountsPage clickLoginButton()
	{
		loginButton.click();
		return new MyAccountsPage(ldriver);
		
	}
	
	public boolean invalidEmailText()
	{
		return invalidEmailText.isDisplayed();
	}
	
	public void enterNewUserEmailId(String newEmail)
	{
		newUserEmailId.sendKeys(newEmail);
	}
	
	public SignUpPage clickCreateAnAccountButton()
	{
		createAnAccountButton.click();
		return new SignUpPage(ldriver);
	
	}
	
	

}
