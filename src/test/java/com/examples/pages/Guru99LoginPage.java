package com.examples.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	By seleniumDropdown = By.partialLinkText("Selenium");
	By tableDemo = By.linkText("Table Demo");
	By checkSiblings=By.xpath("//ul[@class='nav navbar-nav']/li[1]/ul/li[1]/following-sibling::li");
	By checkSeleniumDropDown=By.xpath("//ul[@class='nav navbar-nav']/li[1]/a[1]");
	//By clickTableDemo = By.xpath("//ul[@class='nav navbar-nav']/li[1]/ul/li[3]/a[contains(text(),'Table Demo')]");
	
	GlobalDataStore gds = new GlobalDataStore();
	WebDriver driverInstance;

	public static String LogCategory;
	public static Logger logger;
	public void setLogCategory(String LogFile) {

		LogCategory = LogFile;

		logger = Logger.getLogger(LogCategory);

	}
	
	public String getURL() {
		String currentUrl = driver.getCurrentUrl();
		logger.info("url " + currentUrl);
		return currentUrl;
	}
	
	public int getCountOfAllLinks(){
	     WebElement element= driver.FindElement(checkSeleniumDropDown);
	     
	     driver.clickElement(element);
	      List<WebElement>elements= driver.FindElements(checkSiblings);
	      System.out.println("The elements Size " +elements.size());
	      return elements.size();
	     
	    }
	public void clickSeleniumDropDown() {
		logger.info("clickSeleniumDropDown ");
		driver.clickElement(driver.FindElement(seleniumDropdown));
	}

	public String getHomePageDashboardName() {

		String HomePageName = driver.FindElement(homePageUserName).getText();
		logger.info("getHomePageDashboard " + HomePageName);
		Reporter.log(" getHomePageDashboard " + HomePageName, true);
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		// driver.FindElement(homePageUserName).click();
		return HomePageName;
	}

	public void setWebDriver(Guru99WebDriverImpl webDriver) {
		logger.info("setWebDriver ");
		this.driver = webDriver;

	}

	public void setUserName(String strUserName) {
		logger.info("setUserName " + strUserName);
		driver.FindElement(userName).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {
		logger.info("setPassword ");
		driver.FindElement(passwordGuru).sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {
		logger.info(" clickLogin ");
		Reporter.log("Guru99HomePage clickLogin ", true);
		driver.clickElement(driver.FindElement(login));

	}

	public void loginToGuru(String strUserName, String strPasword) {

		logger.info(" loginToGuru  ");
		Reporter.log("Guru99HomePage loginToGuru ", true);
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();

	}

	public void clickLogout() {
		logger.info(" clickLogout  ");
		Reporter.log("Guru99HomePage clickLogout ", true);
		driver.clickElement(driver.FindElement(logOut));
		driver.acceptPopAlert();

	}

	public boolean getLogoutButton() {

		boolean logoutEnabled = driver.FindElement(logOut).isEnabled();
		logger.info(" getLogoutButton enabled: " + logoutEnabled);
		Reporter.log("Guru99HomePage getlink is pressent : " + logoutEnabled, true);

		return logoutEnabled;
	}

	public boolean checkForStepsToGenerateAccess() {

		boolean stepsToGenerateEnabled = driver.FindElement(stepsToGenerateAccess).isEnabled();
		Reporter.log("Guru99HomePage StepsToGenerateAccess is pressent : " + stepsToGenerateEnabled, true);
		logger.info(" StepsToGenerateAccess is pressent : " + stepsToGenerateEnabled);
		return stepsToGenerateEnabled;
	}

	public void clickTableDemo() {
		logger.info("clickTableDemo");
		driver.clickElement(driver.FindElement(tableDemo));
	}

}
