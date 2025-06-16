package First;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateNew_AccountAssignment {

	public static void main(String[] args) {
       WebDriver driver = new ChromeDriver();
       driver.get("https://demo.nopcommerce.com/");
        String  title =  driver.getTitle();
        if(title.contains("demo")) {
        	System.out.println("Title has the demo");
        }else {
        	System.out.println("Title is incorrect");
        }
    //river.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']")).click();
    driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
      System.out.println("Url contains register "+ driver.getCurrentUrl().contains("register"));
     List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
        for(int i=0; i<radio.size(); i++) {
        	System.out.println("radio button selected "+radio.get(i).isSelected());
        }
      driver.findElement(By.id("gender-male")).click();
      driver.findElement(By.id("FirstName")).sendKeys("Vikas");
      driver.findElement(By.id("LastName")).sendKeys("Rajule");
      String email = "Vikas.rajule"+ System.currentTimeMillis()+"@gmail.com";
      driver.findElement(By.name("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys("LTIMindtree");
       System.out.println("NewsLetter is bydefault Selected "+driver.findElement(By.id("Newsletter")).isSelected());
       driver.findElement(By.id("Newsletter")).click();
       driver.findElement(By.id("Password")).sendKeys("Pass@1234");
       driver.findElement(By.id("ConfirmPassword")).sendKeys("Pass@1234");
    System.out.println("Button text is Register "+  driver.findElement(By.id("register-button")).getText().equals("REGISTER"));
    driver.findElement(By.id("register-button")).click();
	}

}
