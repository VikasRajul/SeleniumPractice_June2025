package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	
	public static void selectValueFromDropdown(WebElement element, String valueToSelect) {
		
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(valueToSelect);
		System.out.println("Selected value "+valueToSelect+" From dropdown");
		
	}
	
	
	
	public static WebDriver startBrowser(String browser , String applicationURL) {
		System.out.println("**************"+"Running Test on "+browser+"**************");
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			
		}else {
			System.out.println("Sorry Currently "+browser +"is not available. Starting Chrome browser.");
			driver = new ChromeDriver();
		}
		driver.get(applicationURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("**************"+"Session is ready, Test will be running on "+browser+"**************");
		return driver;
	}
	
	public static WebDriver startBrowser(String browser , String applicationURL, boolean headless) {
		System.out.println("**************"+"Running Test on "+browser+"**************");
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions opt = new ChromeOptions();
			if(headless) {
				System.out.println("Test will be running on headless mode");
				opt.addArguments("--headless=new");

			}
			driver = new ChromeDriver(opt);

			
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			
		}else {
			System.out.println("Sorry Currently "+browser +"is not available. Starting Chrome browser.");
			driver = new ChromeDriver();
		}
		driver.get(applicationURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("**************"+"Session is ready, Test will be running on "+browser+"**************");
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("**************"+"Closing the browser "+"**************");
		if(driver!=null) 
		{
		driver.quit();
		}
		System.out.println("**************"+"Application closed."+"**************");

		
	}

}
