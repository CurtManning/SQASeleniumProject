package com.guru99.framework;

public class Guru99WebDriverFactory {
	/***
	 * Get a Web Driver instance.
	 * 
	 * @param BrowserName
	 * @return An instance of a webDriver
	 */

	public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) {
		// String BrowserName-"fireFox";

		Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
		webDriver.init(BrowserName);
		return webDriver;
	}

}
