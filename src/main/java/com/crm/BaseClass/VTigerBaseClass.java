package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.PropertiFile;


public class VTigerBaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeClass
	public static void preConditions() throws InterruptedException, IOException 
	{
		String browser=PropertiFile.property("browser");
		String url=PropertiFile.property("url");
		
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
		
		System.out.println("Before Method...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("Enter log in deatils...");
		String username=PropertiFile.property("username");
		String password=PropertiFile.property("password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	
	}
	@AfterMethod
	public void logout() throws InterruptedException
	{
		System.out.println("After Method...");
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(img).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}
	
	
	
	@AfterClass
	public void postCondition() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	

	}

}
