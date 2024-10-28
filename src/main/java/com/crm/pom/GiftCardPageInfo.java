package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.BaseClass.DWSBaseClass;

public class GiftCardPageInfo extends DWSBaseClass
{
	public GiftCardPageInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//RecipientName
			@FindBy(xpath="//input[@id='giftcard_2_RecipientName']")
			private WebElement RecipientName;
			
			@FindBy(xpath="//input[@id='giftcard_2_RecipientEmail']")
			private WebElement Recipientemail;
			
			@FindBy(xpath="//input[@id='giftcard_2_SenderName']")
			private WebElement senderName;
			
			@FindBy(xpath="//input[@id='giftcard_2_SenderEmail']")
			private WebElement senderEmail;
			
			//msg
			@FindBy(xpath="//textarea[@id='giftcard_2_Message']")
			private WebElement Message;
			
			//qty
			@FindBy(xpath="//input[@class='qty-input']")
			private WebElement qty;
			
			//add to card btn
			@FindBy(xpath="//input[@id='add-to-cart-button-2']")
			private WebElement addToCrd_btn;
			
			//logout
			@FindBy(xpath="//a[@class='ico-logout']")
			private WebElement logput_link;
			
			//shopping cart link to verify
			@FindBy(xpath="//span[@class='cart-label']")
			private WebElement shopping_cart;
			
			
		public void recipientName(String rname) 
		{
			RecipientName.sendKeys(rname);
		}
		
		public void recipientemail(String remail) 
		{
			Recipientemail.sendKeys(remail);
		}
		
		public void senderName(String sname) 
		{
			senderName.clear();
			senderName.sendKeys(sname);
		}
		
		public void senderEmail(String semail) 
		{
			senderEmail.clear();
			senderEmail.sendKeys(semail);
		}
		
		
		
		public void Message(String msg) 
		{
			Message.sendKeys(msg);
		}
		
		public void qty(String qty1) 
		{
			qty.clear();
			qty.sendKeys(qty1);
		}
		
		public void addToCrd_btn(String smail) 
		{
			addToCrd_btn.click();
		}
		
		public void logput_link()
		{
			logput_link.click();
		}
		
		public void shopping_cart()
		{
			shopping_cart.click();
		}

		public void addToCrd_btn2() {
			addToCrd_btn.click();
			
		}
		
		
}
