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
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGenerator;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {		
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGenerator.getHomePage(driver);
	}

	
	public void TC_01_DataTable_Paging() {		
		//Paging
		homePage.openPagingPageByName("15");
		Assert.assertTrue(homePage.isPageActivedByName("15"));
		homePage.openPagingPageByName("5");
		Assert.assertTrue(homePage.isPageActivedByName("5"));
		homePage.openPagingPageByName("24");
		Assert.assertTrue(homePage.isPageActivedByName("24"));
		homePage.openPagingPageByName("1");
		Assert.assertTrue(homePage.isPageActivedByName("1"));
	}
	
	
	public void TC_02_DataTable_Searching() {		
		//Search in header
		homePage.enterToHeaderTextboxByName("Females", "777");
		homePage.enterToHeaderTextboxByName("Country", "Antigua and Barbuda");
		homePage.enterToHeaderTextboxByName("Males", "803");
		homePage.enterToHeaderTextboxByName("Total", "1580");

	}
	
	
	public void TC_03_DataTable_Verify_Row() {		
		//Verify data of any row
		homePage.enterToHeaderTextboxByName("Females", "777");
		homePage.enterToHeaderTextboxByName("Country", "Antigua and Barbuda");
		homePage.enterToHeaderTextboxByName("Males", "803");
		homePage.enterToHeaderTextboxByName("Total", "1580");
		Assert.assertTrue(homePage.isRowValuesDisplayed("777","Antigua and Barbuda","803","1580"));
		
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByName("Country", "Albania");
		Assert.assertTrue(homePage.isRowValuesDisplayed("24128","Albania","25266","49397"));
		
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByName("Total", "578961");
		Assert.assertTrue(homePage.isRowValuesDisplayed("283821","Algeria","295140","578961"));
	}
	
	
	public void TC_04_DataTable_Action() {		
		//Click on icon delete/ edit of one row
		homePage.clickToRowActionByCounry("Algeria","remove");
		homePage.clickToRowActionByCounry("Albania","remove");
		homePage.clickToRowActionByCounry("Antigua and Barbuda","edit");
	}
	
	@Test
	public void TC_05_DataTable_Editable() {		
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		//Enter text into column + row
		homePage.enterToTextboxAtColumnNameAndRowNumber("Contact Person","3","Automation");
		homePage.sleepInSecond(3);
		homePage.enterToTextboxAtColumnNameAndRowNumber("Order Placed","1","1");
		homePage.sleepInSecond(3);
		homePage.enterToTextboxAtColumnNameAndRowNumber("Company","2","Tiki");
		homePage.sleepInSecond(3);
		
		//Select item in dropdown list
		homePage.selectDropdownAtColumnNameAndRowNumber("Country","2","Malaysia");
		homePage.selectDropdownAtColumnNameAndRowNumber("Country","3","Germany");
		
		homePage.clickToIconAtRowNumber("1","Insert");
		homePage.sleepInSecond(3);
		homePage.clickToIconAtRowNumber("1","Up");
		homePage.sleepInSecond(3);
		homePage.clickToIconAtRowNumber("2","Down");
		homePage.sleepInSecond(3);
		homePage.clickToIconAtRowNumber("3","Remove");
		homePage.sleepInSecond(3);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
