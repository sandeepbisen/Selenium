package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerForm {

	WebDriver driver;
	
	public CustomerForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="cname")
	public WebElement customerName;
	
	@FindBy(name="age")
	public WebElement customerAge;
	
	@FindBy(name="address")
	public WebElement customerAddress;
	
	@FindBy(name="phonenumber")
	public WebElement customerPhNo;
	
	@FindBy(name="email")
	public WebElement customerEmail;
	
	@FindBy(id="submit")
	public WebElement btnSubmit;
	
	@FindBy(id="reset")
	public WebElement btnReset;
	
	@FindBy(id="//*[@id='message']")
	public WebElement errorMsg;
	
	public void setCustomerName(String cName)
	{
		  customerName.sendKeys(cName);
		
	}
	public void setAge(String age)
	{
		  customerAge.sendKeys(age);
	
	}
	public void setAddress(String address)
	{
		  customerAddress.sendKeys(address);
	
	}
	public void setPhoneNumber(String phoneNumber)
	{
		  customerPhNo.sendKeys(phoneNumber);
		
	}
	public void setEmail(String email)
	{
		  customerEmail.sendKeys(email);
		
	}
	public void submitForm()
	{
		  btnSubmit.click(); 
	}
	public String getErrorMessage()
	{
		String erroemsg = "phoneNumber cannot be blank";
		return erroemsg;
	}
	
}
