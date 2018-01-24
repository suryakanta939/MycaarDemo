package com.Mycaar.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Mycaar.baseClass.InvokeBrowser;
import com.Mycaar.commonUtils.ReadPropertyFileData;
import com.Mycaar.commonUtils.WaitForWebPage;
import com.Mycaar.pageClasses.LoacaAssessorFunction;
import com.Mycaar.pageClasses.LogIn;
import com.Mycaar.pageClasses.Reset;
import com.Mycaar.pageClasses.UserFunction;
import com.Mycaar.reportLib.ExtentFactory;
import com.Mycaar.screenShotlib.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserTest {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	String url;
	String un;
	String pwd;
	String browser;
	LogIn login;
	UserFunction usefunction;
	LoacaAssessorFunction localassessor;
	Reset reset;
//	@Parameters("browser")
	@BeforeClass
	public void settingUp() throws IOException{
		report=ExtentFactory.generateReport();
		test=report.startTest("cheking the user functionalty");
		url=ReadPropertyFileData.getPropertyData("URL");
		un=ReadPropertyFileData.getPropertyData("userName");
		pwd=ReadPropertyFileData.getPropertyData("passWord");
		browser=ReadPropertyFileData.getPropertyData("browserName");
		
	}
	
	@BeforeMethod
	public void executingBefore(){
		System.out.println("executing before");
		driver=InvokeBrowser.opneBrowser(browser);
		test.log(LogStatus.INFO,"browser opened");
		driver.manage().window().maximize();
		driver.get(url);
		test.log(LogStatus.INFO,"entered the url");
		login=new LogIn(driver, test);
		usefunction=new UserFunction(driver, test);
		localassessor=new LoacaAssessorFunction(driver, test);
        reset=new Reset(driver, test);
		
		
	}
	
	
	@Test()
	public void userFunction() throws InterruptedException {
     login.loginToMyCaar(un, pwd);
     test.log(LogStatus.INFO,"logged in to the site");
     WaitForWebPage.WaitForTheElementToBeClickable(driver, usefunction.demoProgam, 10);
     usefunction.takaAwareNesstest();
     test.log(LogStatus.INFO,"took the aware ness test");
     usefunction.takeCapabiltyTest();
     test.log(LogStatus.INFO,"took the capability test");
     Thread.sleep(20);
	}
	
	@Test(dependsOnMethods="userFunction")
	public void localAssesortest() throws IOException, InterruptedException{
		String name=ReadPropertyFileData.getPropertyData("AssessorUn");
		System.out.println(name);
		String pwd1=ReadPropertyFileData.getPropertyData("AssessorPwd");
		System.out.println(pwd1);
		//WaitForWebPage.waitFortheElementToBeVisible(driver, ln.userName, 10);
		login.loginToMyCaar(name, pwd1);
		localassessor.takeCapabiltyTest();
		reset.resetTheProgram();
	}
	
	@AfterMethod
	public void executingAfterMethod(ITestResult result) throws IOException, InterruptedException{
		
		login.logoutfroMycaar();
		if(result.getStatus()==result.SUCCESS){
			System.out.println("test case got pass");
			test.log(LogStatus.PASS, "test case got pass");
		}
		else if(result.getStatus()==result.SKIP){
			test.log(LogStatus.SKIP, "test cases got skipped");
		}
		else if(result.getStatus()==result.FAILURE){
			String path=ScreenShot.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, "test case got fail",test.addScreenCapture(path));
		}
		
		driver.quit();
		System.out.println("closed the driver");
		
	}
	
	@AfterClass
	public void tearDown(){
		test.assignAuthor("suryakanta");
		report.endTest(test);
		report.flush();
	}
}
