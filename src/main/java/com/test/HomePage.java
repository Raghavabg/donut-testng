package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public HomePage(RemoteWebDriver driver)
	{
				
		PageFactory.initElements(driver, this);		
	}		
	
	
	@FindBy(css="input[value='oneway']") WebElement oneway;	
	
	@FindBy(css="input[value='roundtrip']") WebElement roundtrip;	
	
	@FindBy(name="fromPort") WebElement fromPort;	
	
	@FindBy(name="toPort") WebElement toPort;
	
	
	@FindBy(name="findFlights") WebElement findFlights;
	@FindBy(name="reserveFlights") WebElement reserveFlights;
	
	
	@FindBy(name="passFirst0") WebElement passFirst0;
	@FindBy(name="passLast0") WebElement passLast0;
	@FindBy(name="creditnumber") WebElement creditnumber;
	@FindBy(name="buyFlights") WebElement buyFlights;
	

}
