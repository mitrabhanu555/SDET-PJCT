package com.inetbanking.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.AddCustomerPage;
import com.inetbanking.pageobject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass6{
	@Test
	public void addnewCustomer() throws Throwable {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		//Thread.sleep(1000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		logger.info("Selecting new customer");
		
		logger.info("Providing customer details");
		addcust.clickAddNewCustomer();
	
		addcust.custName("pinku");
		Thread.sleep(1000);
		addcust.custGender("female");
		Thread.sleep(1000);
		addcust.custdob("10", "15", "1980");
		Thread.sleep(2000);
		addcust.custaddress("bhanda");
		Thread.sleep(1000);
		addcust.custcity("BBSR");
		Thread.sleep(1000);
		addcust.custstate("ODISHA");
		Thread.sleep(1000);
		addcust.custpinno("758044");
		Thread.sleep(1000);
		addcust.custtelephoneno("9658004942");
		Thread.sleep(1000);
		String email = randomstring()+"@gmail.com";
		Thread.sleep(1000);
		addcust.custemailid(email);
		Thread.sleep(1000);
		addcust.custpassword("pinkubabu");
		Thread.sleep(1000);
		addcust.custsubmit();
		
		Thread.sleep(1000);
		logger.info("Validation started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res==true) {
			
			Assert.assertTrue(true);
			logger.info("TEST CASE IS PASSED");
		}else {
			
			logger.info("TEST CASE IS FAILED");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
	

	
	
}
