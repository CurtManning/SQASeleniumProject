package com.examples.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.guru99.framework.Guru99WebDriverImpl;
import com.examples.config.GlobalDataStore;
public class Guru99HomePage {

	Guru99WebDriverImpl driver;
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By StepsToGenerateAccess=By.xpath("//h4[@class='barone']");
	
	GlobalDataStore gds=new GlobalDataStore();
	WebDriver driverInstance;

	public void setWebDriver(Guru99WebDriverImpl webDriver) {

		this.driver = webDriver;
		// Log.info("END: Set TMXDriver Method");

	}

	public String getHomePageDashboardUserName() {

		System.out.println("comming here");
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		// driver.FindElement(homePageUserName).click();
		return driver.FindElement(homePageUserName).getText();
	}

}
