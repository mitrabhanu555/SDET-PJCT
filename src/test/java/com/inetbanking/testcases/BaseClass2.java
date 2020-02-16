package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass2 {
	
	
	
	public String baseUrl = "http://demo.guru99.com/V4/";
	public String username = "mngr243107";
	public String password = "benArAj";
	public static WebDriver driver = null;
	public static Logger logger;
	@BeforeClass
    public void setup() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
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
