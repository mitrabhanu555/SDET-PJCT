package com.inetbanking.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

  public class BaseClass {

	public String baseUrl = "http://demo.guru99.com/V4/";
	public String username = "mngr243107";
	public String password = "benArAj";
	public static WebDriver driver = null;
	
	@BeforeClass
    public void setup() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
		driver = new ChromeDriver();
      }
	
    @AfterClass
    public void tearDown() {
    	 
    	 driver.quit();
    	 
     }







}
