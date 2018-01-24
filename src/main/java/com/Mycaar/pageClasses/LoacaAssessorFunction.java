package com.Mycaar.pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Mycaar.commonUtils.ActionFunctions;
import com.Mycaar.commonUtils.SelectFunctions;
import com.Mycaar.commonUtils.WaitForWebPage;
import com.gargoylesoftware.htmlunit.javascript.host.canvas.WebGLProgram;
import com.relevantcodes.extentreports.ExtentTest;

public class LoacaAssessorFunction {
	
	static WebDriver driver;
	static WebElement element;
	static List<WebElement> elements;
	static ExtentTest test;
	
	UserFunction uf;
	@FindBy(xpath="//i[@class='fa fa-ellipsis-v']")
	WebElement menuImage;
	
	@FindBy(xpath="//div[@class='small-padding']//a[text()='DASHBOARD']")
	WebElement dashBoard;
	
	@FindBy(xpath="//select[@id='program']")
	WebElement program;
	
	@FindBy(id="submit_check")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id='cw_227_831']")
	WebElement capabilty;
	
	@FindBy(xpath="//span[text()='Yes']")
	WebElement yes;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement subMit;
	
	@ FindBy(xpath=".//*[@id='myModal5']/div[2]/div/div/div/button")
	WebElement back;
	public LoacaAssessorFunction(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		uf=new UserFunction(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void takeCapabiltyTest() throws InterruptedException{
		WaitForWebPage.WaitForTheElementToBeClickable(driver, menuImage, 15);
		ActionFunctions.moveToElementByCordinate(driver, menuImage);
		menuImage.click();
		Thread.sleep(200);
		ActionFunctions.moveToElementByCordinate(driver, dashBoard);
		dashBoard.click();
		SelectFunctions.selectElementBytext(program, "Demo Program");
		searchButton.click();
		
		while(true){
			try{
				WaitForWebPage.waitFortheElementToBeVisible(driver, capabilty, 10);
				
				break;
			}
			catch(Throwable t){
				
			}	
		}
		String status=capabilty.getText();
		if(status.equalsIgnoreCase("green")){
			System.out.println("capabilty test is already taken");
		}
		else{
			ActionFunctions.moveToElementByCordinate(driver, capabilty);
			capabilty.click();
			WaitForWebPage.WaitForTheElementToBeClickable(driver, yes, 10);
			yes.click();
			subMit.click();
			while(true){
				try{
					WaitForWebPage.waitFortheElementToBeVisible(driver, capabilty, 10);
					break;
				}
				catch(Throwable t){
					
				}	
			}
		}
		
		
	}
	
}
