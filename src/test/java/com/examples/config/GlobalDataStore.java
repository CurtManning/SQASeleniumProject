package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GlobalDataStore {

	private Properties configFile = new Properties();
	public static String HomePage;
	public static String UserName;
	public static String Password;
	public static String GeckoDriver;
	public static String ChromeDriver;

	public void initParameters() {
		
		String baseDir = System.getProperty("user.dir");
		String propFile = "selenium.properties";
		FileInputStream fis = null;

		try {
		
			fis = new FileInputStream(baseDir + "/" + "src/test/resources/" + propFile);

			System.out.println("fis = " + fis);

			configFile.load(fis);

			GeckoDriver = configFile.getProperty("GECKO_DRIVER");
			HomePage = configFile.getProperty("BASE_URL");
			ChromeDriver = configFile.getProperty("CHROME_DRIVER");

		} catch (FileNotFoundException e) {

			System.out.println("File Not Found " + e.getMessage());
			
		} catch (IOException e) {

			System.out.println("IO Exception " + e.getMessage());
		}

	}

}
