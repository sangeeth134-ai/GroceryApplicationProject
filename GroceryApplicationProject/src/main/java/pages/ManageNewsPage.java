package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNewsPage {
	
    WaitUtility wait;
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchmenubutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(id = "news")
	WebElement enterthenews;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement entertitle;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchsubmitbutton;
	@FindBy(xpath ="//h4[text()='Manage News' and @class='card-title']")
	WebElement managenewstext;
	@FindBy(xpath = "//h1[text()='Manage News' and @class='m-0 text-dark']")
	WebElement managenewsheading;
	
	public ManageNewsPage clickOnNewButtonInManageNewsField() {

		newbutton.click();
		return this;
	}

	public ManageNewsPage enterNewsIntheNewsField(String news) {

		enterthenews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickOnSaveButtonInManageNewsPage() {

		savebutton.click();
		return this;
	}
	
	
	public ManageNewsPage clickOnSearchButtonInManageNewsPage() {
		
		searchmenubutton.click();
		return this;
	}
	
	
	public ManageNewsPage enterTheTitle(String title) {
		
		entertitle.sendKeys(title);
		return this;
	}
	
	public ManageNewsPage clickOnSeachSubmitButtonInManageNewsPage() {
		
		searchsubmitbutton.click();
		return this;
	}
	
	public ManageNewsPage clickOnResetButtonInManageNewsPage() {
		
		wait.waitUntilElementToBeClickable(driver, resetbutton);
		resetbutton.click();
		return this;
	}
	
	
	//Assertions
	public boolean isSaveButtonDisplayed() {
		
		return savebutton.isDisplayed();
	}
	
	public String isManageNewsTextDisplayed() {
		
		return managenewstext.getText();
	}
	
	public String isManageNewsHeadingDisplayed() {
		
		return managenewsheading.getText();
	}

}
