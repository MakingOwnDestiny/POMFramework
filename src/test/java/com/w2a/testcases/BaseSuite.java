package com.w2a.testcases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.Utility;


@Listeners(com.w2a.configurations.TestNGListener.class)
public class BaseSuite extends Utility {
	
	BankManagerLoginTest obj_bankManagerLoginTest;
	DummyTest obj_dummyTest;
	BankManagerOpenAccTest obj_bankManagerOpenAccTest;
	
	
	  @BeforeSuite
	  public void beforeSuiteHelper() throws IOException {
		 
		 System.out.println("========Before Suite===========");		 
		 System.out.println("Test suite started");	
		 
		//Extent report Setup
		 String WSpath = System.getProperty("user.dir");		
		 String ExtentFilePath = WSpath+"\\test-output\\ExtentReports\\HtmlReport_XYZBanking_Report"+".html";	
		 extent = new ExtentReports(ExtentFilePath,true);
		 extent.addSystemInfo("Environment","XYZ Banking Application");
		 extent.addSystemInfo("Username","Gouri Das");
		 extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\extentconfig\\extent-config.xml"));
	 	  
	  }	  

	  @AfterSuite
	  public void afterSuiteHelper() throws IOException {
		  System.out.println("========After Suite===========");
		  
		 
		  extent.flush();
		  
		  //extent.close();
	  }
	 	  
	  @BeforeClass
	  public void beforeClassHelper() {
		  //Objects are instantiated here
		  System.out.println("========Before Class===========");
		  		  
		  obj_bankManagerLoginTest = new BankManagerLoginTest();
		  obj_dummyTest = new DummyTest();
		  obj_bankManagerOpenAccTest = new BankManagerOpenAccTest();
	  }
	  
	  @BeforeMethod
	  public void beforeMethodHelper() throws IOException, InterruptedException {
		  
		  
	  }
	  
	  @AfterMethod
	  public void afterMethodHelper(ITestResult result) throws IOException {
		 
		 String screenshotPath;
		 if(ITestResult.SKIP==result.getStatus()) {
			 screenshotPath=getScreenshot(result.getName());
			 test.log(LogStatus.SKIP, test.addScreenCapture(screenshotPath));
		 }
		 else if(ITestResult.FAILURE==result.getStatus()) {
			 screenshotPath=getScreenshot(result.getName());
			 test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		 }
		 else{
			 screenshotPath=getScreenshot(result.getName());
			 test.log(LogStatus.PASS, test.addScreenCapture(screenshotPath));
		 }	 
	
	  }
	  
	  @BeforeTest
	  public void beforeTestHelper() throws IOException {		  
		  openBrowserInstance();
	  }
	  @AfterTest
	  public void afterTestHelper() {
		  closeBrowserInstance();		  
	  }
	  
	  /**
	   * 
	   * *********************************Test Case execution starts*****************************
	   */

	  @Test(enabled=true,priority=0)
	  public void loginTest() throws InterruptedException, IOException {
		  
		  launchApplication();		  
		  obj_bankManagerLoginTest.BankManagerLogin();
		  handleAlert();   
	  } 
	  
	  @Test(enabled=true,priority=1)
	  public void dummyTest() {
		  obj_dummyTest.ExtentReportTest();
	  } 
	  
	  @Test(enabled=true,priority=2)
	  public void bankManagerOpenAccTest() throws InterruptedException {
		  obj_bankManagerOpenAccTest.BMOpenAccount();
		  handleAlert();
	  }

}
