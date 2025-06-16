package SeleniumGrid;
import java.util.HashMap;
import java.util.Map;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestOnLambdaTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		ChromeOptions opt = new ChromeOptions();
		
		opt.setPlatformName("Windows 11");
		opt.setBrowserVersion("133");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "rajule.vikas");
		map.put("accessKey", "LT_uytzedgvD76ZzMfcPrRlVnyZfnsYIxSRDEPa4OAp7iidUOY");
		map.put("w3c", true);
		opt.setCapability("LT:Options", map);

		//run test in headless mode.
		//opt.addArguments("--headless=new");
		
		URL gridURL = new URL("https://hub.lambdatest.com/wd/hub");
		
		//we need to pass the options class reference in the ChromeDriver constructor
		WebDriver driver = new RemoteWebDriver(gridURL	, opt);
		driver.get("https://freelance-learn-automation.vercel.app/");
		System.out.println("Title is: "+driver.getTitle());
		driver.quit();	
		
		ChromeOptions opt1 = new ChromeOptions();
		
		opt1.setPlatformName("macOS Big sur");
		opt1.setBrowserVersion("133");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("username", "rajule.vikas");
		map1.put("accessKey", "LT_uytzedgvD76ZzMfcPrRlVnyZfnsYIxSRDEPa4OAp7iidUOY");
		map1.put("w3c", true);
		opt1.setCapability("LT:Options", map1);
	     URL gridURL1 = new URL("https://hub.lambdatest.com/wd/hub");
		
		//we need to pass the options class reference in the ChromeDriver constructor
		WebDriver driver1 = new RemoteWebDriver(gridURL1	, opt1);
		driver1.get("https://freelance-learn-automation.vercel.app/");
		System.out.println("Title is: "+driver1.getTitle());
		driver1.quit();	
		
		ChromeOptions opt2 = new ChromeOptions();
		opt2.setPlatformName("Linux");
		opt2.setBrowserVersion("133");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("username", "rajule.vikas");
		map2.put("accessKey", "LT_uytzedgvD76ZzMfcPrRlVnyZfnsYIxSRDEPa4OAp7iidUOY");
		map2.put("w3c", true);
		opt2.setCapability("LT:Options", map2);
	     URL gridURL2 = new URL("https://hub.lambdatest.com/wd/hub");
	     
	     WebDriver driver2 = new RemoteWebDriver(gridURL2	, opt2);
			driver2.get("https://freelance-learn-automation.vercel.app/");
			System.out.println("Title is: "+driver2.getTitle());
			driver2.quit();	
		
	}

}
