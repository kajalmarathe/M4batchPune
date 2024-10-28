package DWSTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBaseClass;
import com.crm.FileUtility.ExcelFile;
import com.crm.pom.DWS_HomePage;
import com.crm.pom.GiftCardPageInfo;
import com.crm.pom.Shopping_cart_page;
@Listeners(com.crm.Listners.DWSListners.class)
public class GiftCard_TC2  extends DWSBaseClass
{
	public static DWS_HomePage hp;
	public static Shopping_cart_page scp;
	public static GiftCardPageInfo gcinfo;
	 
	@Test
	  public void createConWithSupportSEDate() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		hp=new DWS_HomePage(driver);
		scp=new Shopping_cart_page(driver);
		 gcinfo=new GiftCardPageInfo(driver);
		 
		 System.out.println("******DWS TC2 ******");
		 
		
		 hp.shopping_crd_HP();	 
//		 String verify_added=scp.card_getText();
//		 String  verify_added2=ExcelFile.excel("DWS",8, 1);
		 
		 String  verify_added3=ExcelFile.excel("DWS",9, 1);
		 String  verify_added4=scp.empty_card_verify();
		 
//		 System.out.println("verify_added"+verify_added);
//		 System.out.println("verify_added2"+verify_added2);
		 
		 if(verify_added3.equals(verify_added4))
		 {
			 addCardDeatils();
		 }
		 else {
			 scp.removefromcart_checkbox();
			 scp.updatecart_btn();
			 addCardDeatils();
			
		 }
		 
		 Thread.sleep(3000);
		 scp.shop_crt();
		 
		 Thread.sleep(3000);
	
		 System.out.println(scp.card_getText());
		 
		 
		 //verification
	 Assert.assertEquals(scp.card_getText(),ExcelFile.excel("DWS",8, 1));
	  Reporter.log("Gift card added successfuuly",true);
		  
		  System.out.println("******DWS TC2 Completed******");
	   }
	
	public static void addCardDeatils() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		hp=new DWS_HomePage(driver);
		scp=new Shopping_cart_page(driver);
		 gcinfo=new GiftCardPageInfo(driver);
		 
		 hp.logo();
		 hp.gift_card();
		 Thread.sleep(2000);
		 gcinfo.recipientName(ExcelFile.excel("DWS", 1, 1));
		 Thread.sleep(2000);
		 gcinfo.recipientemail(ExcelFile.excel("DWS", 2, 1));
		 gcinfo.senderName(ExcelFile.excel("DWS", 3, 1));
		 gcinfo.senderEmail(ExcelFile.excel("DWS", 4, 1));
		 gcinfo.Message(ExcelFile.excel("DWS", 5, 1));
		 gcinfo.qty("5");
		 Thread.sleep(2000);
		 gcinfo.addToCrd_btn2();
		 Thread.sleep(2000);
		
	}

}
