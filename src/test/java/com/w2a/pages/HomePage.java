package com.w2a.pages;


import org.openqa.selenium.By;
//import org.openqa.selenium.By.ById;


public class HomePage {	
	
	public static final By bmlBtn = By.xpath("//button[text()='Bank Manager Login']");
	public static final By addCustomerBtn= By.xpath("//button[@ng-class='btnClass1']");
	public static final By firstName= By.xpath("//input[@ng-model='fName']"); 
	public static final By lastName= By.xpath("//input[@ng-model='lName']");
	public static final By postCode= By.xpath("//input[@ng-model='postCd']");
	public static final By addBtn= By.xpath("//button[@type='submit']");	
}


