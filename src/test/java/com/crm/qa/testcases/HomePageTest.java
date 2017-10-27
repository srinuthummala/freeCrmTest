package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(enabled=true)
	public void verifyHomePageTitleTest() {
		String homePageTItle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTItle, "CRMPRO", "homepage title not matched");
	}

	@Test
	public void verifyUsernameTest() {
		testUtil.switchToFrame();
		boolean flag = homePage.usernameLableVerify();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.checkContactsLable(), "not a contacts link");
	}
	
	@AfterMethod
	public void quit() {
		driver.close();
	}
}
