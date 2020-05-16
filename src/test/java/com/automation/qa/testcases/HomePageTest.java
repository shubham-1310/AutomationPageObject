package com.automation.qa.testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.qa.base.Base;
import com.automation.qa.pages.HomePage;
import com.automation.qa.pages.LandingPage;
import com.automation.qa.pages.LoginPage;
import com.automation.qa.pages.MyAccountsPage;

public class HomePageTest extends Base {
	
	LandingPage landingPage;
	LoginPage loginPage;
	MyAccountsPage mapp;
	HomePage homePage;
	String url;
	HttpURLConnection huc = null;
    int respCode = 200;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeClass
	public void setup() throws IOException
	{
		initializeDriver();
		landingPage = new LandingPage(driver);
		loginPage= landingPage.clickLoginButton();
		loginPage.enterEmailId(emailAddress);
		loginPage.enterpwd(password);
		mapp=loginPage.clickLoginButton();;
		homePage=mapp.clickBottomHomeButton();
	}
	
	@Test(priority=1)
	public void validateHomePageLogo()
	{
	Assert.assertTrue(homePage.checkLogo());
	}
	
	
	
	@Test(priority=2)
	public void validateContatNumber() throws InterruptedException
	{
		Assert.assertEquals(homePage.validateContactNumber(), "0123-456-789");
		
		Thread.sleep(5000);
		
	}
	
	@Test(priority=3, enabled=false)
	public void validateBrokenLinksTest() throws InterruptedException
	{
		 List links=homePage.linksOnHomePage();
		 Thread.sleep(4000);
		 System.out.println("Number of links on page " +links.size());
		 Iterator<WebElement> it = links.iterator();
		 while(it.hasNext()){
	            
	            url = it.next().getAttribute("href");
	            
//	            System.out.println(url);
	            if(url == null || url.isEmpty()){
//	            	System.out.println("URL is either not configured for anchor tag or it is empty");
	            	                continue;
	            	            }
//	            	            
//	            	            if(!url.startsWith("Automation")){
//	            	                System.out.println("URL belongs to another domain, skipping it.");
//	            	                continue;
//	            	            }
	            	            
	            	            try {
	            	                huc = (HttpURLConnection)(new URL(url).openConnection());
	            	                
	            	                huc.setRequestMethod("HEAD");
	            	                
	            	                huc.connect();
	            	                
	            	                respCode = huc.getResponseCode();
	            	                
	            	                if(respCode >= 400){
	            	                    System.out.println(url+" is a broken link");
	            	                }
	            	                else{
	            	                    System.out.println(url+" is a valid link");
	            	                }
	            	                    
	            	            } catch (MalformedURLException e) {
	            	                // TODO Auto-generated catch block
	            	                e.printStackTrace();
	            	            } catch (IOException e) {
	            	                // TODO Auto-generated catch block
	            	                e.printStackTrace();
	            	            }
	            	        }        	        
	}
		 
	

	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
