package pageObjects.alada;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.alada.HomePageUI;
import pageUIs.alada.LoginPageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyCourseDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_COURSE_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_COURSE_LINK);
	}
}
