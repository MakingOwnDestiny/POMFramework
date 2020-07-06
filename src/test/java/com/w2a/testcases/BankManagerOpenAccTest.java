package com.w2a.testcases;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.pages.BankManagerLoginPage;
import com.w2a.utilities.Utility;

public class BankManagerOpenAccTest extends Utility {
	
	public void BMOpenAccount() throws InterruptedException {
		
		System.out.println("In BankManager Open Account Test");
		//Load extent report
		test = extent.startTest("BM Open Account Test","Bank Manager Login"); 
		test.log(LogStatus.INFO, "Select Appropriate User");
		
		clickOnElement(BankManagerLoginPage.openAccount);
		test.log(LogStatus.INFO, "Clicked On Open Account");
		selectDropDownByVisibleText(BankManagerLoginPage.selectCustomerDropdown,"Gouri Das");
		test.log(LogStatus.INFO, "Name selected from dropdown");
		selectDropDownByVisibleText(BankManagerLoginPage.selectCurrencyrDropdown, "Rupee");
		test.log(LogStatus.INFO, "Currency selected from dropdown");
		clickOnElement(BankManagerLoginPage.processBtn);
		
		
	}
	
	
	

}
