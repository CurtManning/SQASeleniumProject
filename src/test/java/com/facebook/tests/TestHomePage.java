package com.facebook.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;

public class TestHomePage {
	GlobalDataStore gds = new GlobalDataStore();
	String GecKoDriver;
	WebDriver driver = null;
	String HomePage;
	String Guru99HomePage;
	String ChromeDriver;
	FaceBookHomePage FBPage;

	/**
	 * Initilaizes the gecko driver object and all the variables needed.
	 **/

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("Firefox") String BrowserName) {

		System.out.println(" The Browser Name " + BrowserName);
		gds.initParameters();
		GecKoDriver = GlobalDataStore.GeckoDriver;
		Guru99HomePage = GlobalDataStore.Guru99HomePage;
		System.out.println("The HomePage " + Guru99HomePage);
		System.out.println(" The GeckoDriver " + GecKoDriver);

		if (BrowserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", GecKoDriver);
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {

			System.out.println(" The chrome Driver " + GlobalDataStore.ChromeDriver);
			System.setProperty("webdriver.chrome.driver", GlobalDataStore.ChromeDriver);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			// driver.navigate().to(HomePage);

		} else if (BrowserName.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			// driver.navigate().to(HomePage);
		}

	}

	@Test
	public void testFaceBookTitleOnPageLoad() {

		// get the actual value of the title
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";

		// driver.get(HomePage);
		FBPage = new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		actualTitle = FBPage.getLoginTitle();

		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed".
		 */
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@AfterClass
	public void afterClass( ) {
		// Close
		driver.close();
	}
}
