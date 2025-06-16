package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePackages.BaseClass;



public class CrossBrowser_Parallel extends BaseClass{
	
	WebDriver driver;
		
	@Test
	public void LoginandLogout()
	{		
		//1. Login Application
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();		

		//2.Verify the login is successful
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("dashboard"), "User is not logged in successfully.");		

		//3.Logout application
		driver.findElement(By.xpath("//span//img[contains(@src,'viewPhoto')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();	

		//4. Verification after logout
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("login"));
		
		String logout_url = driver.getCurrentUrl();
		Assert.assertTrue(logout_url.contains("login"), "User is not logged out successfully.");		

	}

}
