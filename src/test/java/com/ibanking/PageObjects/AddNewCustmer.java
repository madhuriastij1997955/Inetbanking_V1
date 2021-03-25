package com.ibanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustmer {
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='New Customer']") WebElement addcustomer;
	@FindBy(name="name") WebElement entercustname;
	@FindBy(xpath="//input[@value='f']") WebElement selectGender;
	@FindBy(xpath="//input[@id='dob']") WebElement enterDOB;
	@FindBy (xpath="//textarea[@name='addr']") WebElement enterADD;
	@FindBy(name="city") WebElement enterCity;
	@FindBy(name="state") WebElement enterState;
	@FindBy(name="pinno") WebElement enterPINCODE;
	@FindBy(name="telephoneno")WebElement enterPHONENUM;
	@FindBy(name="emailid")WebElement enterEmail;
	@FindBy(name="password")WebElement enterPwd;
	@FindBy(name="sub")WebElement clickOnSubmit;
	
	public AddNewCustmer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void addCustmoer() {
		addcustomer.click();
	}
	public void enterUserName(String uname) {
		
		entercustname.sendKeys(uname);
		
	}
	public void selectGender() {
		selectGender.click();
	}
	public void enterDob(String d,String m,String y) {
		enterDOB.sendKeys(d);
		enterDOB.sendKeys(m);
		enterDOB.sendKeys(y);
		
	}
	public void enterAdd(String add) {
		enterADD.sendKeys(add);
	}
	public void enterCity(String city) {
		enterCity.sendKeys(city);
	}
	public void enterState(String state) {
		enterState.sendKeys(state);
	}
	public void enterPin(String pin) {
		enterPINCODE.sendKeys(pin);
	}
	public void enterMobleNum(String num) {
		enterPHONENUM.sendKeys(num);
	}
	public void enterEmail(String mail) {
		enterEmail.sendKeys(mail);
	}
	public void enterPwd(String pwd) {
		
		enterPwd.sendKeys(pwd);
	}
	public void clickOnsub() {
		clickOnSubmit.click();
	}
	
	

}
