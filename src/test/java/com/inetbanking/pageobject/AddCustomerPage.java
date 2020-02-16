package com.inetbanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	
	@FindBy(linkText = "New Customer")
	public WebElement newCustomer= null;
	
	@FindBy(name = "name")
	public WebElement cName= null;
	
	@FindBy(name = "rad1")
	public WebElement gndr= null;
	
	@FindBy(name = "dob")
	public WebElement date= null;
	
	@FindBy(name = "addr")
	public WebElement address= null;
	
	@FindBy(name = "city")
	public WebElement cty= null;
	
	@FindBy(name = "state")
	public WebElement state= null;
	
	@FindBy(name = "pinno")
	public WebElement pin= null;
	
	@FindBy(name = "telephoneno")
	public WebElement mobNo= null;
	
	@FindBy(name = "emailid")
	public WebElement email= null;
	
	@FindBy(name = "password")
	public WebElement pwd= null;
	
	@FindBy(name = "sub")
	public WebElement submit= null;
	
   public AddCustomerPage(WebDriver driver){
		
   PageFactory.initElements(driver, this);
   
   
	}
   
   public void clickAddNewCustomer() {
	   
	   newCustomer.click();
   }

 public void custName(String cname) {
	   
	   cName.sendKeys(cname);
   }
   
   public void custGender(String cgender) {
	   
	   gndr.click();
   }
   
   public void custdob(String mm,String dd,String yy) {
	   
	   date.sendKeys(mm);
	   date.sendKeys(dd);
	   date.sendKeys(yy);
	   
   }
   
   public void custaddress(String caddress) {
	   
	   address.sendKeys(caddress);
   }
   
   public void custcity(String ccity) {
	   
	   cty.sendKeys(ccity);
	   
   }
   
   public void custstate(String cstate) {
	   
	   state.sendKeys(cstate);
   }
   
   public void custpinno(String cpinno) {
	   
	   pin.sendKeys(String.valueOf(cpinno));
   }
   
   public void custtelephoneno(String ctelephoneno) {
	   
	   mobNo.sendKeys(ctelephoneno);
	   
   }
   public void custemailid(String cemailid) {
	   
	   email.sendKeys(cemailid);
   }
   
   public void custpassword(String pasw) {
	   
	   pwd.sendKeys(pasw);
   }
   
   public void custsubmit() {
	   
	   submit.click();
   }
   
   
   
   
   
}
