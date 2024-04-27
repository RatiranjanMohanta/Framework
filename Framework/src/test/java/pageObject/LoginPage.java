package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver idriver){
		this.driver=idriver;
	}
	
	@FindBy(xpath="//input[@type='text' and @id='usernameField']") WebElement uname;
	@FindBy(xpath="//input[@type='password' and @id='passwordField']") WebElement pwd;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	
	public void LoginToNaukri(String username,String password) {
		uname.sendKeys(username);
		pwd.sendKeys(password);
		submit.click();
	}
	
	

}
