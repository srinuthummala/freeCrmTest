package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signupPage;
	TestUtil testUtil;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		
	}
	
	@Test(enabled=true)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(enabled=true)
	public void crmLogoTest() {
		boolean flag = loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest()  {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		boolean flag = homePage.usernameLableVerify();
		Assert.assertTrue(flag);
	}
	
	@Test(enabled=false)
	public void signupLinkTest() throws InterruptedException {
		loginPage.signup();
		Thread.sleep(3000);

		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "CRMPRO - CRM Pro for customer relationship management, sales, and support", "page not navigated to Sign Up page");
	}
	
	@AfterMethod
	public void quit() {
		driver.close();
	}
}
