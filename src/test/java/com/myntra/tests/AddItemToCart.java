package com.myntra.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.pageObjects.CartPage;
import com.myntra.pageObjects.HomePage;
import com.myntra.pageObjects.PowerLookTShirt;
import com.myntra.pageObjects.TShirtsPage;
import com.myntra.utility.ConfigReader;

public class AddItemToCart extends BaseTest {
	ConfigReader configReaderObj = new ConfigReader();
	HomePage homePageObj;
	TShirtsPage tShirtsPageObj;
	PowerLookTShirt powerLookTShirtObj;
	CartPage cartPageObj;
	
	String browser = configReaderObj.getProperty("browser");
	boolean isHeadless = Boolean.parseBoolean(configReaderObj.getProperty("headless"));
	String website = configReaderObj.getProperty("URL");
	Map<String, String> tShirtDetails;
	Map<String, String> itemDetails;
	
	
	@Test
	public void testingWebsiteOnInputBrowser() throws InterruptedException {
		System.out.println("Browser: " + browser);
		System.out.printf("Headless Mode: %s\n", isHeadless? "ON" : "OFF");
		System.out.printf("Website: %s\n", website);
		
		driverObj = browserUtilsObj.lauchWebsiteByBrowser(browser, website, isHeadless);
		homePageObj = new HomePage(driverObj);
		tShirtsPageObj = new TShirtsPage(driverObj);
		powerLookTShirtObj = new PowerLookTShirt(driverObj);
		cartPageObj = new CartPage(driverObj);
		tShirtDetails = new HashMap<String, String>();
		itemDetails = new HashMap<String, String>();
		String itemName = "Powerlook Men Striped T Shirt" + Keys.ENTER;
		
		homePageObj.hoverMenOption();

		homePageObj.selectTshirtItems();
		
		homePageObj.searchBox(itemName);
		
		tShirtsPageObj.selectPowerLookTShirt();
		
		tShirtDetails = powerLookTShirtObj.getTShirtDetails();
		
		powerLookTShirtObj.addTShirtToCart();
		
		itemDetails = cartPageObj.getItemDetails();
		
		Assert.assertEquals(tShirtDetails, itemDetails, "Item and cart details do not match!");
		System.out.println("All details match successfully!");
		
	}


}
