package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.BaseClass.DWSBaseClass;

public class Shopping_cart_page extends DWSBaseClass
{
	public Shopping_cart_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	private WebElement shop_crt;
	
	@FindBy(xpath="//a[@class='product-name']")
	private WebElement card_getText;
	
	@FindBy(xpath="//input[@name='removefromcart']")
	private WebElement removefromcart_checkbox;
	
	@FindBy(xpath="//input[@name='updatecart']")
	private WebElement updatecart_btn;
	
	//empty shppoing card
	@FindBy(xpath="//div[@class='order-summary-content']")
	private WebElement empty_card_verify;
	

	public String card_getText() {
		
		String get_txt=card_getText.getText();
		return get_txt;
	}

	public void removefromcart_checkbox() {
		
		removefromcart_checkbox.click();
	}

	public void updatecart_btn() {
		
		updatecart_btn.click();
	}

	public void shop_crt() {
		
		shop_crt.click();
	}
	
	public String  empty_card_verify()
	{
		String empty_card_verify_text=empty_card_verify.getText();
		return empty_card_verify_text;
	}

}
