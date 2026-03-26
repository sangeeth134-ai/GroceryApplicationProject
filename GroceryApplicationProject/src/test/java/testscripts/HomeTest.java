package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


import automationcore.TestNgBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNgBase{
	@Test(description = "Validate user is able to logout", retryAnalyzer = retry.Retry.class)
	
	public void verifyUserisAbleToSuccessfullyLogout() throws IOException {
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();
		
		HomePage home = new HomePage(driver);
		home.clickAdminicon();
		home.clickLogoutButton();
		
		String actual = home.getTextFromApplicationTitle();
		String expected = "7rmart supermarket";
		
		Assert.assertEquals(actual, expected, Constants.LOGOUTERROR);
		
	}

}
