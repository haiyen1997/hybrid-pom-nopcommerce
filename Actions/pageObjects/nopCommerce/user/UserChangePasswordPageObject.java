package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserChangePasswordPageObject extends BasePage{
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver _driver) {
		driver = _driver;
	}
}
