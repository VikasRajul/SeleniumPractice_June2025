package waitAssignment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Utility;

public class First {

	public static void main(String[] args) {
		
		WebDriver driver =Utility.startBrowser("Chrome", "https://seleniumpractise.blogspot.com/2025/03/title-changes-after-few-seconds.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.titleIs("Selenium"));
		
		String titlevalue = driver.getTitle();
		if(titlevalue.equals("Selenium")) {
			System.out.println("Title Verified.");
			
		}else {
			System.out.println("Title Not Verified.");
		}
			driver.close();
		

	}

}
