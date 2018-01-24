package com.Mycaar.pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mycaar.commonUtils.ActionFunctions;
import com.Mycaar.commonUtils.HandelAlert;
import com.Mycaar.commonUtils.SelectFunctions;
import com.Mycaar.commonUtils.WaitForWebPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reset {
   
	static WebDriver driver;
	static WebElement element;
	static List<WebElement> elements;
	static ExtentTest test;
	
	@FindBy(xpath="//*[@id='main-menu']/li[3]/a")
	WebElement expandProgram;
	
	@FindBy(xpath="//span[text()='Reset Progress']")
	WebElement resetProgress;
	
	@FindBy(xpath="//i[@class='fa fa-angle-down']")
	WebElement searchMenu;
	
	@FindBy(id="program_select")
	WebElement selectProgram;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement search;
	
	@FindBy(id="resetaction")
	WebElement reset;
	
	@FindBy(xpath="//a[contains(text(),'Click Here')]")
	WebElement clickHereLink;
	
	public Reset(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void resetTheProgram() throws InterruptedException{
		ActionFunctions.moveToElementByCordinate(driver, expandProgram);
		expandProgram.click();
		test.log(LogStatus.INFO, "clciked on the expand program");
		WaitForWebPage.waitFortheElementToBeVisible(driver, resetProgress, 10);
		resetProgress.click();
		test.log(LogStatus.INFO, "clciked on the reset progress");
		Thread.sleep(50);
		searchMenu.click();
		test.log(LogStatus.INFO, "clciked on the search menu");
		WaitForWebPage.waitFortheElementToBeVisible(driver, selectProgram, 10);
		SelectFunctions.selectElementBytext(selectProgram, "Demo Program");
		test.log(LogStatus.INFO, "demo program is selected");
		WaitForWebPage.waitFortheElementToBeVisible(driver, search, 5);
		search.click();
		Thread.sleep(100);
		test.log(LogStatus.INFO, "clciked on the search");
		ActionFunctions.moveToElementByCordinate(driver, reset);
		reset.click();
		HandelAlert.acceptAlert(driver);
		test.log(LogStatus.INFO, "reset the program");
		Thread.sleep(2000);
		clickHereLink.click();
		test.log(LogStatus.INFO, "clciked on the link");
	}
}
