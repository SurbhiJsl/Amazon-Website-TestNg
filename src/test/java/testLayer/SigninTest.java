package testLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import basePackage.BaseAmazonClass;
import pompackage.PomSignin;
import testdata.ExcelSheet;


public class SigninTest extends BaseAmazonClass{
	PomSignin signin;
	SoftAssert softassert;
	
	public SigninTest()
	{
		super();
	}
	@BeforeMethod
	public void initsetup() throws InterruptedException
	{
		initiation();
		signin= new PomSignin();
		Thread.sleep(3000);
		softassert= new SoftAssert();
	}
	
	@DataProvider
	public Object[][] validData()
	{ 	
		Object[][] result=ExcelSheet.readdata("SigninValidData");
		 		  
			
         return result;
	}
	
	@DataProvider
	public Object[][] invalidData()
	{ 	
		Object[][] result1=ExcelSheet.readdata("SigninInvalidData");
		 		  
			
         return result1;
	}
	
	
	
	@Test(priority=1,dataProvider="validData")
	public void validSigninDetails(String email,String password) throws InterruptedException
	{
		signin.clicksignin();
		Thread.sleep(3000);
		signin.semail(email);
		signin.clickcontinue();
		Thread.sleep(6000);
		signin.spassword(password);
		signin.rememberme();
		signin.clicksign();
		Thread.sleep(6000);
		System.out.println("Test Passed");
		
		String Amazon= driver.getTitle();
		System.out.println(Amazon);
		softassert.assertEquals(Amazon, "Amazon.ca");
			
		
	}
		
	
	@Test(priority=2,dataProvider="invalidData")
	public void invalidSigninDetails(String em1,String pwd1) throws InterruptedException
	{
		signin.clicksignin();
		Thread.sleep(3000);
		signin.semail(em1);
		Thread.sleep(2000);
		signin.clickcontinue();
		
		if(em1==null || "".equals(em1)) {
			  String expectedErrormsg= "Enter your e-mail address or mobile phone number";
			  WebElement blankemailmsg= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[1]/div/div/div")); 
			  String actualErrormsg= blankemailmsg.getText(); 
			  softassert.assertEquals(actualErrormsg, expectedErrormsg);
			  return;
			  }
				
		
		
		Thread.sleep(8000);
		signin.spassword(pwd1);
		signin.rememberme();
		signin.clicksign();
		
				
		 if(pwd1==null || "".equals(pwd1)) {
			  String expectedErrormsg1= "Enter your password";
			  WebElement blankpwdmsg= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/form/div/div[1]/div[2]/div/div")); 
			  String actualErrormsg1= blankpwdmsg.getText(); 
			  softassert.assertEquals(actualErrormsg1,expectedErrormsg1);
		 
		 }
		 else if(pwd1.length()<6) {
			String expectedErrormsg2= "Your password is incorrect";
			  WebElement invalidpwd= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/ul/li/span")); 
			  String actualErrormsg2= invalidpwd.getText(); 
			  softassert.assertEquals(actualErrormsg2,expectedErrormsg2);}
		
		
	}
	
	@Test(priority=3,dataProvider="validData")
	public void keepMeSignIn(String em2,String pwd2) throws InterruptedException
	{  
		signin.clicksignin();
		Thread.sleep(3000);
		signin.semail(em2);
		signin.clickcontinue();
		Thread.sleep(6000);
		signin.spassword(pwd2);
		signin.rememberme();
		
		Thread.sleep(6000);
		
		
		WebElement checkbox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/form/div/div[2]/div/div/label/div/label/input"));
		Assert.assertEquals(true, checkbox.isSelected());
		System.out.println("Keepme Signin is selected");
		
		signin.clicksign();	 		
		
	}
		
			
	
	  @AfterMethod public void close()
	  { 
		  driver.close(); 
		  }
	 
	
}
