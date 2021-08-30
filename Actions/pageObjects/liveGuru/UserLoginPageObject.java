package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPageObject clickToCreateAnAccountButtonn() {
		waitForElementClickable(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToElement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		return PageGenerator.getUserRegisterPage(driver);
	}

}
