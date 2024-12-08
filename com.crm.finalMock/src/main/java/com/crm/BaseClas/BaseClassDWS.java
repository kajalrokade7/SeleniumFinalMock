package com.crm.BaseClas;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.JavaUtility.JavaUtility;
import com.crm.Pom.DwsFbPage;

public class BaseClassDWS 
{

	 public static WebDriver driver;
		  
		  @BeforeClass
		  public void preCondition() throws IOException
		  {
			  String browser = JavaUtility.propertiesData("browser");
			  String url = JavaUtility.propertiesData("url");
			  
			  if(browser.equals("chrome")) {
				   driver = new ChromeDriver();
			   }
			   
			   else if(browser.equals("edge")) {
				   driver =new EdgeDriver();
			   }
			   else if (browser.equals("firefox")) {
				   driver = new FirefoxDriver();
			   }
			   else {
				   driver = new ChromeDriver();
			   }
			   
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get(url);
			
		}
		  @BeforeMethod
		  public void login() throws IOException
		  {
			  DwsFbPage fp = new DwsFbPage(driver);
			  fp.loginLink();
			  fp.lgUsername(JavaUtility.propertiesData("username"));
			  fp.lgPassword(JavaUtility.propertiesData("password"));
			  fp.reMe();
			  fp.loginButton();
		  }
		  
		  @AfterMethod
		  public void logout()
		  {
			  DwsFbPage fp = new DwsFbPage(driver);
			 fp.logout();
		  }
		  @AfterClass
		  public void postCondition()
		  {
			 driver.close(); 
		  }
   
}
