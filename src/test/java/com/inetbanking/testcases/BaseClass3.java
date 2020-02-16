package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass3 {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String chromepath = readconfig.getChromepath();
	public String firefoxpath = readconfig.getFirefoxpath();
	public static WebDriver driver = null;
	public static Logger logger;
	@BeforeClass
    public void setup() {
		
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		//in project home directory it will create a new folder and inside this folder it will create the logs
		logger = Logger.getLogger("sdet");
		PropertyConfigurator.configure("log4j.properties");
		
      }
	
    @AfterClass
    public void tearDown() {
    	 
    	 driver.quit();
    	 
     }

}
