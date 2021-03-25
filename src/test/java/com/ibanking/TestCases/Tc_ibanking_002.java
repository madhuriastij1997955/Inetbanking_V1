package com.ibanking.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ibanking.PageObjects.LoginPage;
import com.ibanking.Utilitys.TestData;

import junit.framework.Assert;

public class Tc_ibanking_002 extends BaseClass {
	
	@Test(dataProvider = "logindata")
	public void testDDT(String uname, String pwd) {
		System.out.println(uname+" "+pwd);
		driver.get("http://demo.guru99.com/V4/");
		LoginPage l=new LoginPage(driver);
		l.setUsername(uname);
		logger.info("username entered");
		l.setPassword(pwd);
		logger.info("password entered");
		l.clickOnSubmit();
		logger.info("clicked on login Button");
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}else{
			l.clickOnLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
	}
	
	public static boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(Exception e) {
			
			return false;
		}
		
	}
	
	
	@DataProvider(name="logindata")
	public String[][] getData() throws Exception {
		
		String fpath="./src/test/java/com/ibanking/TestData/testdata.xlsx";
		String sname="Sheet1";
		int rows=  TestData.getRowNum(fpath, sname);
		int cols=TestData.getCellNum(fpath, sname, 1);
		System.out.println("rows ="+rows +" cols="+cols);
		String data[][]=new String[rows-1][cols];
		for(int i=1; i<rows;i++) {
			
			for(int j=0; j<cols; j++) {
				
			data[i-1][j]=	TestData.getCellData(fpath, sname, i, j);
			//System.out.println(TestData.getCellData(fpath, sname, i, j));
			}
			
		}
		
		return data; 		
		
		
	}
	

}
