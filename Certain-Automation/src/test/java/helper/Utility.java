package helper;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	
	public static String getCurrentDate_Time()
	{
     Date data=new Date();
		DateFormat dateFormater=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		return dateFormater.format(data);
		
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		
	File src=ts.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+"\\Screenshots/\\RM _"+getCurrentDate_Time()+".png";
	try {
		FileUtils.copyFile(src, new File(destination));
	} catch (IOException e) {
		System.out.println("Unable to capture screenshot"+e.getMessage());
	}
	return destination;
	
		
	}
	
	
	// This lib will wait for specified amount of time
	public static void sleep(int second)
	{
	 try {
		Thread.sleep(second*1000);
	} catch (InterruptedException e) {
		
	}	
	}
	
	public static String getAlertText(WebDriver driver)
	{
		Alert alt=new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent());
		return alt.getText();
	}
	public static void AcceptAlert(WebDriver driver)
	{
		Alert alt=new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent());
		alt.accept();
	}
	public static  void dismissAlert(WebDriver driver)
	{
		Alert alt=new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent());
		alt.dismiss();
	}

	 public static  void switchToFrameUsingIndex(WebDriver driver,int index)
	 {
	   new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
}
	 public static void switchToFrameUsingIdandName(WebDriver driver,String IdorName)
	 {
		 new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdorName)); 
	 }
	 public static void switchToFrameUsingIdorName(WebDriver driver,WebElement web)
	 {
		 new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(web));
	 }
	 
	 public static WebElement waitForWebElement(WebDriver driver,WebElement element) {
		 
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 System.out.println("Trying to find element before operation");
		 wait.until(ExpectedConditions.invisibilityOf(element));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 System.out.println("Element found and ready for operation");
		 return element;
	 }
	 public static WebElement syncWebElement(WebDriver driver,WebElement element)
	 {
		waitForWebElement(driver,element);
		highLightElement(driver,element);
		return element;
	 }
	
	 public static void highLightElement(WebDriver driver,WebElement element)
	 {
		
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			 
			 try 
			 {
			 Thread.sleep(500);
			 } 
			 catch (InterruptedException e) {
			  
			 System.out.println(e.getMessage());
			 } 
			  
			 js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
			 }
	 
	
	 }
