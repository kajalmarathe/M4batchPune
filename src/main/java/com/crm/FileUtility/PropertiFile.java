package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiFile 
{
	public static String property (String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("..\\com.crm.vTigerM4\\src\\test\\resources\\configure.properties");
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
		
	}

}
