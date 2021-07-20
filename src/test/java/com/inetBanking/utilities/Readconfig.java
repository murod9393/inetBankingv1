package com.inetBanking.utilities;


import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig {
	Properties prop;
	
	
	public Readconfig()  {
		try{
			prop = new Properties();
		FileInputStream fis = new FileInputStream("./Configuration\\config.properties");
		prop.load(fis);
		}catch(Exception e) {
			System.out.println("exception " + e.getMessage());
		}
	
	}
	
	public String getApplicationURL() {
		return prop.getProperty("baseURL");
	}
	
	public String getUsername() {
		return prop.getProperty("username");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getChromepath() {
		return prop.getProperty("chromepath");
	}
	
	public String getIEpath() {
		return prop.getProperty("iepath");
	}
	
	public String getFireFoxpath() {
		return prop.getProperty("firefoxpath");
	}


}


