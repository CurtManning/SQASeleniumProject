package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GlobalDataStore {

	private Properties configFile = new Properties();
	public static String HomePage;
	public static String UserName;
//	public static String Pd;
	public static String GeckoDriver_MAC;
	public static String GeckoDriver_WIN;
	public static String ChromeDriver_MAC;
	public static String ChromeDriver_WIN;
	public static String Guru99HomePage;
	public static String Password;

	public void initParameters() {
		
		String baseDir = System.getProperty("user.dir");
		String propFile = "selenium.properties";
		//String propFile = "gurubank.properties";
		FileInputStream fis = null;

		try {
		
			fis = new FileInputStream(baseDir + "/" + "src/test/resources/" + propFile);

			System.out.println("fis = " + fis);

			configFile.load(fis);
			UserName = configFile.getProperty("USERNAME");
			Password = configFile.getProperty("PASSWORD");
			GeckoDriver_MAC=configFile.getProperty("GECKO_DRIVER_MAC");
		      GeckoDriver_WIN=configFile.getProperty("GECKO_DRIVER_WIN");
		      HomePage=configFile.getProperty("BASE_URL");
		      ChromeDriver_MAC=configFile.getProperty("CHROME_DRIVER_MAC");
		      ChromeDriver_WIN=configFile.getProperty("CHROME_DRIVER_WIN");
		      Guru99HomePage=configFile.getProperty("GURU99_HOMEPAGE");

		} catch (FileNotFoundException e) {

			System.out.println("File Not Found " + e.getMessage());
			
		} catch (IOException e) {

			System.out.println("IO Exception " + e.getMessage());
		}

	}

}
