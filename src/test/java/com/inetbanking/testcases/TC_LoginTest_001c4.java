package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;


public class TC_LoginTest_001c4  extends BaseClass5{
	
	
	@Test
	public void loginTest() throws Throwable {
		//in project home directory it will create a new folder and inside this folder it will create the logs
		
		logger.info("browser opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered UserName");
		Thread.sleep(2000);
		lp.setPassword(password);
		logger.info("Entered Password");
		Thread.sleep(2000);
		lp.clickSubmit();
		
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
        	
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			
		} else {
			
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
			

		}
        
        Thread.sleep(3000);
		lp.clickLogout();
	}
	
	

}
