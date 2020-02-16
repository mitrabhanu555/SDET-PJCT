package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "uid")
	private WebElement txtUserName = null;
	
	@FindBy(name = "password")
	private WebElement txtPassWord = null;
	
	@FindBy(name = "btnLogin")
	private WebElement btnSubmit = null;
	
	@FindBy(linkText  = "Log out")
	private WebElement lnklogout = null;
	
	public LoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String uName) {
		
		txtUserName.sendKeys(uName);
		
	}
	
    public void setPassword(String pass) {
		
		txtPassWord.sendKeys(pass);
		
	   }
     public void clickSubmit() {
		
		btnSubmit.click();
		
	     }
     public void clickLogout() {
 		
  	    lnklogout.click();
  	
           }
	
	
	
}
