package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//img[@class='img-circle']")WebElement adminicon;
	@FindBy(xpath="//a[@class='dropdown-item' and contains(@href,'logout')]")WebElement logoutbutton;
	@FindBy(xpath="//a[contains(@href,'list-admin') and @class='small-box-footer']")WebElement moreinfobutton;
	@FindBy(xpath="//a[@class='small-box-footer' and contains(@href,'list-news')]")WebElement managenewsmoreinfobutton;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement applicationtitle;
	
	public void clickAdminicon() {
		adminicon.click();
		
	}
	
	public void clickLogoutButton() {
		
		logoutbutton.click();
		
	}
	
	public void clickMoreInfoButton() {
		
		moreinfobutton.click();
		
	}
	
	public void clickManageNewMoreInfoButton() {
		
		managenewsmoreinfobutton.click();
	}
	
	public String getTextFromApplicationTitle() {
		
		return applicationtitle.getText();
	}
	
	
	
	

}
