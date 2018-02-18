package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99LoginPage;
import com.examples.pages.Guru99ManagerHomePage;

import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

public class Test99GuruLoginPage {

	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
	String BankHomePage;
	String Username;
	String Psswd;
	String GecKoDriver;

	String HomePage;
	Boolean HomePageLaunch = false;
	Guru99ManagerHomePage objManagerHomePage;
	Guru99LoginPage objHomePage;

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) {

		gds.initParameters();
		// calls the init Method in getWebDriverInstance and gets the WebDriverImpl
		// Object driver..

		driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		BankHomePage = GlobalDataStore.Guru99HomePage;
		Username = GlobalDataStore.UserName;
		Psswd = GlobalDataStore.Password;
		HomePageLaunch = driver.navigateTo(BankHomePage);

		objHomePage = new Guru99LoginPage();
		objHomePage.setWebDriver(driver);

		
	}

	
	@Test
	public void test_Log_In() {

		if (HomePageLaunch == true) {
			String loginPageTitle = objHomePage.getHomePageDashboardName();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
			System.out.println(" The login Title " + loginPageTitle);

	
		    //login to application
			objHomePage.loginToGuru(Username, Psswd);
			Assert.assertTrue(objHomePage.getLogoutButton());
			objHomePage.clickLogout();
		//Assert.assertTrue(objHomePage.getLogoutButton());

		}

	}
	
	@Test
	public void test_Logout() {

		if (HomePageLaunch == true) {
			String loginPageTitle = objHomePage.getHomePageDashboardName();
			System.out.println(" The login Title " + loginPageTitle);

			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
	

		    //login to application
			objHomePage.loginToGuru(Username, Psswd);
			
			objHomePage.clickLogout();
			Assert.assertTrue(objHomePage.checkForStepsToGenerateAccess());
		
		}

	}

	@AfterClass
	public void afterClass( ) {
		// Close
		this.driver.quitDriver();
	}
}
