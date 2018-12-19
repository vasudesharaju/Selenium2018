package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import factory.DataProviderFactory;
import helper.Utility;
import pageObjects.BaseClass;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class VerifyLoginpagewithCredentials  extends BaseClass {
	
	LoginPage loginPage;
	LogOutPage logOutPage;
	

		@Test
		public void validLogin()

		{
			
			logger=report.startTest("Start login in CRM");
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			
			// loginPage.typeUsername();
			// loginPage.typepassword();
			// loginPage.LogintoApplication();
			loginPage.LogintoApp(DataProviderFactory.getExcel().getStringData("Users", 0,0),DataProviderFactory.getExcel().getStringData("Users", 0,1));
          Utility.captureScreenshot(driver);
          logger.log(LogStatus.PASS, "User logged in");
			
	
		}
	
		@Test(dependsOnMethods="validLogin",alwaysRun=true)
		public void logOut()
		{
			logger=report.startTest("Start logout from CRM");
			LogOutPage logoutPage = PageFactory.initElements(driver, LogOutPage.class);
			logoutPage.logOutApplication();
			logger.log(LogStatus.INFO, "User logged out");

		
		}
}



