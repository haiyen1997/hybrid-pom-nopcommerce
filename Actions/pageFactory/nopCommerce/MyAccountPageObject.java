package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.nopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePageFactory{

	public MyAccountPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(how = How.ID, using = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(how = How.ID, using = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(how = How.NAME, using = "DateOfBirthDay")
	private WebElement dayDropdown;
	
	@FindBy(how = How.NAME, using = "DateOfBirthMonth")
	private WebElement monthDropdown;
	
	@FindBy(how = How.NAME, using = "DateOfBirthYear")
	private WebElement yearDropdown;
	
	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	@FindBy(how = How.ID, using = "Company")
	private WebElement companyTextbox;
	
	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(genderMaleRadio);
		return isElementDisplayed(genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(firstNameTextbox);
		return getAttribute(firstNameTextbox, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(lastNameTextbox);
		return getAttribute(lastNameTextbox, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(emailTextbox);
		return getAttribute(emailTextbox, "value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(companyTextbox);
		return getAttribute(companyTextbox, "value");
	}

	public String getPageDayDropdownValue() {
		waitForElementVisible(dayDropdown);
		return getFirstSelectedItemInDefaultDropdown(dayDropdown);
	}

	public String getPageMonthDropdownValue() {
		waitForElementVisible(monthDropdown);
		return getFirstSelectedItemInDefaultDropdown(monthDropdown);
	}

	public String getPageYearDropdownValue() {
		waitForElementVisible(yearDropdown);
		return getFirstSelectedItemInDefaultDropdown(yearDropdown);
	}
	
}
