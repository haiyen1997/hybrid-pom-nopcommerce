package com.liveguru_register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.liveGuru.AdminLoginPageObject;
import pageObjects.liveGuru.AdminManageCustomerPageObject;
import pageObjects.liveGuru.PageGenerator;
import pageObjects.liveGuru.UserDashboardPageObject;
import pageObjects.liveGuru.UserHomePageObject;
import pageObjects.liveGuru.UserLoginPageObject;
import pageObjects.liveGuru.UserRegisterPageObject;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserRegisterPageObject userRegisterPage;
	UserDashboardPageObject userDasboardPage;
	AdminLoginPageObject adminLoginPage;
	AdminManageCustomerPageObject adminManageCustomerPage;
	String firstName, lastName, emailAddress, fullName, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {		
		driver = getBrowserDriver(browserName, url);
		
		userHomePage = PageGenerator.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName= "FC";
		emailAddress="automation"+getRandomNumber()+"@hgmail.com";
		fullName = firstName + " " + lastName;
		password = "P@a12345";
	}

	@Test
	public void TC_01_Register_User_At_User_Page() {		
		userLoginPage = userHomePage.clickToMyAccountPage();
		userRegisterPage = userLoginPage.clickToCreateAnAccountButtonn();
		userRegisterPage.enterToFirstNameTextbox(firstName);
		userRegisterPage.enterToLastNameTextbox(lastName);
		userRegisterPage.enterToEmailTextbox(emailAddress);
		userRegisterPage.enterToPasswordTextbox(password);
		userRegisterPage.enterToConfirmPasswordTextbox(password);
		userDasboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertTrue(userDasboardPage.isUserRegisteredSuccessMessageDisplayed());
	}
	
	@Test
	public void TC_02_Search_User_At_Admin_Page() {		
		adminLoginPage = userDasboardPage.openAdminLoginPage();
		
		adminLoginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_USER);
		adminLoginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_PASSWORD);
		adminManageCustomerPage = adminLoginPage.clickToLoginButton();
		adminManageCustomerPage.closePopupWindow();
		adminManageCustomerPage.enterToTextboxAtColumnName("Email",emailAddress);
		adminManageCustomerPage.clickSearchButton();
		Assert.assertFalse(adminManageCustomerPage.isLoadingIconDisappear());
		Assert.assertTrue(adminManageCustomerPage.isUserInfoDisplayedInTable(fullName,emailAddress));
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
