package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;



import automationcore.TestNgBase;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNgBase {
	
	HomePage home;
	AdminUsersPage adminusers;

	@Test (description = "Validate whether user is able to create a new user")

	public void verifyWhetherUserIsAbletoAddNewUser() throws IOException {
		

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();

		adminusers = home.clickMoreInfoButton();

		//faker utility 
		FakerUtility fakerutility = new FakerUtility();
		String newusername = fakerutility.createRandomUsername();
		String newpassword = fakerutility.createRandomPassword();
		String newusertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		
		adminusers.clickNewbutton().enterUsernameOnUsernameField(newusername).enterPasswordOnPasswordField(newpassword).selectUserType(newusertype).clickSaveButton();
		
		boolean savebuttondisplay = adminusers.isSaveButtonDisplayed();
		Assert.assertFalse(savebuttondisplay,Constants.ADDNEWUSERERROR);

	}

	@Test  (description = "Validate whether user is able to search a user")
	public void verifyWhetherUserIsAbletoSearchUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();

		adminusers = home.clickMoreInfoButton();

		String searchusername = ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		String searchusertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");

	
		adminusers.clickSearchMenuButton().enterUsernameOnSearchUserNameField(searchusername).selectUserTypeForSearch(searchusertype).clickSearchSubmitButton();
		
		String adminusertile = adminusers.isAdminUsersTitleDisplayed();
		Assert.assertEquals(adminusertile,Constants.USERSEARCHERROR);
		

	}

	@Test  (description = "Validate whether user is able to reset the page")
	public void verifyWhetherUserIsAbletoReset() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(Password);
		home = login.clickSubmitbutton();

	
		adminusers = home.clickMoreInfoButton();

		adminusers.clickResetButton();
		
		String adminusersheading = adminusers.isAdminUsersTitleDisplayed();
		Assert.assertEquals(adminusersheading, "Admin Users", Constants.ADMINUSERSRESETERROR);

	}

}
