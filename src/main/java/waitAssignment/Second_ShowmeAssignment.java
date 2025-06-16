package waitAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Utility;

public class Second_ShowmeAssignment {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver =Utility.startBrowser("Chrome", "https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		driver.findElement(By.xpath("//input[@value='Show me']")).click();
		WebElement pass2 = driver.findElement(By.id("passnew"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement password2 =wait.until(ExpectedConditions.elementToBeClickable(By.id("passnew")));
		
	    //System.out.println(password2.getDomAttribute("value"));
		if(pass2.isEnabled()) {
			password2.sendKeys("MyNewPassword");
			System.out.println("Password entered successfully.");
		}else {
			System.out.println("Failed to enable password field");
		}

	}

}
