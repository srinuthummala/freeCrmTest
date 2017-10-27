package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactsPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String SheetName = "Sheet0";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage=new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
		
	}
	
	@Test(enabled=false)
	public void selectContactsTest() {
		contactsPage.selectContacts("kumar m");
	}
	
	@DataProvider(name="testData")
	public Object[][] getCRMTestData() {
		Object[][] data = testUtil.getTestData();
		return data;
	}
	@Test(dataProvider="testData")
	public void validateNewContacts(String title, String fn, String ln, String cName) {
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact(title, fn, ln, cName);
	}
	@AfterMethod
	public void quit() {
		driver.close();
	}
	

}
