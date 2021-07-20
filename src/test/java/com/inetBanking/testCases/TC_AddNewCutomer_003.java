package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.AddCustomerPage;
import com.inetBankingv1.pageObjects.LoginPage;

public class TC_AddNewCutomer_003 extends Base {

	
	
	@Test
	public void addNewCustomer() throws Exception{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.clickNewCustomer();
		logger.info("Providing Customer details...");
		ac.setName("Murod");
		ac.setGender();
		ac.setDOB("03", "21", "1993");
		ac.setAddress("1900 AVE W\r\n" + 
				"APT 4K");
		ac.setCity("Urgench");
		ac.setState("Khorezm");
		ac.setPinNum(225566);
		ac.settelephono("9875645285");
		String email = randomString()+"@gmail.com";
		ac.setEmailid(email);
		ac.setPassword("123456789");
		ac.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean rep = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(rep) {
			logger.info("Test case addNewCustomer passed");
			Assert.assertTrue(true);
		}else {
			logger.error("Test case addNewCustomer failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
	
}
