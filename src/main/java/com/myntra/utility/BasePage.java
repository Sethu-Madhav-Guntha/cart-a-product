package com.myntra.utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
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
	protected JavascriptExecutor javascriptExecutorObj = (JavascriptExecutor) driverObj;
	protected ConfigReader configReaderObj = new ConfigReader();
		
	public BasePage(WebDriver driverObj) {
		this.driverObj = driverObj;
		int waitTime = Integer.parseInt(configReaderObj.getProperty("explicit.wait"));
		this.wait = new WebDriverWait(driverObj, Duration.ofSeconds(waitTime));
		PageFactory.initElements(driverObj, this);
	}

	public WebElement isElementVisible(WebElement element) {		
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement highLightElement(WebElement element) {
		element = isElementVisible(element);
		javascriptExecutorObj = (JavascriptExecutor) driverObj;
		javascriptExecutorObj.executeScript("arguments[0].style.border='2px solid red'", element);
		return element;
	}
		
	public void hoverOnElement(WebElement element) {
		highLightElement(element);
		actionsObj = new Actions(driverObj);
		actionsObj.moveToElement(element).perform();		
	}
	
	public String getElementText(WebElement element) {
		return highLightElement(element).getText();
	}
	
	public void clickElement(WebElement element) {
		highLightElement(element).click();
    }

    public void sendDataToElement(WebElement element, String text) {
    	highLightElement(element).sendKeys(text);
    }
}
