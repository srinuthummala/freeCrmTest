package com.crm.qa.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	//==========signup info page1===============
	@FindBy(id="payment_plan_id")
	WebElement selectEdition;

	@FindBy(name="first_name")
	WebElement firstName;

	@FindBy(name="surname")
	WebElement lastName;

	@FindBy(name="email")
	WebElement email;

	@FindBy(name="email_confirm")
	WebElement emailConfirm;

	@FindBy(name="username")
	WebElement userName;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="passwordconfirm")
	WebElement passwordConfirm;

	@FindBy(name="agreeTerms")
	WebElement termsCheck;

	@FindBy(name="submitButton")
	WebElement submitBtn;

	@FindBy(xpath="//small[@class='help-block' ]")
	WebElement errorMsg;
	
	//========profile information page2=========
	
	@FindBy(xpath="//div[contains(text(), 'Your company information and profile detail')]")
	WebElement profileInfo;
	
	@FindBy(name="company_name")
	WebElement companyName;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="copy_address")
	WebElement addressCheckbox;
	
	@FindBy(name="btnSubmit")
	WebElement btnSubmit;
	

	

	//=========initialize =======
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	//======actions====
	public void signUp(String edition, String fn, String ln, String mail, String mailCnf, String un, String pass, String passCnf) {
		Select editionSelect = new Select(selectEdition);
		editionSelect.selectByVisibleText(edition);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(mail);
		emailConfirm.sendKeys(mailCnf);
		userName.sendKeys(un);
		password.sendKeys(pass);
		passwordConfirm.sendKeys(passCnf);
		termsCheck.click();
		submitBtn.click();

	}
	
	public void profileInfo(String cName, String phoneNum, String countryName){
	
		companyName.sendKeys(cName);
		phone.sendKeys(phoneNum);
		
		Select editionSelect = new Select(country);
		editionSelect.selectByVisibleText(countryName);	
		
		addressCheckbox.click();
		btnSubmit.click();

	}



	public boolean isAlertPresent() 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}   // isAlertPresent()
}
