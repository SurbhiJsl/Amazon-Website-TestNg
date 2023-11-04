package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseAmazonClass;

public class PomAddAddress extends BaseAmazonClass {

	@FindBy(linkText="Sign in") WebElement Signin;
	@FindBy(id="ap_email") WebElement Email;
	@FindBy(id="continue") WebElement continuebtn;
	@FindBy(id="ap_password") WebElement passwords;
	@FindBy(id="signInSubmit") WebElement signin1;
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement Hellousername;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[3]/div[1]/a/div") WebElement Youraddresses;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div/div/a/div") WebElement Addaddress;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[2]/span/span/span/span") WebElement countryDropdown;
	@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement Fullname;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement Phone;
	@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement Addressline1;
	@FindBy(id="address-ui-widgets-enterAddressLine2") WebElement Addressline2;
	@FindBy(id="address-ui-widgets-enterAddressCity") WebElement City;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/form/span/div/div[1]/div/div[14]/span/span/span/span") WebElement provinceDropdown;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement Postalcode;
	@FindBy(id="address-ui-widgets-use-as-my-default") WebElement Defaultaddress;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/form/span/div/span/span/span/input") WebElement Addaddressbtn;
	@FindBy(id="address-ui-widgets-original-address-block_id-input") WebElement OriginalAddress;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/form/span/div/span/span/span/input") WebElement SaveAddress;
	
	
	public PomAddAddress() 
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
	
	public void clicksign()
	{
		signin1.click();
	}
	public void displayusname()
	{
		Hellousername.click();
	}
	public void manageaddress()
	{
		Youraddresses.click();
	}
	public void addaddress()
	{
		Addaddress.click();
	}
	public void country(String webElementId) throws InterruptedException
	{
		countryDropdown.click();
		
		WebElement countryDropdownValue = driver.findElement(By.id(webElementId));
		countryDropdownValue.click();
	}
	public void fullname(String fname)
	{
		Fullname.sendKeys(fname);
	}
	public void phonenumber(String phoneno)
	{
		Phone.sendKeys(phoneno);
	}
	public void addressline1(String address1)
	{
		Addressline1.sendKeys(address1);
	}
	public void addressline2(String address2)
	{
		Addressline2.sendKeys(address2);
	}
	public void city(String cityname)
	{
		City.sendKeys(cityname);
	}
	public void province(String webElementId1) throws InterruptedException
	{
          provinceDropdown.click();
		
		WebElement provinceDropdownValue = driver.findElement(By.id(webElementId1));
		provinceDropdownValue.click();
	}
	public void postalcode(String code)
	{
		Postalcode.sendKeys(code);
	}
	public void defaultaddress()
	{
		Defaultaddress.click();
	}
	public void Addaddressbtn()
	{
		Addaddressbtn.click();
	}
	public void originalAddress()
	{
		OriginalAddress.click();
	}
	public void saveAddress()
	{
		SaveAddress.click();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
