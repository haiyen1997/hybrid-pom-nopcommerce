package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingPageByName(String pageName) {
		waitForElementClickable(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageName);
		clickToElement(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageName);
		sleepInSecond(2);
	}

	public boolean isPageActivedByName(String pageName) {
		waitForElementVisible(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageName);
		return isElementDisplayed(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageName);
	}

	public void enterToHeaderTextboxByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		sendkeyBoardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_BY_ALL_VALUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.ROW_BY_ALL_VALUES, female, country, male, total);
	}

	public void clickToRowActionByCounry(String country, String actionName) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_AND_NAME, country, actionName);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_AND_NAME, country, actionName);		
	}

	public void enterToTextboxAtColumnNameAndRowNumber(String columnName, String rowNumber, String textboxValue) {
		waitForElementVisible(driver, HomePageUI.COLUMN_NAME_POSITION, columnName);
		//index of column depends on column name
		String columnNamePosition = String.valueOf(getElementSize(driver, HomePageUI.COLUMN_NAME_POSITION, columnName) + 1);
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_AT_COLUMN_NAME_AND_ROW_NUMBER, rowNumber, columnNamePosition);
		sendkeyToElement(driver, HomePageUI.TEXTBOX_AT_COLUMN_NAME_AND_ROW_NUMBER, textboxValue, rowNumber, columnNamePosition);
	}

	public void selectDropdownAtColumnNameAndRowNumber(String columnName, String rowNumber, String dropdownItem) {
		waitForElementVisible(driver, HomePageUI.COLUMN_NAME_POSITION, columnName);
		String columnNamePosition = String.valueOf(getElementSize(driver, HomePageUI.COLUMN_NAME_POSITION, columnName) + 1);
		waitForElementClickable(driver, HomePageUI.DROPDOWN_AT_COLUMN_NAME_AND_ROW_NUMBER, rowNumber, columnNamePosition);
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_AT_COLUMN_NAME_AND_ROW_NUMBER, dropdownItem, rowNumber, columnNamePosition);
	}

	public void clickToIconAtRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_ACTION_AT_ROW, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_ACTION_AT_ROW, rowNumber, iconName);
	}

}
