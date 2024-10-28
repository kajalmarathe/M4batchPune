package com.crm.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.BaseClass.VTigerBaseClass;

public class ContactPage extends VTigerBaseClass
{
public ContactPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

	private@FindBy(xpath="//a[text()='Contacts']")
	 WebElement contact;
	
	private @FindBy(xpath="//img[@alt='Create Contact...']")
	 WebElement createcontact;

	private @FindBy(id="jscal_field_support_start_date")
	WebElement startdate;

	private @FindBy(id="jscal_field_support_end_date")
	WebElement enddate;
	
	private @FindBy(name="lastname")
	WebElement lastname;
	
	private@FindBy(xpath="//input[@class=\"crmButton small save\"]")
	WebElement save;
	
	public @FindBy(id="dtlview_Support Start Date")
	WebElement verify_startdate;
	
	public @FindBy(id="dtlview_Support End Date")
	WebElement verify_enddate;
	 public void contacts()
	 {
		 contact.click();
	 }
	 public void createContact()
	 {
		 createcontact.click();
	 }
	 public void startDate(String d )
	 { 
	    startdate.clear();
		startdate.sendKeys(d);
		
	 }
	 public void endDate(String d)
	 {
		 enddate.clear();
		 enddate.sendKeys(d);
	 }
	 public void lastName(String s )
	 {
		 lastname.sendKeys(s);
	 }
	 public void save() throws InterruptedException
	 {
		 Actions act = new Actions(driver);
		 act.keyDown(Keys.PAGE_UP).build().perform();
		 Thread.sleep(2000);
		 save.click();
	 }
	

}
