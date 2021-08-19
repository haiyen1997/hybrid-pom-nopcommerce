package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePageFactory{

	public LoginPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using ="Email")
	private WebElement emailTextbox;
	
	@FindBy(how = How.ID, using ="Password")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using ="//button[text()='Log in']")
	private WebElement loginButton;
	
	
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(emailTextbox);
		sendKeyToElement(emailTextbox, emailAddress);
	}

	public void clickToLoginButton() {
		waitForElementVisible(loginButton);
		clickToElement(loginButton);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(passwordTextbox);
		sendKeyToElement(passwordTextbox, password);
	}
}
