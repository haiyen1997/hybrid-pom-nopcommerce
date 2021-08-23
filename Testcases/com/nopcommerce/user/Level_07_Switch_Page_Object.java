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

public class Level_07_Switch_Page_Object extends BaseTest{
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
		orderPage = customerInfoPage.openOderPageObject(driver);
		
		//Orders --> Reward Points
		rewardPointsPage = orderPage.openRewardPointsPageObject(driver);
		
		//Reward Points --> Addresses
		addressesPage = rewardPointsPage.openAddressesPageObject(driver);
		
		//Addresses -->Customer Info
		customerInfoPage = addressesPage.openCustomerInfoPageObject(driver);
		
		//Customer Info --> Reward Points
		rewardPointsPage = customerInfoPage.openRewardPointsPageObject(driver);
		
		//Reward Points --> Change password
		changePasswordPage = rewardPointsPage.openChangePasswordPageObject(driver);
		
		//Change password --> Back in stock subscriptions
		backInStockPage = changePasswordPage.openBackInStockSubscriptionsPageObject(driver);
		
		//Back in stock subscription --> my product reviews
		myProductReviewsPage = backInStockPage.openMyProductReviewsPageObject(driver);
				
		//my product reviews --> downloadable products
		downloadProductPage = myProductReviewsPage.openDownloadableProductsPageObject(driver);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
