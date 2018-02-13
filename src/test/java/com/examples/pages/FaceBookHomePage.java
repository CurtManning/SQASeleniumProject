package com.examples.pages;

import org.openqa.selenium.WebDriver;

public class FaceBookHomePage {
	protected WebDriver driver;

	public FaceBookHomePage(WebDriver driver) {
		this.driver = driver;

	}

	public void launchHomePage(String HomePage) {
		driver.get(HomePage);
		driver.manage().window().maximize();

	}

	// Get the title of Login page
	public String getLoginTitle() {
		return driver.getTitle().trim();

	}

}
