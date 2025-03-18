package com.myntra.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driverObj;
	protected WebDriverWait wait;
	protected Actions actionsObj;
	ConfigReader configReaderObj = new ConfigReader();
	
	public BasePage(WebDriver driverObj) {
		this.driverObj = driverObj;
		int waitTime = Integer.parseInt(configReaderObj.getProperty("explicit.wait"));
		this.wait = new WebDriverWait(driverObj, Duration.ofSeconds(waitTime));
		PageFactory.initElements(driverObj, this);
	}

	public void hoverOnElement(WebElement element) {
//		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(element);
		actionsObj = new Actions(driverObj);
		actionsObj.moveToElement(element).perform();
		
	}
		
	public String getElementText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}
	
	public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendDataToElement(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
}
