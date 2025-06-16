package First;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Assignment {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://freelance-learn-automation.vercel.app/signup");		
		
		WebElement Namefield = driver.findElement(By.id("name"));
		Actions act = new Actions(driver);
		act.click(Namefield).sendKeys("Vikas").perform();
		act.sendKeys(Keys.TAB).sendKeys("vikas@gmail.com").sendKeys(Keys.TAB).sendKeys("Rajule").build().perform();
		
		act.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
		
		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(2000);
		//act.moveToElement(driver.findElement(By.xpath("//option[@value='Maharashtra']"))).pause(2000).click().perform();	
		
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		
		for (int i = 0; i < 14; i++) {
			act.sendKeys(driver.findElement(By.xpath("//select[@id='state']")), Keys.ARROW_DOWN).sendKeys(Keys.TAB).perform();
		}
		act.moveToElement(driver.findElement(By.xpath("//option[text()='Playing']"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Sign up']"))).click().perform();
		
		
		
		
		
	}

}
