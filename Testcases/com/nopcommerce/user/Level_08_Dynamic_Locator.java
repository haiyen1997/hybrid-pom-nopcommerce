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
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyProductReviewsPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.AddressesPageObject;
import pageObjects.nopCommerce.BackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.CustomerInfoPageObject;
import pageObjects.nopCommerce.DownloadableProductsPageObject;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.RewardPointsPageObject;

public class Level_08_Dynamic_Locator extends BaseTest{
	WebDriver driver;
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInfoPageObject customerInfoPage;
	AddressesPageObject addressesPage;
	OrderPageObject orderPage;
	RewardPointsPageObject rewardPointsPage;
	BackInStockSubscriptionsPageObject backInStockPage;
	DownloadableProductsPageObject downloadProductPage;
	ChangePasswordPageObject changePasswordPage;
	MyProductReviewsPageObject myProductReviewsPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {		
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGenerator.getHomePage(driver);
		
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
		orderPage = (OrderPageObject) customerInfoPage.openSiderBarPageName(driver, "Orders");
		
		//Orders --> Reward Points
		rewardPointsPage = (RewardPointsPageObject) orderPage.openSiderBarPageName(driver, "Reward points");
		
		//Reward Points --> Addresses
		addressesPage = (AddressesPageObject) rewardPointsPage.openSiderBarPageName(driver, "Addresses");
		
		//Addresses -->Customer Info
		customerInfoPage = (CustomerInfoPageObject) addressesPage.openSiderBarPageName(driver, "Customer info");
		
		//Customer Info --> Reward Points
		rewardPointsPage = (RewardPointsPageObject) customerInfoPage.openSiderBarPageName(driver, "Reward points");
		
		//Reward Points --> Change password
		changePasswordPage = (ChangePasswordPageObject) rewardPointsPage.openSiderBarPageName(driver, "Change password");
		
	}
	
	@Test
	public void TC_05_Switch_Page() {		
		//Change password --> Back in stock subscriptions
		changePasswordPage.openSiderBarPageByPageName(driver, "Back in stock subscriptions");
		backInStockPage = PageGenerator.getBackInStockSubscriptionsPage(driver);
		
		//Back in stock subscription --> my product reviews
		backInStockPage.openSiderBarPageName(driver, "My product reviews");
		myProductReviewsPage = PageGenerator.getMyProductReviewsPage(driver);
				
		//my product reviews --> downloadable products
		myProductReviewsPage.openSiderBarPageName(driver, "Downloadable products");
		downloadProductPage = PageGenerator.getDownloadableProductsPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
