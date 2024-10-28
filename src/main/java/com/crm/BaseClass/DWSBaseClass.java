	package com.crm.BaseClass;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.PropertiFile;
import com.crm.FileUtility.PropertiFile2;
import com.crm.pom.DWSLoginPage;
import com.crm.pom.GiftCardPageInfo;


public class DWSBaseClass{
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeClass
	public static void preConditions() throws InterruptedException, IOException 
	{
		String browser=PropertiFile2.property("browser");
		String url=PropertiFile2.property("url");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		else if(browser.equalsIgnoreCase("InternetExplorer"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else
		{
			driver=new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(url);
		
		}
	
	
	@BeforeMethod
	
	public void login() throws IOException
	{
		DWSLoginPage login_ref=new DWSLoginPage(driver);
		
//		String email=PropertiFile.property("dws_email");
//		String password=PropertiFile.property("dws_password");
//		login_ref.login(email, password);
		
		
		
		String email=PropertiFile2.property("dws_email");
		String password=PropertiFile2.property("dws_password");
	
		
		driver.findElement(By.xpath("//*[@class='ico-login']")).click();
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
		
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		GiftCardPageInfo logout=new GiftCardPageInfo(driver);
		logout.logput_link();
		Thread.sleep(3000);
	}
	
	
	@AfterClass
	public void postCondition()
	{
		driver.close();
	
	
	}

}
