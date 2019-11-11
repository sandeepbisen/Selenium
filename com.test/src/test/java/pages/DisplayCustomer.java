package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisplayCustomer {
	WebDriver driver;
	String title,name,age,email,address,phNumber;
	
	public DisplayCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="/html/body/h2")
	public WebElement eleTitle;

	@FindBy(xpath="/html/body/table/tbody/tr[1]/td[2]")
	public WebElement eleName;
	
	@FindBy(xpath="/html/body/table/tbody/tr[2]/td[2]")
	public WebElement eleAge;
	
	@FindBy(xpath="/html/body/table/tbody/tr[3]/td[2]")
	public WebElement eleAddress;
	
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]")
	public WebElement elePhNumber;
	
	@FindBy(xpath="/html/body/table/tbody/tr[5]/td[2]")
	public WebElement eleEmail;
	

	
	public String getTitle()
	{
		title = eleTitle.getText();
		return title;
	}
	public String getName()
	{
		name = eleName.getText().trim();
		return name;
	}
	public String getAge()
	{
		age = eleAge.getText().trim();
		return age;
	}
	public String getEmail()
	{
		email = eleEmail.getText().trim();
		return email;	
	}
	public String getAddress()
	{
		address = eleAddress.getText().trim();
		return address;
	}
	public String getPhoneNumber()
	{
		phNumber = elePhNumber.getText().trim();
		return phNumber;
	}
}
