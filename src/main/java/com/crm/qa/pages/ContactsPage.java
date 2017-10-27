package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactsLable;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selectTitle;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement compName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkContactsLable() {
		return contactsLable.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fn, String ln, String cName ) {
		
		Select slectTitle =  new Select(selectTitle);
		slectTitle.selectByVisibleText(title);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		compName.sendKeys(cName);
		saveBtn.click();
		
		
	}

}
