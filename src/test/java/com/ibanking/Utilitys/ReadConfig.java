package com.ibanking.Utilitys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	public Properties po;
	public ReadConfig()  {
		
		try {
			System.out.println("reading");
		FileInputStream fis=new FileInputStream("./Configuration\\config.properties");
		po=new Properties();
		po.load(fis);
		}
		catch(Exception e) {
			System.out.println("the msg is"+e.getMessage());
			
		}
		
		
		
	}
	
	public String getUrl() {
		String s= po.getProperty("url");
		return s;
		
	}
	public String getUserid() {
		return po.getProperty("userid");
		
	}
	public String getUserPwd() {
		return po.getProperty("userpwd");
		
	}
	public String getChropath() {
		return po.getProperty("chropath");
		
	}
	public String getFirepath() {
		return po.getProperty("firepath");
		
	}
	
	

}
