package com.ibanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ibanking.PageObjects.LoginPage;
import com.ibanking.Utilitys.ReadConfig;

public class Tc_Ibanking_001 extends BaseClass {
	@Test()
	public void login() throws IOException {
		//test=extent.createTest("login");
		logger.info("entered url");
		r=new ReadConfig();
	
		
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		logger.info("entered usernqame");
		
		lp.setUsername(userid);
		logger.info("entered password");
		lp.setPassword(userpwd);
		logger.info("click on submit");
		lp.clickOnSubmit();
		String act_title=driver.getTitle();
		String exp_title="Guru99 Bank Manager HomePage1";
		if(exp_title.equalsIgnoreCase(act_title)) {
			Assert.assertTrue(true);
		}else {
			captureScreenshot(driver,"login" );
			Assert.assertTrue(false);
		}
		
	}
	
	 
}
