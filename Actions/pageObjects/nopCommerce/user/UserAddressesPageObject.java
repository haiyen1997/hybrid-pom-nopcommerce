package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AddressesPageUI;

public class UserAddressesPageObject extends BasePage{
	 WebDriver driver;
	
	public UserAddressesPageObject(WebDriver _driver) {
		driver = _driver;
	}
}
