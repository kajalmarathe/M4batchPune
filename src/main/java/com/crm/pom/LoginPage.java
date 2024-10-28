package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{	
	LoginPage(WebDriver driver){
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement login ;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement login_btn;

	public void login(String email,String pass) 
	{
		login.sendKeys(email);
		password.sendKeys(pass);
		login_btn.click();
		
	}

	
}