package com.crm.JavaUtility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandle 
{
   static WebDriver driver;
	public static void handle()
	{
		 String parent = driver.getWindowHandle();
		   Set<String> childhandles = driver.getWindowHandles();
		   childhandles.remove(parent);
				
				for(String str : childhandles)
				{
					driver.switchTo().window(str);
				}
	}
}
