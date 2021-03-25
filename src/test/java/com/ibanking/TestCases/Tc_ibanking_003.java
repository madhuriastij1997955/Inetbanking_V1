package com.ibanking.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.ibanking.PageObjects.AddNewCustmer;
import com.ibanking.PageObjects.LoginPage;

public class Tc_ibanking_003 extends BaseClass {
	@Test
	public void addCustomer() throws InterruptedException {
		  LoginPage l=new LoginPage(driver);
		  driver.get(url);
		  l.setUsername(userid);
		  l.setPassword(userpwd);
           l.clickOnSubmit();	
           Thread.sleep(2000);
		AddNewCustmer a=new AddNewCustmer(driver);
		a.addCustmoer();
		a.enterUserName("madhuri");
		a.selectGender();
		a.enterDob("22","03","1995");
		a.enterAdd("kopperapadu");
		a.enterCity("addanki");
		a.enterState("AP");
		a.enterPin("523303");
		a.enterMobleNum("9553668757");
		a.enterEmail(genterRandomString()+"@gmail.com");
		a.enterPwd("abdjjjf");
		a.clickOnsub();
	}
	
	public String genterRandomString() {
		return RandomStringUtils.randomAlphabetic(10);
	}

}
