package com.mer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.test.Home;
import com.test.Login;
import com.test.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.google.common.io.Files;

public class MainClassTestNG {
	public RemoteWebDriver driver;	
	public Login login;
	public Home home;
	public Utility Util;
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports Exreports;
	public ExtentTest tests;
	
	
	// Test case 1	
  @Test (enabled=true, groups = {"Regression","Smoke"})
  public void testcase1_LoginLinks() {  	 
	  tests = Exreports.createTest("testcase1_LoginLinks");	  
	  Assert.assertTrue(login.LoginLinks());
	  
	  //Assert.assertTrue(login.LoginMercury());
	  //Assert.assertTrue(home.BookTrip("roundtrip"));
	 // Assert.assertTrue(login.LogoutMercury());
  }
  
  // Test case 2
  @Test (enabled=true, groups = {"Smoke"})
  public void testcase2_DentalQuote() {	  	  
	  tests = Exreports.createTest("testcase2_DentalQuote");	  
	  Assert.assertTrue(home.DentalQuote());

  }
  
  // Test case 3
  @Test (enabled=true, groups = {"Regression","Smoke"})
  public void testcase3_Contacts() {  
		  tests = Exreports.createTest("testcase3_Contacts");
	 	  Assert.assertTrue(home.Contacts());	 
  }
  
  @BeforeTest(alwaysRun = true)
  public void BeforeAlltest()
  {
	  // Extent Reports classes 
		 htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myfirst.html");
		 htmlreporter.config().setDocumentTitle("Automation Test powered by ExtentsReport");
		 htmlreporter.config().setReportName("Mercury Tests");
		 htmlreporter.config().setTheme(Theme.STANDARD);
		 
		 Exreports = new ExtentReports();
		 Exreports.attachReporter(htmlreporter);
		 
		 Exreports.setSystemInfo("Browser","Chrome");
		 Exreports.setSystemInfo("OS","Windows");
		 Exreports.setSystemInfo("Environment","Test");
  }
  
  @AfterTest(alwaysRun = true)
  public void AfterAlltest()
  {
	  Exreports.flush(); // flushes all the memory instances 	  
  }
      
  
  @BeforeMethod(alwaysRun = true)
  public void DriverSetup()  
	{			  
	  // Below line not required since its added in path variable 
		// System.setProperty("webdriver.chrome.driver", "C:\\apps\\SeleniumDrivers\\chromedriver.exe");		 
	    
		 driver = new ChromeDriver();	  
	  	   
	    	  // DesiredCapabilities cp = DesiredCapabilities.chrome();
	    	   //ChromeOptions options = new ChromeOptions();
			//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cp);
			
		 // need to use remote web driver 		 
		 driver.manage().window().maximize();
		 
		 driver.get("https://www.physiciansmutual.com/");
			
			 login = new Login(driver);
			 home = new Home(driver);	
			 Util = new Utility(driver);
			 
	}

  // ITestResult result is an testng interface * This class describes the result of a test.
  @AfterMethod(alwaysRun = true)
  public void DriverQuit(ITestResult result) throws InterruptedException, IOException
	{	  
	  
	  if (result.getStatus() == ITestResult.FAILURE) 
	  {		  
		  tests.log(Status.FAIL, "Test case is failed -" + result.getName()); // to add test case name in the extent report 		                                                                         
		  String screenshotPath = Util.getScreenShot(driver, result.getName()); // call getscreen shot method 		  
		  tests.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());		  
	  }  

	  else if ((result.getStatus() == ITestResult.SKIP))
			  {
		  tests.log(Status.SKIP, "Test case is skipped -" + result.getName());
			  }
	  else if((result.getStatus() == ITestResult.SUCCESS))
	  {
		  tests.log(Status.PASS, "Test case is Passed -" + result.getName());
	  }
	  	   
	  
	   
		//System.out.println("DriverQuit  ");
		driver.manage().deleteAllCookies();
		driver.quit();
	}

  
  
}
