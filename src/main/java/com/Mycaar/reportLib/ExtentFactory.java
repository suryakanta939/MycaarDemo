package com.Mycaar.reportLib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
   static ExtentReports report;
   
   public static ExtentReports generateReport(){
	   File f=new File("Reports");
	   File fs=new File(f,"");
	   System.out.println(fs.getAbsolutePath()+"\\mycaar.html");
	  report=new ExtentReports(fs.getAbsolutePath()+"\\mycaar.html",false);
	   return report;
   }
   
}
