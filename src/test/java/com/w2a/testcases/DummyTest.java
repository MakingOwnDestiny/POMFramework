package com.w2a.testcases;

import javax.swing.text.html.parser.Element;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.Utility;

public class DummyTest extends Utility {
	
	public void ExtentReportTest() {
		
		System.out.println("Inside Dummy test");
		//Load extent report
		test=extent.startTest("DummyTest","DummyTest");
		test.log(LogStatus.INFO, "Execution has been Started..");		
		Assert.fail();
	}
	
}
