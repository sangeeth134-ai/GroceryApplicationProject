package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	public WebDriver driver;

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
	
	
	public void clickNewbutton() {
		newbutton.click();
	}

	public void enterUsernameOnUsernameField(String newusername) {
		usernamefield.sendKeys(newusername);
	}

	public void enterPasswordOnPasswordField(String newpassword) {

		passwordfield.sendKeys(newpassword);
	}

	public void selectUserType(String newusertype) {

		Select select = new Select(usertypedropdown);
		select.selectByVisibleText(newusertype);

	}

	public void clickSaveButton() {

		savebutton.click();
	}

	public void clickSearchMenuButton() {

		searchmenubutton.click();
	}

	public void enterUsernameOnSearchUserNameField(String searchusername) {

		searchusernamefield.sendKeys(searchusername);

	}

	public void selectUserTypeForSearch(String searchusertype) {

		Select select = new Select(searchusertypefield);
		select.selectByVisibleText(searchusertype);
	}

	public void clickSearchSubmitButton() {

		searchsubmitbutton.click();
	}

	public void clickResetButton() {

		resetbutton.click();
	}
	
	public boolean isSaveButtonDisplayed() {
		
		return savebutton.isDisplayed();
	}
	
	public String isAdminUsersTitleDisplayed() {
		
		return adminusertile.getText();
	}

}
