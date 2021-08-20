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
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_06_Register_Login_Page_Generator_02_Init_Page_Object_Class extends BaseTest{
	WebDriver driver;
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {		
		driver = getBrowserDriver(browserName, url);
		
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
		
		//dua viec khoi tao 1 page vao trong ham cua page object class
		//tu page A qua page B
		//co tinh chat ket noi giua 2 page
		//page B se chay tiep cac step
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
		myAccountPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(myAccountPage.isGenderMaleRadioSelected());
		
		Assert.assertEquals(myAccountPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(myAccountPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(myAccountPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTextboxValue(), companyName);
		Assert.assertEquals(myAccountPage.getPageDayDropdownValue(), day);
		Assert.assertEquals(myAccountPage.getPageMonthDropdownValue(), month);
		Assert.assertEquals(myAccountPage.getPageYearDropdownValue(), year);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
