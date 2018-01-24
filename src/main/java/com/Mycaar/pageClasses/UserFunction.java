package com.Mycaar.pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mycaar.commonUtils.ActionFunctions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserFunction {

	static WebDriver driver;
	static WebElement element;
	static List<WebElement> elements;
	static ExtentTest test;

	@FindBy(xpath="//label[text()='Demo Program']")
	public WebElement demoProgam;

	@FindBy(xpath="//*[@id='content']/section/div/div/div[4]/div/div/div[2]/ul/li/div[2]/div/div/div[1]/div/a")
	WebElement awareNess;

	@FindBy(xpath="//div[1][a[text()='Take Test']]")
	WebElement takeTest;

	@FindBy(xpath="//span[text()='8']")
	WebElement selectAnswer;

	@FindBy(xpath="//input[@value='Save & Return to Dashboard']")
	WebElement saveAndReturn;

	@FindBy(xpath="//*[@id='content']/section/div/div/div[4]/div/div/div[2]/ul/li/div[2]/div/div/div[2]/div/a")
	WebElement  capaBility;
	
	@FindBy(xpath="//div[@id='myModal4'][div[div[div[div[p[text()='You are not able to complete your own capabilty test.']]]]]]")
	WebElement capabitytext;

	@FindBy(xpath="//*[@id='myModal4']/div[2]/div/div/div/button")
	WebElement backButton;
	
	public UserFunction(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public void takaAwareNesstest(){
		demoProgam.click();
		test.log(LogStatus.INFO, "cliked on the demo program");
		String status=awareNess.getText();
		System.out.println(status);
		test.log(LogStatus.INFO, "reading the status of the text");
		if(status.equalsIgnoreCase("green")){
			System.out.println("test is already completed");
		}else{
			
			ActionFunctions.moveToElementByCordinate(driver, awareNess);
			awareNess.click();
			test.log(LogStatus.INFO, "cliked on the awareness dot");
			takeTest.click();
			test.log(LogStatus.INFO, "cliked on the teke test button");
			selectAnswer.click();
			test.log(LogStatus.INFO, "selected the answer");
			saveAndReturn.click();
			test.log(LogStatus.INFO, "clciked on the save and return button");
		}
	}
	
	public void takeCapabiltyTest() throws InterruptedException{
		String status=capaBility.getText();
		System.out.println("capability statu "+status);
		if(status.equalsIgnoreCase("green")){
			System.out.println("test is already completed");
		}else{
			capaBility.click();
			Thread.sleep(200);
			String text=capabitytext.getText();
			System.out.println(text);
			test.log(LogStatus.INFO, "read the capabilty message");
			backButton.click();
			test.log(LogStatus.INFO, "clicked on the back button");
		}
	}


}
