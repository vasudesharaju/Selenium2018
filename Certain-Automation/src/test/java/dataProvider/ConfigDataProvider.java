package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		try {
			pro=new Properties();
			pro.load(new FileInputStream(new File("./Config/Config.properties")));
			
		} catch(Exception e)
		{
		
		System.out.println("Not able to load,please check logs" +e.getMessage());
	}
		
		

}
	
	public String geBrowser()
	{
		return pro.getProperty("browser");
		
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("StagingApplicationURL");
	}
	public String getProdURL() {
		return pro.getProperty("ProdApplicationURL");
	}
	
	public String getValueFromConfig(String key)
	{
		return pro.getProperty(key);
	}
}
