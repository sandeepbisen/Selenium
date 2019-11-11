package setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	private WebDriver driver;
	public static String baseUrl = "http://apps.qa2qe.cognizant.e-box.co.in/CustomerRegistration/";
	
	public WebDriver getDriver() {
	    driver = new FirefoxDriver();
		driver.navigate().to(DriverSetup.baseUrl);
		return driver;
	}
}
