package com.myntra.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.utility.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driverObj) {
		super(driverObj);
	}
	
	@FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/nav/div/div[1]/div/a")
	private WebElement menOption;
	
	public void hoverMenOption() {
		hoverOnElement(menOption);
	}
}
