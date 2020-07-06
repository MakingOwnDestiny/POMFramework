package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




public class Utility {
	
	public static WebDriver driver;
	public static String WSPath = System.getProperty("user.dir");	
	public String PropertiesFilePath = WSPath + "\\src\\test\\resources\\com\\w2a\\properties\\GlobalSettings.properties";
	//public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));	
	FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	public static String screenshotName;
	
	
	public static ExtentReports extent ;
	public static ExtentTest test;
	
   	 
	 public static String getScreenshot(String tcName) throws IOException {
		 
		  File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  Date date = new Date();		
		  screenshotName=tcName+"_"+date.toString().replace(":","_").replace(" ", "_")+".jpg";
		  FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\test-output\\ScreenShots\\"+screenshotName));
		  String destinationPath= System.getProperty("user.dir")+"\\test-output\\ScreenShots\\"+screenshotName;
		  File finalDestination = new File(destinationPath);
		  return destinationPath;
		  
	 }
	
		
	
	public void openBrowserInstance() throws IOException{
		
		log.debug("Executing OpenBrowserInstance Method !!");
		System.out.print("Setting chrome driver");
		System.setProperty("webdriver.chrome.driver", getPropertyFileValue("ChromeDriverPath"));
		System.out.print("Opening browser instance");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
	}
	
	public static void closeBrowserInstance() {
		log.debug("Executing CloseBrowserInstance Method !!");
		driver.quit();
	}
	
	public String getPropertyFileValue(String Key) throws IOException{
	
		Properties obj = new Properties();
		fis = new FileInputStream(PropertiesFilePath);
		obj.load(fis);
		String value = obj.getProperty(Key);
		return value;
	}
	
	 
	public void launchApplication() throws IOException, InterruptedException{
		
		log.debug("Executing LaunchApplication Method !!");
		String Environment = getPropertyFileValue("Url");
		driver.get(Environment);
		Thread.sleep(1000);
	}
	
	public void clickOnElement(By Element) throws InterruptedException {
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(Element));		
		driver.findElement(Element).click();
		Thread.sleep(1000);
	}
			
	public void sendValueToInputBox(By Element, String value) throws InterruptedException{
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
		WebElement control = driver.findElement(Element);
		control.clear();
		Thread.sleep(1000);
		control.sendKeys(value);		
	}
	

	public void selectDropDownByVisibleText(By element, String visibleText) {	
		
		Select sc = new Select(driver.findElement(element));
		sc.selectByVisibleText(visibleText);
	}
	
	public void handleAlert() {
		try {
		    // Add a wait timeout before this statement to make 
		    // sure you are not checking for the alert too soon.
		    Alert alt = driver.switchTo().alert();
		    alt.accept();
		} catch(NoAlertPresentException noe) {
		    // No alert found on page, proceed with test.
		}
	}
}
	
	
