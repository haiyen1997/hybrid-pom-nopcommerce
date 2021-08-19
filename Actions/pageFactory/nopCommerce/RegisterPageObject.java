package pageFactory.nopCommerce;

import javax.security.auth.callback.ConfirmationCallback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	private WebElement dayDropdown;
	
	@FindBy(name = "DateOfBirthMonth")
	private WebElement monthDropdown;
	
	@FindBy(name = "DateOfBirthYear")
	private WebElement yearDropdown;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Company")
	private WebElement companyTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result' and text() = 'Your registration completed']")
	private WebElement registerSuccessMessage;
	
	@FindBy(css = "a[class='ico-logout']")
	private WebElement logoutLink;
	
	public void clickToGenderMaleRadio() {
		waitForElementClickable(genderMaleRadio);
		clickToElement(genderMaleRadio);

	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(firstNameTextbox);
		sendKeyToElement(firstNameTextbox, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(lastNameTextbox);
		sendKeyToElement(lastNameTextbox, lastName);
	}

	public void selectDayDropDown(String day) {
		waitForElementVisible(dayDropdown);
		selectItemInDefaultDropdown(dayDropdown, day);
	}

	public void selectMonthDropDown(String month) {
		waitForElementVisible(monthDropdown);
		selectItemInDefaultDropdown(monthDropdown, month);
	}

	public void selectYearDropDown(String year) {
		waitForElementVisible(yearDropdown);
		selectItemInDefaultDropdown(yearDropdown, year);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(emailTextbox);
		sendKeyToElement(emailTextbox, emailAddress);
	}

	public void enterToCompanyTextbox(String companyName) {
		waitForElementVisible(companyTextbox);
		sendKeyToElement(companyTextbox, companyName);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(passwordTextbox);
		sendKeyToElement(passwordTextbox, password);
	}

	public void enterToConformPasswordTextbox(String password) {
		waitForElementVisible(confirmPasswordTextbox);
		sendKeyToElement(confirmPasswordTextbox, password);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(registerButton);
		clickToElement(registerButton);

	}

	public void clickToLogoutLink() {
		waitForElementClickable(logoutLink);
		clickToElement(logoutLink);
	}

	public boolean isRegisterSuccessMessageDisplay() {
		waitForElementVisible(registerSuccessMessage);
		return isElementDisplayed(registerSuccessMessage);
	}
}
