package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	Readconfig rd = new Readconfig();
	public String baseURL = rd.getApplicationURL();
	public String username = rd.getUsername();
	public String password = rd.getPassword();
	public static WebDriver driver;
	 public static Logger logger;
	
	
	 @Parameters("browser")
	 @BeforeClass
	public void setup(String browser) {
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//driver = new ChromeDriver();
		 
		 logger = LogManager.getLogger(Base.class);
		 
		 if(browser.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 }else if(browser.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver.", "C:\\Users\\Murod\\eclipse-workspace\\inetBankingv1\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		 }else if(browser.equals("ie")){
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Murod\\eclipse-workspace\\inetBankingv1\\Drivers\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		 }
	
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
		 
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname ) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	//user defined function
		public String randomString() {
			
		return	RandomStringUtils.randomAlphabetic(8);		
		}
	

}
