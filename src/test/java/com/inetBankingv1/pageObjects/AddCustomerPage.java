package com.inetBankingv1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
	
	
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addNewCustomerLink;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement  btnSubmit;
	
	public void clickNewCustomer() {
		addNewCustomerLink.click();
	}
	
	
	
	public void setName(String name) {
		txtCustomerName.sendKeys(name);
	}
	
	public void setGender() {
		rdGender.click();
	}
	
	public void setDOB(String mm, String dd, String yyyy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yyyy);
	}
	
	public void setAddress(String address) {
		txtAddress.sendKeys(address);
	}
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void setState(String state) {
		txtState.sendKeys(state);
	}
	
	public void setPinNum(int pin) {
		txtPinno.sendKeys(String.valueOf(pin));
	}
	
	public void settelephono(String tel) {
		txttelephoneno.sendKeys(tel);
	}
	
	public void setEmailid(String email) {
		txtemailid.sendKeys(email);
	
	}
	
	public void setPassword(String password) {
		
		txtpassword.sendKeys(password);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	
	
	


}
