package com.Mycaar.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFileData {
	
  public static String getPropertyData(String key) throws IOException{
	  File f=new File("PropertyFiles");
	  File fs=new File(f,"MyCaar.properties");
	  
	  FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
	  Properties pro=new Properties();
			  pro.load(fis);
			  String data=pro.getProperty(key);
			  
			  return data;
	  
  }
	
	
}
