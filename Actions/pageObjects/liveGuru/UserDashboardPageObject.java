package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.liveGuru.UserDashboardPageUI;

public class UserDashboardPageObject extends BasePage{
	private WebDriver driver;
	
	public UserDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isUserRegisteredSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserDashboardPageUI.USER_REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserDashboardPageUI.USER_REGISTER_SUCCESS_MESSAGE);
	}

	public AdminLoginPageObject openAdminLoginPage() {
		openPageUrl(driver, GlobalConstants.ADMIN_URL);
		return PageGenerator.getAdminLoginPage(driver);
	}

}
