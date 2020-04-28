package com.automation.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.automation.qa.util.TestUtil;
import com.automation.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public static WebDriver driver;
	public static String emailAddress;
	public static String password;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public Base() 
	{
		prop = new Properties();	
		
		try 
		{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\automation\\qa\\config\\config.properties");
		prop.load(fis);

		
			
			FileInputStream fiss = new FileInputStream(System.getProperty("user.dir") +"/src/main/java/com/automation/qa/config/config.properties");
			prop.load(fiss);

			}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
			
	}
		
		public void initializeDriver() throws IOException
		{
		String browserName=prop.getProperty("browser");
		emailAddress=prop.getProperty("email");
		password=prop.getProperty("password");
		
		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
	        driver =new ChromeDriver();
	      
		}
		else if (browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
	        driver =new FirefoxDriver();
	       
		}
		else if (browserName.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
	        driver =new InternetExplorerDriver();
	       
		}
		else if (browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
	        driver =new EdgeDriver();
	       
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	    
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		
			
		
		}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
