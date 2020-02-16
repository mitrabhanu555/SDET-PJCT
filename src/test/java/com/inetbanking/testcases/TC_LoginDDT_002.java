package com.inetbanking.testcases;


import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;
import com.inetbanking.utilities.XLUtils;


public class TC_LoginDDT_002 extends BaseClass6{

	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws Throwable {
		
		logger.info("browser opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered UserName");
		Thread.sleep(2000);
		lp.setPassword(pwd);
		logger.info("Entered Password");
		Thread.sleep(2000);
		lp.clickSubmit();
		
		if (isAlertPresent()== true) {
			
			
			Alert alert =driver.switchTo().alert();
			captureScreen(driver, "LoginTest");
			Thread.sleep(2000);
			alert.accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
			
		} else if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			logger.info("Login Passed");
			Assert.assertTrue(true);
			//Thread.sleep(2000);
			lp.clickLogout();
			Thread.sleep(2000);
			driver.switchTo().alert();
			//close logout alert
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}
		
		
		
	}
	//user defined method created to check that alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
	}

	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws Throwable, Throwable{
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testdata/Book1.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]= new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			
			for (int j = 0; j < colcount; j++) {
				
				logindata [i-1] [j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
				
				
				
			}
			
		}
		return logindata;
		
	}
	
	
}
