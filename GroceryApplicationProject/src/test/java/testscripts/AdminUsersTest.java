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

	@Test (description = "Validate whether user is able to create a new user")

	public void verifyWhetherUserIsAbletoAddNewUser() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();

		HomePage home = new HomePage(driver);
		home.clickMoreInfoButton();

		//faker utility 
		FakerUtility fakerutility = new FakerUtility();
		String newusername = fakerutility.createRandomUsername();
		String newpassword = fakerutility.createRandomPassword();
		String newusertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		

		AdminUsersPage adminusers = new AdminUsersPage(driver);
		adminusers.clickNewbutton();
		adminusers.enterUsernameOnUsernameField(newusername);
		adminusers.enterPasswordOnPasswordField(newpassword);
		adminusers.selectUserType(newusertype);
		adminusers.clickSaveButton();
		
		boolean savebuttondisplay = adminusers.isSaveButtonDisplayed();
		Assert.assertFalse(savebuttondisplay,Constants.ADDNEWUSERERROR);

	}

	@Test  (description = "Validate whether user is able to search a user")
	public void verifyWhetherUserIsAbletoSearchUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();

		HomePage home = new HomePage(driver);
		home.clickMoreInfoButton();

		String searchusername = ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		String searchusertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");

		AdminUsersPage adminusers = new AdminUsersPage(driver);
		adminusers.clickSearchMenuButton();
		adminusers.enterUsernameOnSearchUserNameField(searchusername);
		adminusers.selectUserTypeForSearch(searchusertype);
		adminusers.clickSearchSubmitButton();
		
		String adminusertile = adminusers.isAdminUsersTitleDisplayed();
		Assert.assertEquals(adminusertile,Constants.USERSEARCHERROR);
		

	}

	@Test  (description = "Validate whether user is able to reset the page")
	public void verifyWhetherUserIsAbletoReset() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String Password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(Password);
		login.clickSubmitbutton();

		HomePage home = new HomePage(driver);
		home.clickMoreInfoButton();

		AdminUsersPage adminusers = new AdminUsersPage(driver);
		adminusers.clickResetButton();
		
		String adminusersheading = adminusers.isAdminUsersTitleDisplayed();
		Assert.assertEquals(adminusersheading, "Admin Users", Constants.ADMINUSERSRESETERROR);

	}

}
