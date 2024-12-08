package dwsTestscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClas.BaseClassDWS;
import com.crm.FileUtility.FileUtilityExcel;
import com.crm.JavaUtility.ActionClasss;
import com.crm.JavaUtility.WindowHandle;
import com.crm.Pom.DwsFbPage;

public class CreateFbAccount extends BaseClassDWS
{
   @Test
   public void fbAccount() throws InterruptedException, EncryptedDocumentException, IOException
   {
	  
		 
	   String given_url = "https://demowebshop.tricentis.com/";
	   assertEquals(given_url,driver.getCurrentUrl());
	   Reporter.log("Dws page is verified",true);
	   
	   Actions act = new Actions(driver);
	   act.keyDown(Keys.PAGE_DOWN).build().perform();
	   act.keyDown(Keys.PAGE_DOWN).build().perform();
	   
	   DwsFbPage fp = new DwsFbPage(driver);
	   fp.facebook();
	   
	   Thread.sleep(2000);
	   String parent = driver.getWindowHandle();
	   Set<String> childhandles = driver.getWindowHandles();
	   childhandles.remove(parent);
			
			for(String str : childhandles)
			{
				driver.switchTo().window(str);
			}
	   
	  fp.createNewAccount();
	  String parent1 = driver.getWindowHandle();
	   Set<String> childhandles1 = driver.getWindowHandles();
	   childhandles.remove(parent1);
			
			for(String str : childhandles1)
			{
				driver.switchTo().window(str);
			}
	   Thread.sleep(2000);
	   
	  fp.firstName(FileUtilityExcel.Exceldata("Sheet1", 0, 0));
	  fp.lastName(FileUtilityExcel.Exceldata("Sheet1", 0, 1));
	  fp.emailId(FileUtilityExcel.Exceldata("Sheet1", 0, 2));
	  fp.password(FileUtilityExcel.Exceldata("Sheet1", 0, 3));
	  fp.birthDay(FileUtilityExcel.Excel2("Sheet1", 0, 4));
	  fp.birthMonth(FileUtilityExcel.Exceldata("Sheet1", 0, 5));
	  fp.birthYear(FileUtilityExcel.Excel2("Sheet1", 0, 6));
	  fp.confrimEmail(FileUtilityExcel.Exceldata("Sheet1", 0, 2));
	  fp.gender();
	  
	  driver.switchTo().window(parent1);
	  driver.switchTo().window(parent);
	  
	   
	 }
}
