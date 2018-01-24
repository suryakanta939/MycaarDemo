package com.Mycaar.pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mycaar.commonUtils.ActionFunctions;
import com.Mycaar.commonUtils.SelectFunctions;
import com.Mycaar.commonUtils.WaitForWebPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogIn {


	static WebDriver driver;
	static WebElement element;
	static List<WebElement> elements;
	static ExtentTest test;
	/*
	 * here going to store the element for the registration page
	 * 
	 * 
	 */	
	@FindBy(id="loginform-username")
	public WebElement userName;

	@FindBy(xpath="//input[@type='password']")
	WebElement passWord;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//i[@class='fa fa-ellipsis-v']")
	WebElement imageMenu;
	
	@FindBy(xpath="//button[text()='Logout']")
	WebElement logout;

	@FindBy(xpath="//p[@class='page-title']")
	WebElement title;
	
	public LogIn(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToMyCaar(String un,String pwd){
		WaitForWebPage.waitFortheElementToBeVisible(driver, title, 10);
		userName.sendKeys(un);
		test.log(LogStatus.INFO, "entered the user name");
		passWord.sendKeys(pwd);
		test.log(LogStatus.INFO, "enetred the password");
		submit.click();
		test.log(LogStatus.INFO, "clciked on the login button");
	}
 
	public void logoutfroMycaar(){
		ActionFunctions.moveToElementByCordinate(driver, imageMenu);
		imageMenu.click();
		WaitForWebPage.waitFortheElementToBeVisible(driver, logout, 10);
		logout.click();
	}

}
