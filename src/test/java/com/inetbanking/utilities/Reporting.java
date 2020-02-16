package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//this is listner class just named as reporting
public class Reporting implements ITestListener {
	
	public WebDriver driver = null;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
public void onStart(ITestContext context) {
		
		String timestamp = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+ timestamp+".html";
		
		//creating an object of extenthtmlreportr and defining path of the report
		//htmlreporter = new ExtentHtmlReporter("./reports/pinkurpt.html");
		//htmlreporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/test-output/pinkurpt.html"));
		//htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/pinkurpt.html");
		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		//title of the report
	    htmlreporter.config().setDocumentTitle("InetBanking Test Project");
		//name of the report
		htmlreporter.config().setReportName("Functional Test Automation Report");
		//theme of the report
	    htmlreporter.config().setTheme(Theme.DARK);
	    
	  //creating an object of extentreports and adding information to report
		extent = new ExtentReports();
		//attaching the report
		extent.attachReporter(htmlreporter);
		//ading some extra info
		extent.setSystemInfo("HostName", "Local Host");
		extent.setSystemInfo("Organization", "Mindq");
		extent.setSystemInfo("UserName", "PinkuBabu");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		
	}


	public void onTestSuccess(ITestResult tr) {
		
		//create new entry in the report
		logger = extent.createTest(tr.getName());
				
		//send the 
		//logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		 String methodName = tr.getMethod().getMethodName();
			String logtext = "<b>" + "TEST CASE : - " + methodName.toUpperCase()+ "   PASSED" + "</b>";
			Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
			logger.pass(m);
		
		
		
	}

	public void onTestFailure(ITestResult tr) {
		
		//create new report in the entry
		logger = extent.createTest(tr.getName());
		
		//to add name in extent report
		//logger.log(Status.FAIL,"TEST CASE FAILED IS : " + tr.getName());
		//to add error or exception in extentreports
		logger.log(Status.FAIL,"TEST CASE FAILED IS : " + tr.getThrowable());
		
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\" + tr.getName()+".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
					
		  try {
						
			logger.fail("Scrrenshot is below :" + logger.addScreenCaptureFromPath(screenshotPath));
						
			} 
			 catch (IOException e) {
				e.printStackTrace();
				 }
					
			}
		/*
		//to add name in extent report
		logger.log(Status.FAIL,"TEST CASE FAILED IS : " + tr.getName());
		//to add error or exception in extentreports
		logger.log(Status.FAIL,"TEST CASE FAILED IS : " + tr.getThrowable());
		
		String screenshotPath = Reporting.getScreenshot(driver, tr.getName());
		//attach scrrenshot to extent report
		logger.addScreenCaptureFromPath(screenshotPath);
		*/
		
		

		/*String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png" ;
	    File finalDestination = new File(destination);
	    FileUtils.copyFile(source, finalDestination);
	    return destination;
	
		*/
		
	}

	public void onTestSkipped(ITestResult result) {
		
		logger.log(Status.SKIP, "TEST CASE SKIPPED IS : " + result.getName());
		
	}
    
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}
	


	


	

}
