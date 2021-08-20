package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	//Quan ly viec khoi tao cac page object class
	//Moi 1 page chi co 1 ham de goi khoi tao
	//Tran viec new nhieu cho khac nhau
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
}
