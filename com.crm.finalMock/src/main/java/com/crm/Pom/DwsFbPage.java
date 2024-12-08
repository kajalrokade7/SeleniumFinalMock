package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DwsFbPage 
{
   public DwsFbPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   private @FindBy(className = "ico-login")
   WebElement login_link;
   
   private @FindBy(id="Email")
   WebElement username;
   
   private @FindBy(name="Password")
   WebElement lgpassword;
   
   private @FindBy(xpath="//input[@value='Log in']")
   WebElement login_button;
   
   private @FindBy(xpath="(//a[@target=\"_blank\"])[1]")
   WebElement fb;
   
   private @FindBy(xpath="//span[contains(text(),'Create new account')]")
   WebElement create_newaccount;
   
   private @FindBy(xpath="//input[@name='firstname']")
   WebElement first_name;
   
   private @FindBy(xpath="//input[@name='lastname']")
   WebElement last_name;
   
   private @FindBy(xpath="//input[@name='reg_email__']")
   WebElement emailid;
   
   private @FindBy(xpath="//input[@name='reg_passwd__']")
   WebElement password;
   
   public @FindBy(xpath="//select[@name='birthday_day']")
   WebElement day;
   
   private@FindBy(xpath="//select[@name='birthday_month']")
   WebElement month;
   
   private @FindBy(xpath="//select[@name='birthday_year']")
   WebElement year;
   
   private @FindBy(xpath="//input[@class='_8esa']")
   WebElement gender;
   
   private @FindBy(id="RememberMe")
   WebElement rememberme;
   
   private @FindBy(xpath="//input[@name=\"reg_email_confirmation__\"]")
   WebElement email_confirm;
   
   private @FindBy(xpath="//a[@class=\"ico-logout\"]")
   WebElement logout;
   
   public void loginLink()
   {
	   login_link.click();
   }
   public void lgUsername(String uname)
   {
	  username.sendKeys(uname);
   }
   public void lgPassword(String pass)
   {
	   lgpassword.sendKeys(pass);
   }
   public void reMe()
   {
	   rememberme.click();
   }
   public void loginButton()
   {
	   login_button.click();
   }
   
   public void facebook() 
   {
	   fb.click();
   }
   public void createNewAccount()
   {
	   create_newaccount.click();
   }
   public void firstName(String name)
   {
	   first_name.sendKeys(name);
   }
   public void lastName(String lastname)
   {
	   last_name.sendKeys(lastname);
   }
   public void emailId(String email)
   {
	   emailid.sendKeys(email);
   }
   public void password(String pass)
   {
	  password.sendKeys(pass);
   }
 public void birthDay(String bday)
 {
	 Select se = new Select(day);
	se.selectByValue(bday);
 }
 public void birthMonth(String mon)
 {
	 Select se = new Select(month);
	 se.selectByVisibleText(mon);
 }
 public void birthYear(String byear)
 {
	 Select se = new Select(year);
	 se.selectByVisibleText(byear);
 }
 public void gender()
 {
	 gender.click();
 }
 public void confrimEmail(String mail)
 {
	email_confirm.sendKeys(mail); 
 }
 public void logout()
 {
	 logout.click();
 }
   
}
