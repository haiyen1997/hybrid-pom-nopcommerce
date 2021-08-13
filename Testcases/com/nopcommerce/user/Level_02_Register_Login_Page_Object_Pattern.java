package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_02_Register_Login_Page_Object_Pattern {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
				
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
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
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
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
		registerPage.clickToLogoutLink();
		
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_03_Verify_My_Account() {
		homePage.clickToMyAccountLink();
		myAccountPage = new MyAccountPageObject(driver);
		Assert.assertTrue(myAccountPage.isGenderMaleRadioSelected());
		
		Assert.assertEquals(myAccountPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(myAccountPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(myAccountPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTextboxValue(), companyName);
		Assert.assertEquals(myAccountPage.getPageDayDropdownValue(), day);
		Assert.assertEquals(myAccountPage.getPageMonthDropdownValue(), month);
		Assert.assertEquals(myAccountPage.getPageYearDropdownValue(), year);
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
