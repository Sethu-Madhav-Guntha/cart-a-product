package com.myntra.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.utility.BasePage;

public class TShirtsPage extends BasePage {
	
	public TShirtsPage(WebDriver driverObj) {
		super(driverObj);
	}
	
	@FindBy(xpath="//li[@id=\"30723226\"]//a[contains(@href,\"30723226\")]")
	private WebElement powerLookTShirt;
	
	public void selectPowerLookTShirt() {
		clickElement(powerLookTShirt);
		System.out.println("Selected PowerLook T-Shirt");
	}
}
