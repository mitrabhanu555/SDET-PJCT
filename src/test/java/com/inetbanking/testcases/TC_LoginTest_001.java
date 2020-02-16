package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;


public class TC_LoginTest_001  extends BaseClass{
	
	
	@Test
	public void loginTest() throws Throwable {
		
		driver.get(baseUrl);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Thread.sleep(2000);
		lp.setPassword(password);
		Thread.sleep(2000);
		lp.clickSubmit();
		
        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
        	
			Assert.assertTrue(true);
			
		} else {
			
			Assert.assertTrue(false);
			

		}
		
	}

}
