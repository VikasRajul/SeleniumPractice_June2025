package basePackages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Utility;

public class BaseClass {
	
      protected WebDriver driver;
	
     @Parameters ("BROWSER")
	 @BeforeClass
	 public void setup(@Optional("Chrome") String browserName) {		
		System.out.println("***************** Running Before Class ***********");
		 //driver =  Utility.startBrowser(browserName, "https://freelance-learn-automation.vercel.app/login");
		 driver =  Utility.startBrowser(browserName, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("***************** Running After Class ***********");
		driver.quit();
	}

}
