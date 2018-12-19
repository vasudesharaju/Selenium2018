package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.DataProviderFactory;
import helper.Utility;
import pageObjects.BaseClass;
import pageObjects.Contacts;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class CreateContacts extends BaseClass{
	@Test
	public void validLogin()

	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		LogOutPage logoutPage = PageFactory.initElements(driver, LogOutPage.class);
		//Contacts contact=PageFactory.initElements(driver,  Contacts.class);
		
		// loginPage.typeUsername();
		// loginPage.typepassword();
		// loginPage.LogintoApplication();
		loginPage.LogintoApp(DataProviderFactory.getExcel().getStringData("Users", 0,0),DataProviderFactory.getExcel().getStringData("Users", 0,1));
      //  contact.createContactwithoutDate(DataProviderFactory.getExcel().getStringData("Contacts", 0, 0), DataProviderFactory.getExcel().getStringData("Contacts", 0,1));
		logoutPage.logOutApplication();

	
}
}
