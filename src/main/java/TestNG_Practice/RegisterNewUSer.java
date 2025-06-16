package TestNG_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import helper.Utility;

public class RegisterNewUSer  {
	
	WebDriver driver;
	String Email ;
	String Password ;
	
	@BeforeClass
	public void initializeBrowser() {
		
		driver = Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/login");
		
	}
		
	@Test
	public void registerNewUSerWithValidDetails() {
	
	driver.findElement(By.xpath("//a[@href='/signup']")).click();
	WebElement SignUp= driver.findElement(By.xpath("//h2[text()='Sign Up']"));
	Assert.assertTrue(SignUp.isDisplayed(), "Sign Up Page not shown");

	WebElement SignupButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
	Assert.assertFalse((SignupButton.isEnabled()), "Sign up button is not disabled");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	Faker fake = new Faker();
	String name = fake.address().firstName();
	    Email = name.concat("@email.com");
	    Password = name.concat("@123");

	driver.findElement(By.id("name")).sendKeys("Vikas");
	driver.findElement(By.id("email")).sendKeys(Email);
	driver.findElement(By.id("password")).sendKeys(Password);
	driver.findElement(By.xpath("//label[text()='Python']")).click();

	Select state = new Select(driver.findElement(By.xpath("//select[@id='state']")));
	state.selectByVisibleText("Maharashtra");

	Select hobbie = new Select(driver.findElement(By.xpath("//select[@id='hobbies']")));
	hobbie.selectByVisibleText("Singing");

	Actions actions = new Actions(driver);
	actions.moveToElement(SignupButton).perform();

	Assert.assertTrue((SignupButton.isEnabled()), "Sign up button is not enabled");
	SignupButton.click();

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='close']")));

	String scsmessage = driver.findElement(By.xpath("//div[@role='alert']")).getText();
	String Expected ="Signup successfully, Please login!";
	Assert.assertEquals(scsmessage,Expected, "Success message is not shown or wrong.");

	}

	@Test (priority = 1)
	public void loginWithNewUser(){	
		
	driver.findElement(By.id("email1")).sendKeys(Email);
	driver.findElement(By.id("password1")).sendKeys(Password);
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	boolean isWelcomemsgshown = driver.findElement(By.xpath("//h4[@class='welcomeMessage']")).isDisplayed();
	Assert.assertTrue(isWelcomemsgshown);
	
	WebElement ele = driver.findElement(By.xpath("//h4[@class='welcomeMessage']"));
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOf(ele));

	driver.findElement(By.xpath("//img[@alt='menu']")).click();
	driver.findElement(By.xpath("//button[text()='Sign out']")).click();

	boolean signinheader = driver.findElement(By.xpath("//h2[text()='Sign In']")).isDisplayed();
	Assert.assertTrue(signinheader, "SignOut is not successful!");

	}

	@AfterClass
    public void teardown() {
		
            Utility.closeBrowser(driver);
	}
}
