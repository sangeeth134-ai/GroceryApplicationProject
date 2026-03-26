package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//input[@name='username']")WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")WebElement passwordfield;
	@FindBy(xpath = "//button[text() = 'Sign In']")WebElement submitbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboardtile;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement applicationtitle;

	
	public LoginPage enterUsername(String username)
	{
		
		usernamefield.sendKeys(username);
		return this;
		
		
	}
	
	public LoginPage  enterPassword(String password)
	{
		
		passwordfield.sendKeys(password);
		return this;
	}

	
	public HomePage  clickSubmitbutton()
	{
		submitbutton.click();
		return new HomePage(driver);
		
	}
	
	//Assertions
	public boolean isDashboardDisplayed() {
		
		return dashboardtile.isDisplayed();
		
	}
	
	public String getTextFromApplicationTitle() {
		
		return applicationtitle.getText();
	}
	
	

}
