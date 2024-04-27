package testCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import pageObject.Base;
import pageObject.LoginPage;
import utilities.BrowserFactory;
import utilities.ConfigDataprovider;
import utilities.ExcelDataProvider;
import utilities.Helper;

public class Login extends Base {
	public WebDriver driver;
	
	//Added a comment
	@AfterClass
	public void closeBrowswer() {
		BrowserFactory.quitBrowser(driver);	
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception {
		//it will capture the screenshot when script fails at run time
		if(result.getStatus()==ITestResult.FAILURE) {
		Helper.captureScreenshot(driver);
		//this fail screenshot we want to add in Extent report will see later
		//logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath("").build());
		}
		report.flush();
	}
	
	@BeforeClass
	public void startBrowswer() {
		ConfigDataprovider config=new ConfigDataprovider();
		String browser=config.getBrowser();
		System.out.println("bowser is "+browser);
		String url=config.getURL();
		System.out.println("url is "+url);
//		driver= BrowserFactory.startApplication(driver,"chrome","https://www.naukri.com/nlogin/login");			
		driver= BrowserFactory.startApplication(driver,browser,url);	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
		
	@Test
	public void  loginApp(){
		//report creation:
		logger=report.createTest("Login to Naukri.com");
		
		//driver= BrowserFactory.startApplication(driver,"chrome","https://www.naukri.com/");
		 
		 ExcelDataProvider obj=new  ExcelDataProvider();//fetching id & pwd from excel sheet
		 String username=obj.getStringData("Login", 1, 0);
		 System.out.println("username is"+username);
		 String password=obj.getStringData("Login", 1, 1);
		 System.out.println("password is"+password);
		 
		 LoginPage login=new LoginPage(driver);
		
		  LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		  //loginpage.LoginToNaukri("mohanta.ratiranjan1@gmail.com", "@2Ratiranjan");
		  //We want to add logger info here
		  logger.info("Starting Application");
		  loginpage.LoginToNaukri(username,password);
		  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Helper.captureScreenshot(driver);
		  logger.pass("Login is successful");
		  
		  
		


		
	}
	
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Test
	/*
	 * public void loginApp(){
	 * 
	 * //driver=
	 * BrowserFactory.startApplication(driver,"chrome","https://freecrm.com/");
	 * driver=
	 * BrowserFactory.startApplication(driver,"chrome","https://www.naukri.com/");
	 * //driver= BrowserFactory.startApplication(driver,"chrome",
	 * "https://www.naukri.com/nlogin/login");
	 * System.out.println("Title of Page is"+driver.getTitle()); //Store the ID of
	 * the original window String originalWindow = driver.getWindowHandle();
	 * System.out.println("original window is"+originalWindow);
	 * 
	 * driver.findElement(By.linkText("Login")).click();
	 * driver.navigate().to("https://www.naukri.com/nlogin/login");
	 * driver.findElement(By.xpath("//input[@type='text' and @id='usernameField']"))
	 * .sendKeys("mohanta.ratiranjan1@gmail.com"); driver.findElement(By.
	 * xpath("//input[@type='password' and @id='passwordField']")).sendKeys(
	 * "@2Ratiranjan");
	 * driver.findElement(By.xpath("//button[@type='submit']")).click();
	 * 
	 * //driver.switchTo().window("");//This is used to switch to parent window
	 * 
	 * }
	 */

