package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
		

	public LoginPage(RemoteWebDriver driver)
	{
				
		PageFactory.initElements(driver, this);		
	}		
	

	@FindBy(name="userName") WebElement UserName;	
	@FindBy(name="password") WebElement Password; 	
	
	@FindBy(name="login") WebElement login;
	@FindBy(linkText="SIGN-OFF") WebElement Logout;
	
	

	
	
}
