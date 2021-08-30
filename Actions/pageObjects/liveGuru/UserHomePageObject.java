package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPageObject clickToMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_AT_FOOTER);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_AT_FOOTER);
		return PageGenerator.getUserLoginPage(driver);
	}

}
