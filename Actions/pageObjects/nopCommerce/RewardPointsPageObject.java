package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RewardPointsPageUI;

public class RewardPointsPageObject extends BasePage{
	 WebDriver driver;
	
	public RewardPointsPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
