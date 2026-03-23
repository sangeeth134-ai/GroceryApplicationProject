package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

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

	public void clickOnNewButtonInManageNewsField() {

		newbutton.click();
	}

	public void enterNewsIntheNewsField(String news) {

		enterthenews.sendKeys(news);
	}

	public void clickOnSaveButtonInManageNewsPage() {

		savebutton.click();
	}
	
	
	public void clickOnSearchButtonInManageNewsPage() {
		
		searchmenubutton.click();
	}
	
	
	public void enterTheTitle(String title) {
		
		entertitle.sendKeys(title);
	}
	
	public void clickOnSeachSubmitButtonInManageNewsPage() {
		
		searchsubmitbutton.click();
	}
	
	public void clickOnResetButtonInManageNewsPage() {
		resetbutton.click();
	}

}
