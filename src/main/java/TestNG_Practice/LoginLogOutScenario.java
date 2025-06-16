package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.Utility;

public class LoginLogOutScenario {
	WebDriver driver;
	
	@BeforeClass
	public void initializeBrowser() {
		
		driver = Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		
	}
	
	
	
	@Test
	public void loginWithValidScenario() {
		// driver = Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.id("password1")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='welcomeMessage']")));
        
		String Expectedmessage = "Welcome Admin Manager to Learn Automation Courses";
		String Actualmessage = message.getText();
		Assert.assertEquals(Actualmessage, Expectedmessage, "Welcome message is not present.");
		
		
	}
     
	@Test(dependsOnMethods = "loginWithValidScenario" )
	public void logoutFromApplication()
	{
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
		WebElement text_SignIn = driver.findElement(By.xpath("//h2[text()='Sign In']"));
		Assert.assertTrue(text_SignIn.isDisplayed(), "Logout is not successful.");
		
	}
	
	@AfterClass
    public void teardown() {
		
            Utility.closeBrowser(driver);
	}
	
}
