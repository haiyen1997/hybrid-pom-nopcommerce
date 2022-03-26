package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage{
	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver _driver) {
		this.driver = _driver;
	}

	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementDisplayed(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public String getPageDayDropdownValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getPageMonthDropdownValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getPageYearDropdownValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

}
