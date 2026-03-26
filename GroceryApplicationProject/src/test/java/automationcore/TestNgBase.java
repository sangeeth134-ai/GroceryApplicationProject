package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenshotUtility;

public class TestNgBase {
	
	Properties prop;
	FileInputStream fs;  
	public WebDriver driver;
	
	@BeforeMethod (alwaysRun = true)
	@Parameters("Browser")
	public void LaunchBrowser(String browser) throws Exception
	{
		prop = new Properties();
		fs = new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		
		if(browser.equalsIgnoreCase("Chrome")){
		driver  = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
		driver  = new FirefoxDriver();	
		}
		else if(browser.equalsIgnoreCase("edge")) {
		driver  = new EdgeDriver();	
		}
		else{
			throw new Exception("Invalid Browser");
		}
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
	
	@AfterMethod (alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
	  
		ScreenshotUtility screenShot = new ScreenshotUtility(); 
	 			screenShot.getScreenshot(driver, iTestResult.getName()); 
	 		} 
		//driver.quit(); 
	  
	 	}


}
