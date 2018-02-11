package com.facebook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {


@Test
	public static void basicTest() {

	
		WebDriver driver;
		String baseUrl = "http://www.facebook.com/";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";

		System.setProperty("webdriver.gecko.driver",
				"/Users/CurtA/maven-projects/maven-topics/drivers/geckodriver.exe");


		driver = new FirefoxDriver();
		
		// launch the actual value of the title
		driver.get(baseUrl);
		
		// get the actual vale of the title
		actualTitle = driver.getTitle();
		actualTitle = actualTitle.trim();
		System.out.println("The actual Title " + actualTitle);

		/*
		 * compare the actual title of the page with the expected one and print
		 * the result as "Passed" or "Failed".
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("FIREFOX Test Passed");
		} else {
			System.out.println("FIREFOX Test not");
		}

		driver.close();

	}

}
