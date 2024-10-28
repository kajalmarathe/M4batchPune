package VTigerTestCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.VTigerBaseClass;
import com.crm.FileUtility.ExcelFile;
import com.crm.JavaUtility.DateExample;
import com.crm.pom.ContactPage;

@Listeners(com.crm.Listners.VTiger_Listners.class)
public class Contact_WithDate_FTc1 extends VTigerBaseClass
{
	 @Test
	  public void createConWithSupportSEDate() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		 
		 System.out.println("******Contact TC1 with system start and end date******");
		 ContactPage cp = new ContactPage(driver);
		 cp.contacts();
		 cp.createContact();
		 
		 cp.lastName(ExcelFile.excel("VTiger", 0, 1));
		  
		  String start_date=DateExample.date1("yyyy-MM-dd", 2);
		  String end_date=DateExample.date1("yyyy-MM-dd", 4);
		  
		  
		  cp.startDate(start_date);
		  cp.endDate(end_date);
		  
		  //Save 
		  cp.save();
		  
		  //verification
		  assertEquals(start_date,cp.verify_startdate.getText());
		  Reporter.log("Expected Start date is displayed ",true);
		  assertEquals(end_date,cp.verify_enddate.getText());
		  Reporter.log("Expected end date is displayed",true);
		  
		  System.out.println("******Contact TC1 Completed******");
	   }

}
