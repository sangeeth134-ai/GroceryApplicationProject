package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import automationcore.TestNgBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase{
	

	@Test(priority=1, description = "Validate user with valid username and password", groups ="smoke")
	
	public void  verifyUserLoginWithValidCredentials() throws IOException
	{
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();
		
		boolean dashboarddisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay, "User was unable to login with valid credentials");

	}
	
	@Test(priority=2)
	public void  verifyUserLoginValidUsernameAndInvalidPassword() throws IOException
	{
		
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();
		
		String actual = login.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, "User was able to login with invalid Password");
		
		
	
	}
	
	@Test(priority=3)
	
	public void  verifyUserLoginInValidUsernameAndValidPassword() throws IOException
	{
		
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(2, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();
		
		String actual = login.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, "User was able to login with invalid Password");
		
		
	
	}
	
	@Test(priority=4, description = "Validate user with invalid credentials", groups ="smoke")
	public void  verifyUserLoginWithInvalidCredentials() throws IOException
	{
		
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(3, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();
		
		String actual = login.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, "User was able to login with invalid Password");
	
	}

	

}
