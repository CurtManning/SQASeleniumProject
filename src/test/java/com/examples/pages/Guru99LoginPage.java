package com.examples.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.guru99.framework.Guru99WebDriverImpl;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
	By logOut = By.linkText("Log1out");    // Change "log out" to "log1out" to test screenprints 
	By seleniumDropdown = By.partialLinkText("Selenium");
	By tableDemo = By.linkText("Table Demo");
	By checkSiblings = By.xpath("//ul[@class='nav navbar-nav']/li[1]/ul/li[1]/following-sibling::li");
	By checkSeleniumDropDown = By.xpath("//ul[@class='nav navbar-nav']/li[1]/a[1]");
	// By clickTableDemo = By.xpath("//ul[@class='nav
	// navbar-nav']/li[1]/ul/li[3]/a[contains(text(),'Table Demo')]");
	By getUserId = By.xpath("//form/table/tbody/tr[1]/td[1]");
	By checkStepsToGenerateAccess = By
			.xpath("//form[@name='frmLogin']/following-sibling::h4/span[text()='Steps To Generate Access']");
	By loginPageList = By.xpath("//h4[@class='barone']/following-sibling::div/*/li");
	By loginReset = By
			.xpath("//td[contains(text(),'UserID')]//parent::tr/following-sibling::tr//input[contains(@name, 'btn')]");
	GlobalDataStore gds = new GlobalDataStore();
	WebDriver driverInstance;

	public static String LogCategory;
	public static Logger logger;
	public ExtentTest test;

	public void setExtentReports(ExtentTest test) {

		this.test = test;

	}

	public void setLogCategory(String LogFile) {

		LogCategory = LogFile;

		logger = Logger.getLogger(LogCategory);

	}

	public int getLoginReset() {
		List<WebElement> lrElements = driver.FindElements(loginReset);
		return lrElements.size();
	}

	public int getLoginPageList() {
		List<WebElement> elements = driver.FindElements(loginPageList);
		return elements.size();
	}

	public boolean ckForStepsToGenerateAccess() {
		boolean ckstepsToGenerateEnabled = driver.FindElement(checkStepsToGenerateAccess).isEnabled();
		Reporter.log("Guru99HomePage ckForStepsToGenerateAccess is pressent : " + ckstepsToGenerateEnabled, true);
		logger.info(" ckForStepsToGenerateAccess is pressent : " + ckstepsToGenerateEnabled);
		return ckstepsToGenerateEnabled;
	}

	public String getUserID() {
		String usrId = driver.FindElement(getUserId).getText();
		logger.info("userId " + usrId);
		return usrId;
	}

	public String getURL() {
		String currentUrl = driver.getCurrentUrl();
		logger.info("url " + currentUrl);
		return currentUrl;
	}

	public int getCountOfAllLinks() {
		WebElement element = driver.FindElement(checkSeleniumDropDown);

		driver.clickElement(element);
		List<WebElement> elements = driver.FindElements(checkSiblings);
		System.out.println("The elements Size " + elements.size());
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

		boolean logoutEnabled;

		try {

			logoutEnabled = driver.FindElement(logOut).isEnabled();
			if (logoutEnabled) {
				logger.info(" getLogoutButton enabled: " + logoutEnabled);
				Reporter.log("Guru99HomePage getlink is pressent : " + logoutEnabled, true);
				test.log(LogStatus.PASS, "Verified logout button linkText Log Out");
			}

		} catch (NoSuchElementException e) {
			logoutEnabled = false;
			System.out.println(e.getMessage());
			logger.info("getLogoutButton Can't find linkText Log Out: NoSuchElementException: " + e.getMessage());
			Reporter.log("Guru99HomePage getLogoutButton Can't find linkText Log Out: NoSuchElementException: : " + logoutEnabled, true);
			test.log(LogStatus.FAIL, "Can't find logout button linkText Log Out");
		}

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

	public void checkClickableLinks() {
		test.log(LogStatus.INFO, "checkClickableLinks");
		List<WebElement> linksList = clickableLinks();
		for (WebElement link : linksList) {
			String href = link.getAttribute("href");
			try {
				String message = "URL " + href + " returned " + linkStatus(new URL(href));
				logger.info(message);
				Reporter.log(message, false);
			} catch (Exception e) {
				logger.info(e.getMessage());
				Reporter.log(e.getMessage(), false);
			}
		}
	}

	public List<WebElement> clickableLinks() {
		test.log(LogStatus.INFO, "clickableLinks");
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.FindElements(By.tagName("a"));
		elements.addAll(driver.FindElements(By.tagName("img")));

		for (WebElement e : elements) {
			if (e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}

	public String linkStatus(URL url) {
		// http://download.java.net/jdk7/archive/b123/docs/api/java/net/HttpURLConnection.html#getResponseMessage%28%29
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	//

}
