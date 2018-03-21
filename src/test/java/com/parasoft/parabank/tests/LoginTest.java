package com.parasoft.parabank.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.parasoft.parabank.pages.AccountsOverviewPage;
import com.parasoft.parabank.pages.ErrorPage;
import com.parasoft.parabank.pages.LoginPage;

public class LoginTest {
	
	 WebDriver driver;
     
	    @BeforeSuite
	    public void setUp() {
	         
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	     
	    @Parameters({"incorrectusername","incorrectpassword"})
	    @Test(description="Performs an unsuccessful login and checks the resulting error message (passes)")
	    public void testFailingLogin(String username, String incorrectpassword) {
	         
	        LoginPage lp = new LoginPage(driver);
	        ErrorPage ep = lp.incorrectLogin(username, incorrectpassword);
	        Assert.assertEquals(ep.getErrorText(), "The username and password could not be verified.");
	    }
	    
	    @Parameters({"incorrectusername","incorrectpassword"})
	    @Test(description="Performs an unsuccessful login and checks the resulting error message (fails)")
	    public void failingTest(String username, String incorrectpassword) {
	         
	        LoginPage lp = new LoginPage(driver);
	        ErrorPage ep = lp.incorrectLogin(username, incorrectpassword);
	        Assert.assertEquals(ep.getErrorText(), "This is not the error message you're looking for.");
	    }
	    
	    @Parameters({"correctusername","correctpassword"})
	    @Test(description="Performs a successful login and checks whether the Accounts Overview page is opened")
	    public void testSuccessfulLogin(String username, String incorrectpassword) {
	         
	        LoginPage lp = new LoginPage(driver);
	        AccountsOverviewPage aop = lp.correctLogin(username, incorrectpassword);
	        Assert.assertEquals(aop.isAt(), true);
	    }
	     
	    @AfterSuite
	    public void tearDown() {
	         
	        driver.quit();
	    }
}
