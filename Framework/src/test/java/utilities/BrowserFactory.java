package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver,String browser,String appURL) {
	if(browser.equals("chrome")){
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox")){
		driver=new FirefoxDriver();
	}
    else if(browser.equals("Edge")){
    	driver=new EdgeDriver();
	}
    else {
    	System.out.println("No browser has been passed");
    }
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		
		
	return driver;	
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
