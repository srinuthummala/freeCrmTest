package com.crm.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase {

	SignUpPage signUpPage;
	LoginPage loginPage;

	public SignUpPageTest(){
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
		loginPage.signup();
	}

	@Test
	public void signUpTest() {
		signUpPage.signUp("Free Edition", "srinu", "thummala", "thummala@s.com", "thummala@s.com", "thummala", "thummala", "thummala");
		boolean flag = signUpPage.isAlertPresent();
		if(flag) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
		}else {
			signUpPage.profileInfo("myCompany", "4578126398", "India");
		}


	}

	@AfterMethod(enabled=false)
	public void quit() {
		driver.quit();
	}
}
