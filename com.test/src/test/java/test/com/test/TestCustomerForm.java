package test.com.test;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CustomerForm;
import setup.DriverSetup;
import setup.ExcelUtils;

	// fill the code
	public class TestCustomerForm extends DriverSetup{

	WebDriver driver;
	CustomerForm customerForm;
	static public String blankErrtxt;
	public static String sheetName ="customer_invalid";
	ExcelUtils readExcel=new ExcelUtils();
	static String errorMessage ;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	    customerForm= new CustomerForm(driver);
	}
	
	@Test(dataProvider="customerInvalid")
	public void  testInvalidCustomerDetails(String testcase ,String customerName, String age,String address,String phoneNumber,String email) {
	
		customerForm.setCustomerName(customerName);
		customerForm.setAge(age);
		customerForm.setAddress(address);
		customerForm.setPhoneNumber(phoneNumber);
		customerForm.setEmail(email);
		customerForm.submitForm();
		errorMessage = customerForm.getErrorMessage();
		Assert.assertEquals("phoneNumber cannot be blank", errorMessage);
			
	}
	
	@DataProvider(name = "customerInvalid")
	public Object[][] getExcelData() throws Exception {
		
		  Object[][] testObjArray = ExcelUtils.readExcelData(sheetName);

	      return (testObjArray);
	}
	
	@AfterClass
	public void closeBrowser(){
			driver.close();
	}
	
}
