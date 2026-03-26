package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNgBase;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
//import utilities.FakerUtility;

public class ManageNewsTest extends TestNgBase{
	
	HomePage home;
	ManageNewsPage managenews;
	
	@Test  (priority =1 , description = "Test case to verify whether user is able to add new news")
	public void verifyWhetherUserisAbletoAddNewNews() throws IOException {
	
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();

		managenews = home.clickManageNewMoreInfoButton();
		
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
			
		managenews.clickOnNewButtonInManageNewsField().enterNewsIntheNewsField(news).clickOnSaveButtonInManageNewsPage();
		
		boolean savebuttondisplay =  managenews.isSaveButtonDisplayed();
		Assert.assertFalse(savebuttondisplay,Constants.ADDNEWNEWSERROR);
		
		
	}
	
	@Test (priority =2 , description = "Test case to verify whether user is able search the news")
	public void verifyWhetherUserIsAbletoSearchNews() throws IOException {
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();

		managenews = home.clickManageNewMoreInfoButton();
		
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.clickOnSearchButtonInManageNewsPage().enterTheTitle(news).clickOnSeachSubmitButtonInManageNewsPage();
		
		String managenewstext = managenews.isManageNewsTextDisplayed();
		Assert.assertEquals(managenewstext, "Manage News",  Constants.NEWSSEARCHERROR);
		
		
	}
	
	@Test (priority= 3 , description = "Test case to verify whether user is able to reset the news list")
	public void verifyWhetherUserIsAbletoReset() throws IOException {
		
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();

		managenews = home.clickManageNewMoreInfoButton();
		
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		
		managenews.clickOnSearchButtonInManageNewsPage().enterTheTitle(news).clickOnSeachSubmitButtonInManageNewsPage().clickOnResetButtonInManageNewsPage();
		
		String managenewsheadingtext = managenews.isManageNewsHeadingDisplayed();
		Assert.assertEquals(managenewsheadingtext, "Manage News",  Constants.MANAGENEWSRESETERROR); 
		
		
	}

}
