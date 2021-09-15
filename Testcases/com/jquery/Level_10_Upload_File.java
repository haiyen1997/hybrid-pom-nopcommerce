package com.jquery;

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
import pageObjects.jQuery.PageGenerator;
import pageObjects.jQuery.UploadPageObject;

public class Level_10_Upload_File extends BaseTest{
	WebDriver driver;
	UploadPageObject uploadPage;
	String aName = "a.png";
	String fName = "f.jpg";
	String eName = "e.jpg";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {		
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGenerator.getUploadPage(driver);
	}

	@Test
	public void TC_01_Upload_One_File() {		
		uploadPage.uploadFiles(aName);
		
		//Verify file is loaded successfully
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(aName));
		
		//Click Upload button
		uploadPage.clickToStartButtonByFileName(aName);
		
		//Verify file is uploaded successfully
		Assert.assertTrue(uploadPage.isFileNameUploadedSuccess(aName));
	}
	
	@Test
	public void TC_02_Upload_Two_File() {		
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadFiles(aName,fName);
		
		//Verify file is loaded successfully
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(aName));
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(fName));
		
		//Click Upload button
		uploadPage.clickToStartButtonByFileName(aName);
		uploadPage.clickToStartButtonByFileName(fName);
		
		//Verify file is uploaded successfully
		Assert.assertTrue(uploadPage.isFileNameUploadedSuccess(aName));
		Assert.assertTrue(uploadPage.isFileNameUploadedSuccess(fName));
	}
	
	@Test
	public void TC_03_Upload_Three_File() {		
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadFiles(aName,fName, eName);
		
		//Verify file is loaded successfully
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(aName));
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(fName));
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(eName));
		
		//Click Upload button
		uploadPage.clickToStartButtonByFileName(aName);
		uploadPage.clickToStartButtonByFileName(fName);
		uploadPage.clickToStartButtonByFileName(eName);
		
		//Verify file is uploaded successfully
		Assert.assertTrue(uploadPage.isFileNameUploadedSuccess(aName));
		Assert.assertTrue(uploadPage.isFileNameUploadedSuccess(fName));
		Assert.assertTrue(uploadPage.isFileNameUploadedSuccess(eName));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
