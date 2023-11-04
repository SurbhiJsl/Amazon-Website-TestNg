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
import pompackage.PomCreateAccount;
import testdata.ExcelSheet;

public class CreateAccountTest extends BaseAmazonClass{
	PomCreateAccount create;
	SoftAssert obj;
		
	public CreateAccountTest()
	{
		super();
	}
	@BeforeMethod
	public void initsetup() throws InterruptedException
	{
		initiation();
		create= new PomCreateAccount();
		Thread.sleep(4000);
		obj= new SoftAssert();
	}
	
	@DataProvider
	public Object[][] vMobileDetails()
	{
		Object[][] result=ExcelSheet.readdata("ValidPhoneNumber");
		return result;
	}
	
	@DataProvider
	public Object[][] vEmailDetails()
	{
		Object[][] result1=ExcelSheet.readdata("ValidEmailId");
		return result1;
	}
	
	@DataProvider
	public Object[][] invAccountDetails()
	{
		Object[][] result2=ExcelSheet.readdata("inValidData");
		return result2;
		
	}	
	
	@Test(priority=1,dataProvider="vMobileDetails")
	public void validmobilecreateaccount(String yourname, String mobileoremail, String password, String passwordagain) throws InterruptedException
	{
		create.clickstarthere();
		create.typeyourname(yourname);
		create.typemobileoremail(mobileoremail);
		create.typepassword(password);
		create.typepassagain(passwordagain);
		Thread.sleep(4000);
		create.clickcontinue();
		Thread.sleep(8000);
		
		  String expectedResult="Enter OTP:";
		  WebElement otp= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div[1]/label"));
		  String actualResult= otp.getText();
		  Assert.assertEquals(actualResult, expectedResult);
	 
		
	}
	@Test(priority=2,dataProvider="vEmailDetails")
	public void validemailcreateaccount(String yourname1, String mobileoremail1, String password1, String passwordagain1) throws InterruptedException
	{
		create.clickstarthere();
		create.typeyourname(yourname1);
		create.typemobileoremail(mobileoremail1);
		create.typepassword(password1);
		create.typepassagain(passwordagain1);
		Thread.sleep(4000);
		create.clickcontinue();
		Thread.sleep(8000);
		
		  String expectedResult1="Enter OTP";
		  WebElement otp1= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[1]/form/div[2]/div[1]"));
		  String actualResult1= otp1.getText();
		  Assert.assertEquals(actualResult1, expectedResult1);
	 
		
	}
	
	
	  @Test(priority=3,dataProvider="invAccountDetails") 
	  
	  public void invalidcreateaccount(String yourname2, String mobileoremail2, String password2, String passwordagain2) throws InterruptedException {
	  create.clickstarthere();
	  
	  create.typeyourname(yourname2); 
	 	  
	  create.typemobileoremail(mobileoremail2);
	  create.typepassword(password2); 
	  create.typepassagain(passwordagain2);
	  Thread.sleep(4000); 
	  create.clickcontinue();
	  Thread.sleep(8000);
	  
	  if(yourname2==null) {
	  String expectedErrormsg2= "Enter your name";
	  WebElement blankuname= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[1]/div/div/div")); 
	  String actualErrormsg2= blankuname.getText(); 
	  Assert.assertEquals(actualErrormsg2,expectedErrormsg2);}
	  
	  if(mobileoremail2==null) {
			 String expectedResult="Enter your e-mail address or mobile phone number";
			  WebElement blankemail= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[2]/div[3]/div/div"));
			  String actualResult= blankemail.getText();
			  Assert.assertEquals(actualResult, expectedResult);}
	  
	  if(password2.length()<6) {
			 String expectedResult3="Minimum 6 characters required";
			  WebElement lesschar= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div[1]/div[3]/div/div"));
			  String actualResult3= lesschar.getText();
			  Assert.assertEquals(actualResult3, expectedResult3);}
		 
	  if(password2!=passwordagain2) {
			 String expectedResult4="Passwords do not match";
			  WebElement notmatchpass= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div[2]/div[2]/div/div"));
			  String actualResult4= notmatchpass.getText();
			  Assert.assertEquals(actualResult4, expectedResult4);}
	  
	  
	  
	  
	  
	  
	  }
	 
	 
	
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
}
