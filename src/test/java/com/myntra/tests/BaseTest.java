package com.myntra.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myntra.utility.BrowserUtils;

public class BaseTest {
	
	protected WebDriver driverObj;
	
	BrowserUtils browserUtilsObj;
		
	@BeforeMethod
	public void doBeforeTest() {
		System.out.println("**************************************************");
		System.out.println("-------------Test Execution Started---------------");
		System.out.println("--------------------------------------------------");
		browserUtilsObj = new BrowserUtils(driverObj);
	}
	
	@AfterMethod
	public void doAfterTest() {
		browserUtilsObj.quitBrowser();
		System.out.println("--------------------------------------------------");
		System.out.println("-----------Test Execution Completed---------------");
		System.out.println("**************************************************");
	}

}
