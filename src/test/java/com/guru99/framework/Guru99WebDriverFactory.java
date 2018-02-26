package com.guru99.framework;

import java.net.MalformedURLException;

public class Guru99WebDriverFactory {
	/***
	 * Get a Web Driver instance.
	 * 
	 * @param BrowserName
	 * @return An instance of a webDriver
	 * @throws MalformedURLException 
	 */

	public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {
		// String BrowserName-"fireFox";

		Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
		webDriver.init(BrowserName);
		//webDriver.initSauceLabs(BrowserName); 
		return webDriver;
	}

}
