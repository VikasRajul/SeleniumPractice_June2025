package First;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Assignment_for_FindElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");		
		driver.findElement(By.linkText("New user? Signup")).click();
		System.out.println("Verify Number of Dropdown 2 ?");
		Thread.sleep(3000);
		int totaldropdown =driver.findElements(By.tagName("select")).size();
		System.out.println(totaldropdown);
		System.out.println(totaldropdown==2);
		System.out.println("Verify total no. of radio buttons 2? ");
		int totalradiobtn =driver.findElements(By.xpath("//div[@class='gender-div']")).size();
		System.out.println(totalradiobtn);
		System.out.println(totalradiobtn==2);
		
		System.out.println("Verify Number of Checkbox should be > 5 ?");
		int totalcheckbox = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println(totalcheckbox);
		System.out.println(totalcheckbox > 5);
		
		System.out.println("Verify No. of state > 20? ");
		int totalstate = driver.findElements(By.xpath("//select[@name='state']/option")).size();
		System.out.println(totalstate);
		System.out.println(totalstate > 20);
		
		List<WebElement> allstate =driver.findElements(By.xpath("//select[@name='state']/option"));
		for(WebElement state: allstate) {
			
			//System.out.println(state.getText());
			if(state.getText().contains("Goa")) {
				System.out.println("Goa is present in the State dropdown");
				break;
			}
		}
	}

}
