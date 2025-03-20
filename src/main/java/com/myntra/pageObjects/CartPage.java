package com.myntra.pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.myntra.utility.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driverObj) {
		super(driverObj);
	}

	@FindBy(xpath="//a[@class=\"itemContainer-base-itemLink\"]")
	private WebElement itemName;
	
	@FindBy(xpath="//div[@class=\"itemContainer-base-brand\"]")
	private WebElement itemTitle;
	
	@FindBy(xpath="//div[@class=\"itemComponents-base-price itemComponents-base-bold \"]/div")
	private WebElement itemPrice;
	
	@FindBy(xpath="//div[@class=\"itemComponents-base-size\"]")
	private WebElement itemSize;

	private String getItemName() {
		return getElementText(itemName);
	}
	
	private String getItemTitle() {
		return getElementText(itemTitle);
	}

	private String getItemPrice() {
		return getElementText(itemPrice);
	}
	
	private String getItemSize() {
		String text = getElementText(itemSize);
		String itemSize = text.split(": ")[1];
		return itemSize;
	}

	
	public Map<String, String> getItemDetails() {
		System.out.println("Item Details at Item Page");
		System.out.printf("Item Name: %s\n",getItemName());
		System.out.printf("Item Title: %s\n",getItemTitle());
		System.out.printf("Item Price: %s\n",getItemPrice());
		System.out.printf("Item Size: %s\n",getItemSize());
	
		Map<String, String> itemDetails = new HashMap<String, String>();
		itemDetails.put("name", getItemName());
		itemDetails.put("title", getItemTitle());
		itemDetails.put("price", getItemPrice());
		itemDetails.put("size", getItemSize());

		System.out.println(itemDetails);
		System.out.println("Displayed Item Details");

		return itemDetails;
	}

}
