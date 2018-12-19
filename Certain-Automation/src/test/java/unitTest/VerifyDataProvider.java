package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class VerifyDataProvider {
	
	@Test
	public void testExcel()
	{
		ExcelDataProvider excel= new ExcelDataProvider();
		Assert.assertEquals(excel.getStringData("Users", 0, 0),"vasutest");
		
		
	}
	@Test
	public void testConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		Assert.assertEquals(config.geBrowser(),"Chrome");
		Assert.assertEquals(config.getValueFromConfig("name"), "Vasudha");
	
		
		
	}

}
