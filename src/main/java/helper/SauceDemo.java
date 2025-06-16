package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemo {

	public static void main(String[] args) {
		
		WebDriver driver = Utility.startBrowser("chrome", "https://www.saucedemo.com/v1/index.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Utility.closeBrowser(driver);
		



	}

}
