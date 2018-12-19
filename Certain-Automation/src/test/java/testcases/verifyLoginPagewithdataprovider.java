package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pageObjects.BaseClass;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class verifyLoginPagewithdataprovider extends BaseClass {

	@Test(dataProvider = "CRMLogin1")
	public void validLogin(String uname, String password)

	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		LogOutPage logoutPage = PageFactory.initElements(driver, LogOutPage.class);
		// loginPage.typeUsername();
		// loginPage.typepassword();
		// loginPage.LogintoApplication();
		loginPage.LogintoApp(uname, password);

		logoutPage.logOutApplication();

	}

	@DataProvider(name = "CRMLogin")
	// name should be same
	// no .of parameters in the test should be equal to the no.of columns in your
	// data provider
	public Object[][] getLoginData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "vasutest";
		data[0][1] = "!Centura1!";
		data[1][0] = "Selenium_50";
		data[1][1] = "Abcd@123456";

		return data;
	}

	@DataProvider(name = "CRMLogin1")
	// name should be same
	// no .of parameters in the test should be equal to the no.of columns in your
	// data provider
	public Object[][] getLoginData1() {
		Object[][] data = new Object[DataProviderFactory.getExcel().getNumberOfRows("Users")][2];

		int row = DataProviderFactory.getExcel().getNumberOfRows("Users");
		//System.out.println("No of Rows : " + row);
		
		for (int i = 0; i < row; i++) {
			data[i][0] = DataProviderFactory.getExcel().getStringData("Users", i, 0);
			data[i][1] = DataProviderFactory.getExcel().getStringData("Users", i, 1);

		}

		return data;

	}
}
