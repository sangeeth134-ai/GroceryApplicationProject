package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;
	
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchmenubutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchsubmitbutton;
	@FindBy(id = "username")
	WebElement usernamefield;
	@FindBy(id = "password")
	WebElement passwordfield;
	@FindBy(id = "user_type")
	WebElement usertypedropdown;
	@FindBy(id = "un")
	WebElement searchusernamefield;
	@FindBy(id = "ut")
	WebElement searchusertypefield;
	
	@FindBy(xpath="//h4[contains(@class,'card-title') and starts-with(text(),'Admin Users')]")
	WebElement adminusertile;
	
	
	public AdminUsersPage clickNewbutton() {
		newbutton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnUsernameField(String newusername) {
		usernamefield.sendKeys(newusername);
		return this;
	}

	public AdminUsersPage enterPasswordOnPasswordField(String newpassword) {

		passwordfield.sendKeys(newpassword);
		return this;
	}

	public AdminUsersPage selectUserType(String newusertype) {

		page.selectDropdownWithValue(usertypedropdown, newusertype);
		
		return this;

	}

	public AdminUsersPage clickSaveButton() {

		wait.waitUntilElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public AdminUsersPage clickSearchMenuButton() {

		searchmenubutton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnSearchUserNameField(String searchusername) {

		searchusernamefield.sendKeys(searchusername);
		return this;

	}

	public AdminUsersPage selectUserTypeForSearch(String searchusertype) {
		
		page.selectDropdownWithVisibleText(searchusertypefield, searchusertype);
		return this;
	}

	public AdminUsersPage clickSearchSubmitButton() {

		searchsubmitbutton.click();
		return this;
	}

	public AdminUsersPage clickResetButton() {

		resetbutton.click();
		return this;
	}
	
	//Assertions
	
	public boolean isSaveButtonDisplayed() {
		
		return savebutton.isDisplayed();
	}
	
	public String isAdminUsersTitleDisplayed() {
		
		return adminusertile.getText();
	}

}
