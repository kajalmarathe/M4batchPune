package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.BaseClass.DWSBaseClass;

public class DWSLoginPage extends DWSBaseClass
{
	
	public DWSLoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="Email")
	private WebElement email;
		
	
	@FindBy(id="Password")
	private WebElement password;
		
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement login_button;
	
	public void login(String email1,String pass)
	{
		email.sendKeys(email1);
		password.sendKeys(pass);
		login_button.click();
		
	}
	
	

	
	

}
