package DWSTestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.DWSBaseClass;
import com.crm.FileUtility.ExcelFile;
import com.crm.dws_pom.Shopping_cart_page;
import com.crm.pom.DWS_HomePage;
import com.crm.pom.GiftCardPageInfo;
@Listeners(com.crm.Listners.DWSListners.class)
public class GiftCard_TC1  extends DWSBaseClass
{
	@Test
	  public void createConWithSupportSEDate() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		 
		 System.out.println("******DWS TC1 ******");
		 DWS_HomePage hp=new DWS_HomePage(driver);
		 hp.gift_card();
		 
		 
		 GiftCardPageInfo gcinfo=new GiftCardPageInfo(driver);
		 gcinfo.recipientName(ExcelFile.excel("DWS", 1, 1));
		 gcinfo.recipientemail(ExcelFile.excel("DWS", 2, 1));
		 gcinfo.senderName(ExcelFile.excel("DWS", 3, 1));
		 gcinfo.senderEmail(ExcelFile.excel("DWS", 4, 1));
		 gcinfo.Message(ExcelFile.excel("DWS", 5, 1));
		 gcinfo.qty("5");
		 Thread.sleep(2000);
		 gcinfo.addToCrd_btn2();
		 Thread.sleep(3000);
		 
		 Shopping_cart_page scp=new Shopping_cart_page(driver);
		 Thread.sleep(3000);
		 scp.shop_crt();
		 
		 Thread.sleep(3000);
		
		
		 System.out.println(scp.card_getText());
		 System.out.println(scp.price_verify());
		 
		 //verification
	 Assert.assertEquals(scp.card_getText(),ExcelFile.excel("DWS",8, 1));
	  Reporter.log("Gift card added successfuuly",true);
		  
		  System.out.println("******DWS TC1 Completed******");
	   }

}
