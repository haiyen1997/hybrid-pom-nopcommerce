package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.AddressesPageUI;

public class AddressesPageObject extends BasePage{
	 WebDriver driver;
	
	public AddressesPageObject(WebDriver _driver) {
		driver = _driver;
	}
}
