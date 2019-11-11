package test.com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CustomerForm;
import pages.DisplayCustomer;
import setup.DriverSetup;
import setup.ExcelUtils;

// fill the code
public class TestDisplayCustomer extends DriverSetup{

	WebDriver driver;

	DisplayCustomer displayCustomer;
	CustomerForm customerForm;
	public static String titletxt;
	public static String customerNametxt;
	public static String agetxt;
	public static String addresstxt;
	public static String numbertxt;
	public static String emailtxt;
	public static String sheetName ="customer_valid";
	public static String cName,cAge,cAddress,cPHNumber,cEmail;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
		displayCustomer= new DisplayCustomer(driver);
		customerForm= new CustomerForm(driver);
	}
	
	@Test(dataProvider="customerValid")
	public void  testValidCustomerDetails(String testcase ,String customerName, String age,String address,String phoneNumber,String email) {
		
		customerForm.setCustomerName(customerName);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
		customerForm.submitForm();
		
		cName = displayCustomer.getName();
		cAge =displayCustomer.getAge();
		cAddress =displayCustomer.getAddress();
		cPHNumber = displayCustomer.getPhoneNumber();
		cEmail = displayCustomer.getEmail();
		
		
		Assert.assertEquals(displayCustomer.getTitle(), "Registered Succesfully");
		Assert.assertEquals(cName.contains(customerName),true);
		Assert.assertEquals(cAge,age);
		Assert.assertEquals(cAddress,address);
		Assert.assertEquals(cPHNumber,phoneNumber);
		Assert.assertEquals(cEmail,email);
		
	}

	@DataProvider(name = "customerValid")
	public Object[][] getExcelData() throws Exception {

		  Object[][] testObjArray = ExcelUtils.readExcelData(sheetName);
	      return (testObjArray);
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.close();
	}
	
}
