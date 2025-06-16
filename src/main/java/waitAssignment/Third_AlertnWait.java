package waitAssignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Utility;

public class Third_AlertnWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/");
		
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		
		
		driver.findElement(By.xpath("//button[@class='nav-menu-item']")).click();
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.id("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		
		
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Manage']"))).perform();
		
		String Parentwindowhandle = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		
		
		Set<String> allwindowhandle = driver.getWindowHandles();
		
		for(String handle : allwindowhandle) {
			driver.switchTo().window(handle);
			String pageurl = driver.getCurrentUrl();
			if(pageurl.contains("category/manage")) {
				break;
			}
				
		}
		driver.findElement(By.xpath("//td[text()='Python']//following-sibling::td//button[text()='Update ']")).click();
		 WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
			Alert alt =wait.until(ExpectedConditions.alertIsPresent());
			alt.sendKeys("Python3");
			alt.accept();
		
			
			driver.findElement(By.xpath("//td[text()='Python3']//following-sibling::td//button[text()='Update ']")).click();
			
				Alert alt1 =wait.until(ExpectedConditions.alertIsPresent());
				alt1.sendKeys("Python");
				alt1.accept();
			
				driver.findElement(By.xpath("//img[@alt='menu']")).click();
				driver.findElement(By.xpath("//button[text()='Sign out']")).click();
				driver.quit();
		
		
		

	}

}
