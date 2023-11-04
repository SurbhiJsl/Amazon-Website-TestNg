package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basePackage.BaseAmazonClass;


public class PomCreateAccount extends BaseAmazonClass {

	//Object Repository
	@FindBy(linkText="Start here.") WebElement StartHere;
	 @FindBy(id="ap_customer_name") WebElement YourName;
	@FindBy(id="ap_email") WebElement MobileorEmail;
    @FindBy(id="ap_password") WebElement Password;
	@FindBy(id="ap_password_check") WebElement PasswordAgain;
	@FindBy(id="continue") WebElement Continuebtn;
  
	
	
	
	//initiate page elements
	public PomCreateAccount()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickstarthere()
	{
		StartHere.click();
	}
	
	
	public void typeyourname(String yourname)
	{
		YourName.sendKeys(yourname);
	}
	public void typemobileoremail(String mobileoremail)
	{
		MobileorEmail.sendKeys(mobileoremail);
	}
	public void typepassword(String password)
	{
		Password.sendKeys(password);
	}
	public void typepassagain(String passagain)
	{
		PasswordAgain.sendKeys(passagain);
	}
	
	public void clickcontinue()
	{
		Continuebtn.click();
		
		
	}
	
	
	
	
	
	
}
