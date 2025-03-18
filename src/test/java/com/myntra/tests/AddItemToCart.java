package com.myntra.tests;

import org.testng.annotations.Test;

import com.myntra.pageObjects.HomePage;
import com.myntra.utility.ConfigReader;

public class AddItemToCart extends BaseTest {
	ConfigReader configReaderObj = new ConfigReader();
	HomePage homePageObj;
	
	String browser = configReaderObj.getProperty("browser");
	boolean isHeadless = Boolean.parseBoolean(configReaderObj.getProperty("headless"));
	String website = configReaderObj.getProperty("URL");
	
	
	@Test
	public void testingWebsiteOnInputBrowser() throws InterruptedException {
		System.out.println("Browser: " + browser);
		System.out.printf("Headless Mode: %s\n", isHeadless? "ON" : "OFF");
		System.out.printf("Website: %s\n", website);
		driverObj = browserUtilsObj.lauchWebsiteByBrowser(browser, website, isHeadless);
		homePageObj = new HomePage(driverObj);
		homePageObj.hoverMenOption();
		Thread.sleep(5000);
	}


}
