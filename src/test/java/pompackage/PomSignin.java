package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseAmazonClass;


public class PomSignin extends BaseAmazonClass{

	@FindBy(linkText="Sign in") WebElement Signin;
	@FindBy(id="ap_email") WebElement Email;
	@FindBy(id="continue") WebElement continuebtn;
	@FindBy(id="ap_password") WebElement passwords;
	@FindBy(id="signInSubmit") WebElement signin1;
	@FindBy(name="rememberMe") WebElement RMe;
	
	
	//initiate page elements
	
	  public PomSignin() 
	  { 
		  PageFactory.initElements(driver, this); 
      }
	 
	
	public void clicksignin()
	{
		Signin.click();
	}
	
	public void semail(String email)
	{
		Email.sendKeys(email); 
	}
	public void clickcontinue()
	{
		continuebtn.click();
	}
	public void spassword(String password)
	{
		passwords.sendKeys(password);
	}
	public void rememberme()
	{
		RMe.click();
	}
	public void clicksign()
	{
		signin1.click();
	}
	
}
