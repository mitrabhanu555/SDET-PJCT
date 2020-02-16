package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
//read the from properties file
public class ReadConfig {
	
	Properties pro;
	//creating a constructor
	public ReadConfig() {
		//(./) it support in java classes as well as in properties file is equal with system.getProperty("user.dir")
		
		File src = new File("./configuration\\config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Exception is " + e.getMessage());
		}
			
	}
	
	public String getApplicationURL() {
		
		String url = pro.getProperty("baseUrl");
		return url;
	}

    public String getUsername() {
		
		String userName = pro.getProperty("username");
		return userName;
		
		
	}
    
    public String getPassword() {
		
		
		  String password = pro.getProperty("password");
		  return password;
		
	}
	
    public String getChromepath() {
		
		
		  String chromepath = pro.getProperty("chromepath");
		  return chromepath;
		
	}
    
    public String getFirefoxpath() {
		
		
		  String firefoxpath = pro.getProperty("firefoxpath");
		  return firefoxpath;
		
	}
	
	
}
