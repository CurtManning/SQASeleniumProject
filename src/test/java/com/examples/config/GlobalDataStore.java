package com.examples.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class GlobalDataStore {
	
	private Properties configFile= new Properties();
	public static String HomePage;
	public static String Guru99HomePage;
	public static String UserName;
	public static String Password;
	public static String GeckoDriver;
	public static String GeckoDriver_MAC;
	public static String GeckoDriver_WIN;
	public static String ChromeDriver_MAC;
	public static String ChromeDriver_WIN;
	public static String ChromeDriver;
	public static String LogCategory;
	public static Logger logger;
	
	public void setLogCategory(String LogFile) {

		LogCategory = LogFile;

		logger = Logger.getLogger(LogCategory);

	}
	
	public  void initParameters(){
		logger.info(" initParameters ");
		String baseDir= System.getProperty("user.dir");
		
		String propFile="selenium.properties";
		FileInputStream fis = null;	
		
		
		try{
			
			//C:\Users\CurtA\SQA-Workspace\SQASeleniumProject\src\test\resources\selenium.properties
			fis=new FileInputStream(baseDir+ "/" +"src/test/resources/" +propFile);			
		    configFile.load(fis);
			
		    GeckoDriver_MAC=configFile.getProperty("GECKO_DRIVER_MAC");
		    GeckoDriver_WIN=configFile.getProperty("GECKO_DRIVER_WIN");
		    HomePage=configFile.getProperty("BASE_URL");
		    ChromeDriver_MAC=configFile.getProperty("CHROME_DRIVER_MAC");
		    ChromeDriver_WIN=configFile.getProperty("CHROME_DRIVER_WIN");
		    ChromeDriver=configFile.getProperty("CHROME_DRIVER");
		    Guru99HomePage=configFile.getProperty("GURU99_HOMEPAGE");

		    GeckoDriver=configFile.getProperty("GECKO_DRIVER");
		    UserName=configFile.getProperty("USERNAME");
		    Password=configFile.getProperty("PASSWORD");
		    
		    logger.info("GeckoDriver_MAC  " + GeckoDriver_MAC);
		    logger.info("GeckoDriver_WIN  " + GeckoDriver_WIN);
		    logger.info("HomePage         " + HomePage);
		    logger.info("ChromeDriver_MAC " + ChromeDriver_MAC);
		    logger.info("ChromeDriver_WIN " + ChromeDriver_WIN);
		    logger.info("Guru99HomePage   " + Guru99HomePage);
		
		    
		
			
	    }catch(FileNotFoundException e){
	    	
		System.out.println("File not Found" +e.getMessage());
		
	    }catch(IOException e){
	    	
		System.out.println("IO Exception " +e.getMessage());
		
	 }

  }


}	
