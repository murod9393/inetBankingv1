package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.utilities.XLUtils;
import com.inetBankingv1.pageObjects.LoginPage;

public class TC_DDT_002 extends Base {
	String xlfilePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\inetBanking\\testData\\book.xlsx";
	String xlsheet = "cridentials";

	@DataProvider(name = "cridentials")
	public Object[][] getData() throws IOException {

		int rowNum = XLUtils.getRowCount(xlfilePath, xlsheet);
		int colNum = XLUtils.getCellCount(xlfilePath, xlsheet, rowNum);
		String loginData[][] = new String[rowNum][colNum];
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(xlfilePath, xlsheet, i, j);
			}
		}
		return loginData;
	}

	@Test(dataProvider = "cridentials")
	public void loginDDT(String user, String pass) throws IOException {
		System.out.println("DDT started...");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username provided");
		lp.setPassword(pass);
		logger.info("Password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}else {
			lp.clickLogOutBtn();
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
			logger.info("Login passed");
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
