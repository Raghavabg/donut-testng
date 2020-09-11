package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Login extends LoginPage {
	

	
	RemoteWebDriver driver;
	
	public Login(RemoteWebDriver driver) {
		
		super(driver);   //  invoke or call parent class constructor 
		
		this.driver = driver;  // assign to local driver 
	}



	public boolean LoginMercury()
	{
		try {
			
			
			if(UserName.isDisplayed())
			{
				//driver.findElement(By.name("userName")).sendKeys("mercury");
				//driver.findElement(By.name("password")).sendKeys("mercury");				
				UserName.sendKeys("mercury");
				Password.sendKeys("mercury");				
				
			}
			else {
				
				return false;
			}
			
			if(login.isDisplayed())
			{
				login.click();	
			}
			else
			{
				return false;
			}
				
		}
		
		catch (Exception e) {			
			System.out.println("LoginMercury function error occurred " + e.getMessage());
			return false;
		}
		
		return true;
		
	}
		
	
	
	public boolean LogoutMercury()
	{
		try {		
			
			if(Logout.isDisplayed())
			{
				Logout.click();
			}						
			else
			{
				return false;
			}
		}
		
		catch (Exception e) {			
			System.out.println("LogoutMercury function error occurred " + e.getMessage());
			return false;
		}
		
		return true;
		
	}
	
	
	public boolean LoginLinks()
	{
	 try {		
		 
		
		 
		 System.out.println("LoginLinks method here ");
			
			if(driver.findElementByLinkText("Log In").isDisplayed())
			{
				driver.findElementByLinkText("Log In").click();				
			}						
			else
			{
				return false;
			}
			
			Thread.sleep(1000);				
			
			//String[] LinksArr = { "Password", "User ID", "Sign Up Today!", "My Account FAQs","Contact Us" };
			
			// List<WebElement> links = driver.findElements(LinksArr[0]);
			// Iterator<WebElement> it = links.iterator();
			
			Thread.sleep(2000);						
			driver.navigate().back();	
					
	 }
	 
		
		
		catch (Exception e) {			
			System.out.println("Contacts function error occurred " + e.getMessage());
			return false;
		}
		
		return true;		
	}
	
	
	
	

}
