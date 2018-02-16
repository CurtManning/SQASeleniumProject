package com.guru99.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public interface Guru99WebDriver {
	void init(String Browser);
	Boolean navigateTo(final String relativeURL);
	 void sendKeys(WebElement element, String name);
	   
	   void clickElement(WebElement element);
	 
	 
	   WebElement FindElement(By element );
	    /**
	     * Quits the web driver.
	     */
	    void quitDriver();
	
	    //closes browser window    
	    void closeBrowser();
}
