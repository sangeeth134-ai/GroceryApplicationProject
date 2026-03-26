package testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import automationcore.TestNgBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase{
	
	HomePage home;

	@Test(priority=1, description = "Validate user with valid username and password", groups ="smoke")
	
	public void  verifyUserLoginWithValidCredentials() throws IOException
	{
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();
		
		boolean dashboarddisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay, Constants.VALIDCRENDIALERROR);

	}
	
	 
	
	@Test(priority=2, description = "Validate user with valid username and Invalid password")
	public void  verifyUserLoginValidUsernameAndInvalidPassword() throws IOException
	{
		
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password).clickSubmitbutton();
		
		String actual = login.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, Constants.INVALIDPASSWORDERROR);
		
		
	
	}
	
	@Test(priority=3,description = "Validate user with Invalid username and valid password")
	
	public void  verifyUserLoginInValidUsernameAndValidPassword() throws IOException
	{
		
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(2, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password).clickSubmitbutton();
		
		String actual = login.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMERROR);
		
		
	
	}
	
	@Test(priority=4, description = "Validate user with invalid credentials", groups ="smoke", dataProvider = "loginProvider" )
	public void  verifyUserLoginWithInvalidCredentials(String username, String Password) throws IOException
	{
		
		//String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String Password = ExcelUtility.readStringData(3, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();
		
		String actual = login.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, Constants.INVALIDVALIDCRENDIALERROR);
	
	}

	@DataProvider(name = "loginProvider") 
 	public Object[][] getDataFromDataProvider() throws IOException { 
  
 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
 				// new Object[] {ExcelUtility.getStringData(3, 
 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
 		}; 
 	}

}
