package First;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmrnt2OrangeHRM {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String title =driver.getTitle();
		if(title.contains("HRM")) {
			System.out.println("Title is correct");
		}else {
			System.out.println("Title is incorrect");
		}
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		String dasboardtitle=driver.getCurrentUrl();
		System.out.println(dasboardtitle);
		if(dasboardtitle.contains("dashboard")){
			System.out.println("Title has the dashboard.");			
		}else {
			System.out.println("There is no dashboard in title.");
		}
		
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']")).click();
		
		
		
	}

}
