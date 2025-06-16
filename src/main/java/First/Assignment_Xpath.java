package First;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Assignment_Xpath {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[contains(@data-test,'password')]")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		 List<WebElement> listprice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		 System.out.println("Price of all items are: ");
		for(WebElement le : listprice) {
			System.out.println(le.getText());
		}
		
		List<WebElement> addtoCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
		System.out.println("All the Add to Cart Buttons are: ");
		for(WebElement adcrt : addtoCart ) {			
			System.out.println(adcrt.getText());
		}
		
		List<WebElement> mediabutton =  driver.findElements(By.xpath("//footer[@class=\"footer\"]/ul/li"));
		System.out.println("All Social media buttons are: ");
		
		for(WebElement smb:mediabutton) {
			System.out.println(smb.getText());
		}
		driver.findElement(By.xpath("//button[text() = 'Open Menu']")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> allmenulinks = driver.findElements(By.xpath("//a[@class='bm-item menu-item']"));
		System.out.println("All the Menu Links are: ");
		for(WebElement aml : allmenulinks) {
			System.out.println(aml.getText());
			
			
			
			
			WebElement btn=driver.findElement(By.xpath("//div[@class='bm-menu-wrap']//button"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
			
			System.out.println("Done");
			
		}
	}
	

}
