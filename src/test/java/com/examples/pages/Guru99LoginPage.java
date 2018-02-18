package com.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru99.framework.Guru99WebDriverImpl;
import com.examples.config.GlobalDataStore;

public class Guru99LoginPage {

	Guru99WebDriverImpl driver;
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By stepsToGenerateAccess = By.xpath("//h4[@class='barone']");
	By linkTest = By.linkText("here");
	By loginButtonTest = By.xpath("//input[@name='btnLogin']");
	By resetButtonTest = By.xpath("//input[@name='btnReset']");

	By userName = By.xpath("//input[@name='uid']");

	By passwordGuru = By.name("password");
	By login = By.name("btnLogin");
	By logOut = By.linkText("Log out");

	GlobalDataStore gds = new GlobalDataStore();
	WebDriver driverInstance;

	public String getHomePageDashboardName() {

		System.out.println("comming here");
		Reporter.log("Guru99HomePage getHomePageDashboard " + driver.FindElement(homePageUserName).getText(), true);
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		// driver.FindElement(homePageUserName).click();
		return driver.FindElement(homePageUserName).getText();
	}

	public void setWebDriver(Guru99WebDriverImpl webDriver) {

		this.driver = webDriver;

	}

	public void setUserName(String strUserName) {
		driver.FindElement(userName).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.FindElement(passwordGuru).sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		// driver.FindElement(login).click();
		driver.clickElement(driver.FindElement(login));

	}

	public void loginToGuru(String strUserName, String strPasword) {

		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();

	}

	public void clickLogout() {

		// driver.FindElement(logOut).click();
		driver.clickElement(driver.FindElement(logOut));
		driver.acceptPopAlert();

	}
	
	public boolean getLogoutButton() {

		System.out.println("comming here");
		Reporter.log("Guru99HomePage getlink is pressent : " + driver.FindElement(logOut).isEnabled(), true);
	
		return driver.FindElement(logOut).isEnabled();
	}
	
	public boolean checkForStepsToGenerateAccess() {

		System.out.println("comming here");
		Reporter.log("Guru99HomePage StepsToGenerateAccess is pressent : " + driver.FindElement(stepsToGenerateAccess).isEnabled(), true);
	
		return driver.FindElement(stepsToGenerateAccess).isEnabled();
	}


}
