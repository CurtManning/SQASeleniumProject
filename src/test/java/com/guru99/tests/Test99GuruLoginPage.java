package com.guru99.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.examples.config.GlobalDataStore;
import com.examples.pages.Guru99LoginPage;
import com.examples.pages.Guru99ManagerHomePage;
import com.guru99.framework.ExcelUtils;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Test99GuruLoginPage {

	final static Logger logger = Logger.getLogger("GURU99_TESTS");

	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();

	String BankHomePage;
	String Username;
	String Psswd;
	String GecKoDriver;
	String ExtendReportsDirectoryPath;
	String TestDataFilePath;
	String baseDir;

	String HomePage;
	Boolean HomePageLaunch = false;
	Guru99ManagerHomePage objManagerHomePage;
	Guru99LoginPage objHomePage;
	ExtentReports report;
	ExtentTest test;

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException {
		
		baseDir = System.getProperty("user.dir");
		ExtendReportsDirectoryPath = baseDir + "/" + "test-output/";
		report = new ExtentReports(ExtendReportsDirectoryPath + "Test99GuruLoginPage.html");
		gds.setLogCategory("GURU99_GLOBAL");

		test = report.startTest("Verify Welcome Text");

		logger.info("START: Test99GuruLoginPage - In set-up Method");
		test.log(LogStatus.INFO, "START: Test99GuruLoginPage - In set-up Method");

		gds.initParameters();
		// GlobalDataStore.setLogCategory("GURU99_TESTS");
		// calls the init Method in getWebDriverInstance and gets the WebDriverImpl
		// Object driver..
		test.log(LogStatus.INFO, "Test99GuruLoginPage - BROWSER: " + BrowserName);
		driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
		BankHomePage = GlobalDataStore.Guru99HomePage;
		Username = GlobalDataStore.UserName;
		Psswd = GlobalDataStore.Password;
		HomePageLaunch = driver.navigateTo(BankHomePage);

		objHomePage = new Guru99LoginPage();
		objHomePage.setLogCategory("GURU99_TESTS");
		objHomePage.setExtentReports(test);
		objHomePage.setWebDriver(driver);

		TestDataFilePath = baseDir + "/" + "src/test/resources/" + GlobalDataStore.TestDataFile;
		logger.info("END: In set-up Method");

	}

	@Test
	public void test_Login() {

		if (HomePageLaunch == true) {

			String loginPageTitle = objHomePage.getHomePageDashboardName();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
			//
			objHomePage.checkClickableLinks();
			String uID = objHomePage.getUserID();
			
			Assert.assertTrue(uID.trim().contains("UserID")); 
			// login to application 
			test.log(LogStatus.INFO, "Log into application");
			objHomePage.loginToGuru(Username, Psswd);

			Assert.assertTrue(objHomePage.getLogoutButton());

			// Logout
			objHomePage.clickLogout();	

		}

	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			
			String path = driver.takeScreenshot(ExtendReportsDirectoryPath + testResult.getName());
			System.out.println("Image Path " + path);
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
	}
/*
	@Test
	public void test_Logout() {

		if (HomePageLaunch == true) {

			String loginPageTitle = objHomePage.getHomePageDashboardName();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

			// login to application 
			objHomePage.loginToGuru(Username, Psswd);
			objHomePage.clickLogout();
			Assert.assertTrue(objHomePage.checkForStepsToGenerateAccess());
			System.out.println("ckForStepsToGenerateAccess-----------");
			Assert.assertTrue(objHomePage.ckForStepsToGenerateAccess());
			int size = objHomePage.getLoginPageList();
			String strSize = Integer.toString(size);
			Assert.assertTrue(strSize.contains("4"));
			int LoginResetSize = objHomePage.getLoginReset();
			String strLoginResetSize = Integer.toString(LoginResetSize);
			Assert.assertTrue(strLoginResetSize.contains("2"));
			

		}

		// ul[@class='nav navbar-nav']/li[1]/ul//u[contains9text90," + text + "
		// .//*[@id='navbar-brand-centered']/ul/li[1]/ul/li[3]/a

	}

	@Test
	void test_menu() {

		if (HomePageLaunch == true) {

			String loginPageTitle = objHomePage.getHomePageDashboardName();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

			// login to application 
			objHomePage.clickSeleniumDropDown();
			objHomePage.clickTableDemo();
			String demoSiteUrl = objHomePage.getURL();
			System.out.println(demoSiteUrl);
			Assert.assertTrue(demoSiteUrl.contains("http://demo.guru99.com/test/table.html"));

		}
	}

	@Test
	void test_CountOfAllLinks() {

		if (HomePageLaunch == true) {

			String loginPageTitle = objHomePage.getHomePageDashboardName();
			Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

			// login to application
			int count = objHomePage.getCountOfAllLinks();
			System.out.println("count = " + count);
			String countAsString = Integer.toString(count);
			Assert.assertTrue(countAsString.contains("19"));

		}

	}
*/
	@Test(dataProvider = "Authentication")
	public void testGuru99LoginExcel(String sUserName, String sPassword) throws Exception {
		if (HomePageLaunch == true) {

			String loginPageTitle = objHomePage.getHomePageDashboardName();
			System.out.println(" The TestDataFilePath " + TestDataFilePath);
			 logger.info("testGuru99LoginExcel - In testGuru99Login Method ");
			// ExcelUtils.setExcelFile(TestDataFilePath, "sheet1");
			driver.navigateTo(BankHomePage);
			// strUserName= ExcelUtils.getCellData(1,1);
			logger.info("testGuru99LoginExcel - The userName from Excel " +sUserName);
			System.out.println("testGuru99LoginExcel - The userName from Excel " + sUserName);
			// strPassword = ExcelUtils.getCellData(1,2);
			logger.info("testGuru99LoginExcel - The password from Excel " +sPassword);
			System.out.println("testGuru99LoginExcel - The password from Excel " + sPassword);
			objHomePage.loginToGuru(sUserName, sPassword);
			// loginTitle=objHomePage.
			System.out.println("testGuru99LoginExcel - The login Title " + loginPageTitle);
			Assert.assertTrue(objHomePage.getLogoutButton()); 
			// Logout
			objHomePage.clickLogout();
		}
	}
	


	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(TestDataFilePath, "Sheet1");

		return (testObjArray);

	}


	@AfterClass
	public void afterClass() {
		
		// Close
		this.driver.quitDriver();
		report.endTest(test);
		report.flush();
	}
}
