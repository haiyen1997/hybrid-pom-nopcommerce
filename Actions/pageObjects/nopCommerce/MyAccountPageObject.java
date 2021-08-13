package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage{
	private WebDriver driver;

	public MyAccountPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver, MyAccountPageUI.GENDER_MALE_RADIO);
		return isElementDisplayed(driver, MyAccountPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
		return getAttribute(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
		return getAttribute(driver, MyAccountPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		return getAttribute(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getPageDayDropdownValue() {
		waitForElementVisible(driver, MyAccountPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, MyAccountPageUI.DAY_DROPDOWN);
	}

	public String getPageMonthDropdownValue() {
		waitForElementVisible(driver, MyAccountPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, MyAccountPageUI.MONTH_DROPDOWN);
	}

	public String getPageYearDropdownValue() {
		waitForElementVisible(driver, MyAccountPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, MyAccountPageUI.YEAR_DROPDOWN);
	}

}
