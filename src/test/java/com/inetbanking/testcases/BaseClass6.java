package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass6 {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String chromepath = readconfig.getChromepath();
	public String firefoxpath = readconfig.getFirefoxpath();
	public static WebDriver driver = null;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
    public void setup(String br) {
		
		if (br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (br.equals("firefox")) {
			
			System.setProperty("webdriver.chrome.driver", firefoxpath);
			driver = new FirefoxDriver();
			
		}
		 driver.get(baseUrl);
		//in project home directory it will create a new folder and inside this folder it will create the logs
		logger = Logger.getLogger("sdet");
		PropertyConfigurator.configure("log4j.properties");
		
      }
	
    @AfterClass
    public void tearDown() {
    	 
    	 driver.quit();
    	 
     }
    
public static String captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + "/screenshots/" + tname + ".png";
		File finalDestination = new File(target);
		FileUtils.copyFile(source, finalDestination);
		System.out.println("Screenshot taken");
		return target;
		
	}


public static String randomstring() {
	
	String generatedstring = RandomStringUtils.randomAlphabetic(8);
	return generatedstring;
  }

public static String randomNum() {
	
	String generatedstring2 = RandomStringUtils.randomNumeric(6);
	return generatedstring2;
  }



}
