package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithVisibleText(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByVisibleText(value);

	}

	public void radioButton(WebElement element) {

		element.click();
	}

	public void checkBox(WebElement element) {

		element.click();
	}

	public void mouseRightClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);

		action.contextClick(element).build().perform();
	}

	public void mouseOver(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
	}

}
