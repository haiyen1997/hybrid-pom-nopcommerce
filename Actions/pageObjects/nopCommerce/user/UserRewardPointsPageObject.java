package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RewardPointsPageUI;

public class UserRewardPointsPageObject extends BasePage{
	 WebDriver driver;
	
	public UserRewardPointsPageObject(WebDriver _driver) {
		driver = _driver;
	}

}
