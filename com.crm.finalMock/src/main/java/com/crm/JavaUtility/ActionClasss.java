package com.crm.JavaUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClasss 
{
	static WebDriver driver;
  public static void action()
  {
	  Actions act = new Actions(driver);
	   act.keyDown(Keys.PAGE_DOWN).build().perform();
	   act.keyDown(Keys.PAGE_DOWN).build().perform();
  }
}
