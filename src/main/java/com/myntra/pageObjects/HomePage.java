package com.myntra.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.utility.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driverObj) {
		super(driverObj);
	}
	
	@FindBy(xpath="//a[text()=\"Men\" and @data-group=\"men\"]")
	private WebElement menCategory;
	
	@FindBy(xpath="//a[@href=\"/men-tshirts\"]")
	private WebElement tshirtItems;
	
	
	@FindBy(xpath="//input[@class=\"desktop-searchBar\"]")
	private WebElement searchBox;

	public void searchBox(String itemName) {
		sendDataToElement(searchBox, itemName);
		System.out.println("Searched Item");
	}
	
	public void hoverMenOption() {
		hoverOnElement(menCategory);
		System.out.println("Hovered On Men Category");
	}
	
	public void selectTshirtItems() {
		clickElement(tshirtItems);
		System.out.println("Selected T-Shirt Items");
	}
}
