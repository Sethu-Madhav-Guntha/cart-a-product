package com.myntra.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.utility.BasePage;

public class PowerLookTShirt extends BasePage {

	public PowerLookTShirt(WebDriver driverObj) {
		super(driverObj);
	}
	
	@FindBy(xpath="//h1[@class=\"pdp-name\"]")
	private WebElement tShirtName;
	
	@FindBy(xpath="//h1[@class=\"pdp-title\"]")
	private WebElement tShirtTitle;
	
	@FindBy(xpath="//span[@class=\"pdp-price\"]//strong")
	private WebElement tShirtPrice;
	
	@FindBy(xpath="//p[@class='size-buttons-unified-size' and text()=\"M\"]")
	private WebElement tShirtSize;
		
	@FindBy(xpath="//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")
	private WebElement addToCart;
	
	@FindBy(xpath="//p[text()=\"Added to bag\"]")
	private WebElement notification;
	
	@FindBy(xpath="//div[@class!=\"desktop-actions\"]/a[@href=\"/checkout/cart\"]")
	private WebElement goToBag;
	
	
	private String getTShirtName() {
		return getElementText(tShirtName);
	}
	
	private String getTShirtTitle() {
		return getElementText(tShirtTitle);
	}

	private String getTShirtPrice() {
		return getElementText(tShirtPrice).replaceAll("\\D+", "");
	}
	
	private void selectTShirtSize() {
		boolean isSizeAvailable = isElementVisible(tShirtSize).isEnabled();
		if(isSizeAvailable){
			clickElement(tShirtSize);
		}
	}
	
	private String getSelectedTShirtSize() {
		return getElementText(tShirtSize).split("\n")[0].trim();
	}
	
	public Map<String, String> getTShirtDetails() {
		List<String> handles = new ArrayList<>(driverObj.getWindowHandles());
		driverObj.switchTo().window(handles.get(1));	
		
		selectTShirtSize();
		System.out.println("selected size");

		System.out.println("T-Shirt Details at Cart Page");
		System.out.printf("T-Shirt Name: %s\n",getTShirtName());
		System.out.printf("T-Shirt Title: %s\n",getTShirtTitle());
		System.out.printf("T-Shirt Price: %s\n",getTShirtPrice());
		System.out.printf("T-Shirt Size: %s\n",getSelectedTShirtSize());
	
		Map<String, String> tShirtDetails = new HashMap<String, String>();
		tShirtDetails.put("name", getTShirtName());
		tShirtDetails.put("title", getTShirtTitle());
		tShirtDetails.put("price", getTShirtPrice());
		tShirtDetails.put("size", getSelectedTShirtSize());

		System.out.println(tShirtDetails);
		System.out.println("Displayed T-Shirt Details");

		return tShirtDetails;
	}
	
	public void addTShirtToCart() {
		clickElement(tShirtName);
		clickElement(addToCart);
		clickElement(goToBag);		
		System.out.println("Added Item to Cart");
	}
}
