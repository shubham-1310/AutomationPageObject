package com.automation.qa.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.Select;

import com.automation.qa.base.Base;

public class TestUtil extends Base {
	
	public static long page_Load_Timeout=20;
	public static long implicit_Wait=10;
	
	public static String randomestring() 
	{
	String generatedString= RandomStringUtils.randomAlphabetic(5);	
	return generatedString;
	}
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(3);
		return (generatedString2);
	}
	
	

}
