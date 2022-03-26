package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.OrderPageUI;

public class UserOrderPageObject extends BasePage{
	WebDriver driver;
	
	public UserOrderPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
