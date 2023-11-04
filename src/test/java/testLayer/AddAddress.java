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
import pompackage.PomAddAddress;

import testdata.ExcelSheet;

public class AddAddress extends BaseAmazonClass {
	
	PomAddAddress address;
	SoftAssert softassert;
	
	public AddAddress()
	{
		super();
	}
	@BeforeMethod
	public void initsetup() throws InterruptedException
	{
		initiation();
		
		address=new PomAddAddress();
		Thread.sleep(3000);
		softassert= new SoftAssert();
	}
	
	@DataProvider
	public Object[][] validData()
	{ 	
		Object[][] result=ExcelSheet.readdata("SigninValidData");
		Object[][] result1= new Object[1][2];
		result1[0][0]=result[0][0];
		result1[0][1]= result[0][1];
		return result1;
		
	}
	@DataProvider
	public Object[][] validAddress()
	{ 	
		Object[][] result=ExcelSheet.readdata("ValidAddAddress");
		return result;
		
	}
	@DataProvider
	public Object[][] invalidAddress()
	{ 	
		Object[][] result2=ExcelSheet.readdata("InvalidAddAddress");
		return result2;
		
	}
	
	@Test(priority=1,dataProvider="validData")
	public void navigateaddraddress(String email,String password) throws InterruptedException
	{
		address.clicksignin();
		Thread.sleep(3000);
		address.semail(email);
		address.clickcontinue();
		Thread.sleep(6000);
		address.spassword(password);
		address.clicksign();
		Thread.sleep(6000);
		address.displayusname();
		Thread.sleep(4000);
		address.manageaddress();
		Thread.sleep(4000);
		address.addaddress();
		
	}
	
	@Test(priority=2,dataProvider="validAddress")
	public void validaddress(String email,String password,String fullname,String phonenum,String address1,String address2,String cityname,String postalcode) throws InterruptedException
	{
		address.clicksignin();
		Thread.sleep(8000);
		address.semail(email);
		address.clickcontinue();
		Thread.sleep(4000);
		address.spassword(password);
		address.clicksign();
		Thread.sleep(4000);
		address.displayusname();
		Thread.sleep(3000);
		address.manageaddress();
		Thread.sleep(3000);
		address.addaddress();
		Thread.sleep(500);
		address.country("address-ui-widgets-countryCode-dropdown-nativeId_37");
		address.fullname(fullname); 
		address.phonenumber(phonenum);
		address.addressline1(address1); 
		address.addressline2(address2);
		address.city(cityname); 
		address.province("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8");
		address.postalcode(postalcode); 
		address.defaultaddress();
		address.Addaddressbtn();
		address.originalAddress();
		address.saveAddress();
		
		
		String expectedTitle="Your Addresses";
		   String actualTitle= driver.getTitle();
		   System.out.println(actualTitle);
		   Assert.assertEquals(actualTitle, expectedTitle);	}
		  
	@Test(priority=3,dataProvider="invalidAddress")
		   public void invalidaddress(String email1,String password1,String fullname1,String phonenum1,String address2,String address3,String cityname1,String postalcode1) throws InterruptedException
			{
				address.clicksignin();
				Thread.sleep(8000);
				address.semail(email1);
				address.clickcontinue();
				Thread.sleep(4000);
				address.spassword(password1);
				address.clicksign();
				Thread.sleep(4000);
				address.displayusname();
				Thread.sleep(3000);
				address.manageaddress();
				Thread.sleep(3000);
				address.addaddress();
				Thread.sleep(500);
				address.country("address-ui-widgets-countryCode-dropdown-nativeId_37");
				address.fullname(fullname1); 
				address.phonenumber(phonenum1);
				address.addressline1(address2); 
				address.addressline2(address3);
				address.city(cityname1); 
				address.province("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8");
				address.postalcode(postalcode1); 
				address.defaultaddress();
				address.Addaddressbtn();
				
					
		 if(address2==null || "".equals(address2)) { 
			 if(address3==null || "".equals(address3)) {
			  String expectedErrormsg1= "Please enter an address."; 
			  WebElement blankadline1= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[10]/div[2]/div/div/div/div")); 
		  String actualErrormsg1= blankadline1.getText();
		  softassert.assertEquals(actualErrormsg1,expectedErrormsg1);}}
		 
		  
		 if(fullname1==null || "".equals(fullname1)) { 
			 
			  String expectedErrormsg2= "Please enter a name."; 
			  WebElement blankfname= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[4]/div[2]/div/div/div/div")); 
		  String actualErrormsg2= blankfname.getText();
		  softassert.assertEquals(actualErrormsg2,expectedErrormsg2); }
		 
		 if(phonenum1==null || "".equals(phonenum1)) { 
			
			  String expectedErrormsg3= "Please enter a phone number so we can call if there are any issues with delivery."; 
			  WebElement blankphone= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[6]/div[3]/div/div/div/div")); 
		  String actualErrormsg3= blankphone.getText();
		  softassert.assertEquals(actualErrormsg3,expectedErrormsg3);}
		 
		 if(cityname1==null || "".equals(cityname1)) { 
			 
			  String expectedErrormsg4= "Please enter a city name."; 
			  WebElement blankcity= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[12]/div[2]/div/div/div/div")); 
		  String actualErrormsg4= blankcity.getText();
		  softassert.assertEquals(actualErrormsg4,expectedErrormsg4);}
		 
		 if(postalcode1==null || "".equals(postalcode1)) { 
			 
			  String expectedErrormsg5= "Please enter a postal code."; 
			  WebElement blankcode= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[16]/div[2]/div/div/div/div")); 
		  String actualErrormsg5= blankcode.getText();
		  softassert.assertEquals(actualErrormsg5,expectedErrormsg5);}
		 softassert.assertAll();
	}
	
	@AfterMethod
	public void closebrowser()
	{
		
		driver.close();
		
	}
	
}
