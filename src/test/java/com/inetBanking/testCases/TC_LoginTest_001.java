package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingv1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base{

	LoginPage lp;
	
	@Test
	public void loginTest() throws IOException {
		driver.get(baseURL);
		//logger.info("Url launched");
		lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickSubmit();
		logger.info("Clicked Submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("LoginTest is passed");
			
		}else {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
