package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver maindriver)
	{
     this.driver= maindriver;
     
	}

	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbutton;
	
//	public void typeUsername() {
//		username.sendKeys("vasutest");
//	}
//	public void typepassword()
//	{
//		password.sendKeys("!Centura1!");
//	}
//	
//	public void LogintoApplication()
//	{
//		loginbutton.click();
//	}
	
	public void LogintoApp(String uname,String pass)
	{
		/*	Utility.waitForWebElement(driver, username).sendKeys(uname);
		Utility.waitForWebElement(driver, password).sendKeys(pass);
		Utility.waitForWebElement(driver, loginbutton).click(); */
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbutton.click(); 
		
		
	}
	
}

