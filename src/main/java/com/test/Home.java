
package com.test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Home extends HomePage{
		
RemoteWebDriver driver;



	
	public Home(RemoteWebDriver driver) {
		
		super(driver);   //  invoke or call parent class constructor 
		
		this.driver = driver;  // assign to local driver 
	}

	
	public boolean BookTrip(String trip)
	{
		try {
			
			Thread.sleep(2000);		
			
			if (trip.equalsIgnoreCase("oneway"))				
			{
				// Radio buttons
				// WebElement radio1 = driver.findElement(By.cssSelector("input[value='oneway']"));
				// WebElement radio1 = oneway;
				oneway.click();		
			}		
			else if (trip.equalsIgnoreCase("roundtrip")) 
			{
				// Radio buttons
				// WebElement radio2 = driver.findElement(By.cssSelector("input[value='roundtrip']"));
				//WebElement radio2 = roundtrip;
				roundtrip.click();				
			}			

			
			// Select from drop downs		
			if(fromPort.isDisplayed())
			{
				Select sfromPort = new Select(fromPort);
				sfromPort.selectByVisibleText("Portland");			
				
				Select stoPort = new Select(toPort);
				stoPort.selectByVisibleText("Seattle");			
			}
			else
			{
				return false;
			}
			
			
			/*List<WebElement> elements = driver.findElements(By.name("fromPort"));			
			 System.out.println("Number of elements:" +elements.size());

			    for (int i=0; i<elements.size();i++){
			      System.out.println("Drop down values :" + elements.get(i).getAttribute("value"));  
			    }	*/
			
			if(findFlights.isDisplayed())
			{
				findFlights.click();			 
				 Thread.sleep(2000);				
				 
				 reserveFlights.click();			 
				 Thread.sleep(2000);						
				
			}
			else
			{
				return false;
			}
			
			
			 if(passFirst0.isDisplayed())
			 {
				 passFirst0.sendKeys("tom");
				 passLast0.sendKeys("jerry");			 
				 creditnumber.sendKeys("1111222233334444");		
				 buyFlights.click();	
			 }
			 else
			 {
				 return false;
			 }
			 
		}
		
		catch (Exception e) {			
			System.out.println("BookRoundTrip function error occurred " + e.getMessage());
			return false;
		}
		
		return true;		
	}
	
	
	
	
	
	public boolean Contacts()
	{
	 try {		
		 
		    System.out.println("Contacts method here ");
		 
			if(driver.findElementByLinkText("Contact Us").isDisplayed())
			{
				driver.findElementByLinkText("Contact Us").click();				
			}						
			else
			{
				return false;
			}
			
			Thread.sleep(1000);				
			
			if(driver.findElementById("cana_zip").isDisplayed())		
			{				
				Thread.sleep(3000);
				driver.findElementById("cana_zip").clear();
				driver.findElementById("cana_zip").sendKeys("68136");
				Thread.sleep(1000);
				
				driver.findElementByName("submit").click(); // Go
			}
			else
			{
				return false;		
	
		     }	
			
			Thread.sleep(3000);						
			driver.navigate().back();	
					
	 }
 
		catch (Exception e) {			
			System.out.println("Contacts function error occurred " + e.getMessage());
			return false;
		}
		
		return true;		
	}
	
	
	
	
	
	public boolean DentalQuote()
	{
	 try {				 
		 
		    if(driver.findElementByLinkText("Dental"+"\n"+"Insurance").isDisplayed())		
			{				
			 driver.findElementByLinkText("Dental"+"\n"+"Insurance").click();
			}
			else
			{
				return false;			
		    }	
			
		    
		    Select state = new Select(driver.findElementById("getQuoteFormState"));
		    state.selectByVisibleText("NE");		
		    
		    
		    Select PlanType = new Select(driver.findElementById("getQuoteFormPlanType"));
		    PlanType.selectByVisibleText("Individual Plan");		
		    
		    Select age = new Select(driver.findElementById("getQuoteFormAge"));
		    age.selectByVisibleText("Under 50");	
		    
		    Thread.sleep(9000);
		    Thread.sleep(8000);
		    Thread.sleep(2000);
		    
		    
		    WebElement radioPremiumA = driver.findElement(By.cssSelector("input[value='A']"));
		    radioPremiumA.click();
		    
		    Thread.sleep(1000);
		    
		    driver.findElementById("submitButton").click();
		    
				 Thread.sleep(2000);		
	       }
		
		catch (Exception e) {			
			System.out.println("DentalQuote method error occurred " + e.getMessage());
			return false;
		}
		
		return true;		
	}


	
	

}
