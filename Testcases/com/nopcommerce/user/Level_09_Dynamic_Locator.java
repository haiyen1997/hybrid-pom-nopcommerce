package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerator;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.UserOrderPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointsPageObject;

public class Level_09_Dynamic_Locator extends BaseTest{
	WebDriver driver;
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressesPageObject addressesPage;
	UserOrderPageObject orderPage;
	UserRewardPointsPageObject rewardPointsPage;
	UserBackInStockSubscriptionsPageObject backInStockPage;
	UserDownloadableProductsPageObject downloadProductPage;
	UserChangePasswordPageObject changePasswordPage;
	UserMyProductReviewsPageObject myProductReviewsPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {		
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGenerator.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName= "FC";
		day="10";
		month="May";
		year="1999";
		emailAddress="automation"+getRandomNumber()+"@gmail.com";
		companyName="Automation FC";
		password="123456";		
	}

	@Test
	public void TC_01_Register() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadio();
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.selectDayDropDown(day);
		registerPage.selectMonthDropDown(month);
		registerPage.selectYearDropDown(year);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToCompanyTextbox(companyName);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConformPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplay());
		
		homePage = registerPage.clickToLogoutLink();		
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
				
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();		
	}

	@Test
	public void TC_03_Verify_My_Account() {
		customerInfoPage = homePage.clickToMyAccountLink();
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(customerInfoPage.getCompanyNameTextboxValue(), companyName);
		Assert.assertEquals(customerInfoPage.getPageDayDropdownValue(), day);
		Assert.assertEquals(customerInfoPage.getPageMonthDropdownValue(), month);
		Assert.assertEquals(customerInfoPage.getPageYearDropdownValue(), year);
	}

	@Test
	public void TC_04_Switch_Page() {
		//Customer Info chuyển qua page Orders
		orderPage = (UserOrderPageObject) customerInfoPage.openSiderBarPageName(driver, "Orders");
		
		//Orders --> Reward Points
		rewardPointsPage = (UserRewardPointsPageObject) orderPage.openSiderBarPageName(driver, "Reward points");
		
		//Reward Points --> Addresses
		addressesPage = (UserAddressesPageObject) rewardPointsPage.openSiderBarPageName(driver, "Addresses");
		
		//Addresses -->Customer Info
		customerInfoPage = (UserCustomerInfoPageObject) addressesPage.openSiderBarPageName(driver, "Customer info");
		
		//Customer Info --> Reward Points
		rewardPointsPage = (UserRewardPointsPageObject) customerInfoPage.openSiderBarPageName(driver, "Reward points");
		
		//Reward Points --> Change password
		changePasswordPage = (UserChangePasswordPageObject) rewardPointsPage.openSiderBarPageName(driver, "Change password");
		
	}
	
	@Test
	public void TC_05_Switch_Page() {		
		//Change password --> Back in stock subscriptions
		changePasswordPage.openSiderBarPageByPageName(driver, "Back in stock subscriptions");
		backInStockPage = PageGenerator.getUserBackInStockSubscriptionsPage(driver);
		
		//Back in stock subscription --> my product reviews
		backInStockPage.openSiderBarPageName(driver, "My product reviews");
		myProductReviewsPage = PageGenerator.getUserMyProductReviewsPage(driver);
				
		//my product reviews --> downloadable products
		myProductReviewsPage.openSiderBarPageName(driver, "Downloadable products");
		downloadProductPage = PageGenerator.getUserDownloadableProductsPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
