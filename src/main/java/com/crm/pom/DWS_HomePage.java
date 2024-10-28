package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.BaseClass.DWSBaseClass;

public class DWS_HomePage extends DWSBaseClass
{
	
	public DWS_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//logo
			@FindBy(xpath="//img[@alt='Tricentis Demo Web Shop']")
			private WebElement logo;
	
	//link 25rs gift card
		@FindBy(xpath = "//input[@value='Add to cart']")
		private WebElement gift_card_btn;

		//shopping cart
		@FindBy(xpath = "//span[text()='Shopping cart']")
		private WebElement shopping_crd_HP;
		
		public void gift_card() 
		{
			gift_card_btn.click();
			
		}

		public void logo() {
			logo.click();
			
		}
		
		public void shopping_crd_HP()
		{
			shopping_crd_HP.click();
		}
		
		

}
