package com.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

public class Utility {
	
RemoteWebDriver driver;
	
	public Utility(RemoteWebDriver driver) {
		
		//super(driver);   //  invoke or call parent class constructor 
		
		this.driver = driver;  // assign to local driver 
	}

	
	
	 public String getScreenShot(RemoteWebDriver driver,String screenshotname) throws IOException
	   {
		   String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // java SimpleDateFormat class
		   TakesScreenshot ts = (TakesScreenshot) driver;  // selelnium class TakesScreenshot
		   File Source = ts.getScreenshotAs(OutputType.FILE); // java io file 
		   
		   
		   String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotname + datename + ".png";
		   
		   File finaldestination = new File(destination);   
		
		   Files.copy(Source, finaldestination);
		 
		   
		return destination;
		   
	   }
	
	
	
}
