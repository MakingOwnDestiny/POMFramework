package com.w2a.testcases;



import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import com.w2a.pages.HomePage;
import com.w2a.utilities.Utility;

public class BankManagerLoginTest extends Utility {
	
	public void BankManagerLogin() throws InterruptedException, IOException {
		
		System.out.println("In BankManagerLoginMethod");
		//Load extent report
		test = extent.startTest("LoginTest","Bank Manager Login"); 
		test.log(LogStatus.INFO, "Logged in with Bank Manager Credentials");
		
		clickOnElement(HomePage.bmlBtn);
		clickOnElement(HomePage.addCustomerBtn);
		
		sendValueToInputBox(HomePage.firstName,"Gouri");
		test.log(LogStatus.INFO, "Entered First Name");
		
		sendValueToInputBox(HomePage.lastName,"Das");
		test.log(LogStatus.INFO, "Entered Last Name");
		
		sendValueToInputBox(HomePage.postCode,"500089");
		test.log(LogStatus.INFO, "Entered Post Code");
		
		clickOnElement(HomePage.addBtn);
		
		log.debug("Execution Completed !!");	
				
	}
	

}
