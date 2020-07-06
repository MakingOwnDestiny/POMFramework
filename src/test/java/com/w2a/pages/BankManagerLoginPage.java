package com.w2a.pages;

import org.openqa.selenium.By;

public class BankManagerLoginPage {
	
	public static final By openAccount=By.xpath("//button[@ng-click='openAccount()']");
	public static final By selectCustomerDropdown=By.xpath("//select[@id='userSelect']");
	public static final By selectCurrencyrDropdown=By.xpath("//select[@id='currency']");
	public static final By processBtn=By.xpath("//button[@type='submit']");
	
}
