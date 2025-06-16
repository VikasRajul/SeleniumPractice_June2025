package First;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Breakout_Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		WebElement managelement = driver.findElement(By.xpath("//span[text()='Manage']"));
		Actions act = new Actions(driver);
		act.moveToElement(managelement).perform();
		
		driver.findElement(By.xpath("//a[@href='/course/manage']")).click();
		driver.findElement(By.xpath("//button[text()='Add New Course ']")).click();
		
		//Verify Error message shown if nothing filled
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String erromessage  = driver.findElement(By.xpath("//h2[@class='errorMessage']")).getText();
		String Expected = "Please fill all the fields";
		if(erromessage.contains(Expected)) {
			System.out.println("Error message is valid.");
		}else {
			System.out.println("Incorrect error message");
		}
		//Upload file
		driver.findElement(By.xpath("//input[@id='thumbnail']")).sendKeys("C:/Users/Vikas/Desktop/Task.png");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("API_By_Mukesh");
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("New API");
		driver.findElement(By.xpath("//input[@id='instructorNameId']")).sendKeys("Mukesh");
		driver.findElement(By.xpath("//input[@id='price']")).sendKeys("15000");
		
		driver.findElement(By.name("startDate")).click();
		driver.findElement(By.xpath("//div[text()='15']")).click();
		
		driver.findElement(By.name("endDate")).click();
		driver.findElement(By.xpath("//div[text()='23']")).click();
		driver.findElement(By.xpath("//div[text()='Select Category']")).click();
		driver.findElement(By.xpath("//button[text()='AWS']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//Verify course added and active
		String ExpectedCourse = driver.findElement(By.xpath("//td[text()='API_By_Mukesh']")).getText();
		if(ExpectedCourse.contains("API_By_Mukesh")) {
			System.out.println("Course is added successfully.");
		}else {
			System.out.println("Course not added.");
		}
		
	  String activevalue= driver.findElement(By.xpath("//td[text()='API_By_Mukesh']//following::img[1]")).getDomAttribute("alt");
	 if(activevalue.contains("activate")) {
		 System.out.println("Course is active");
	 }else {
		 System.out.println("Course is inactive");
	 }
		//Delete the course
		driver.findElement(By.xpath("//td[text()='API_By_Mukesh']//following::button[1]")).click();
		
		//Ensure that course is deleted
		List<WebElement> allcourses = driver.findElements(By.xpath("//td[text()='API_By_Mukesh']"));
		if(allcourses.size()==0) {
        System.out.println("Course is deleted properly");
	}else {
		System.out.println("Course not deleted");
	}
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
	}
}
