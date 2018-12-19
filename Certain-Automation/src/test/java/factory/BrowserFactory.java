package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	public static WebDriver startApplication(String browserName ,String applicationURL )
	{
		System.out.println("*****Starting application on "+browserName + "****");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");	
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox"))
			
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");	
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Sorry we do not support " +browserName + "Please provide Chrome,Firefox or IE");;
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(applicationURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		System.out.println("*** Application started on " + browserName + "****");
		return driver;
	}
	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
	}

}
