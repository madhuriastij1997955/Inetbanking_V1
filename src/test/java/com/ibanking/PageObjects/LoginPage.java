package com.ibanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="uid") WebElement uname;
	@FindBy(name="password") WebElement pwd;
	@FindBy(name="btnLogin") WebElement btn;
	@FindBy(xpath="//a[contains(text(),'Log out')]") WebElement logout;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setUsername(String username) {
		uname.sendKeys(username);
		
	}
	public void setPassword(String password) {
		pwd.sendKeys(password);
		
	}
	public void clickOnSubmit() {
		btn.click();
	}
	public void clickOnLogOut() {
		logout.click();
	}
	

}
