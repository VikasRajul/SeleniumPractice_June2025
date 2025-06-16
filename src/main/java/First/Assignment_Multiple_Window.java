package First;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Assignment_Multiple_Window {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1.Login
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		Thread.sleep(3000);
		
		//Get Parent Window Handle
		String Parentwindow = driver.getWindowHandle();
		
		//Navigate to Manage Categories and Click on Add new Category
		WebElement managelement = driver.findElement(By.xpath("//span[text()='Manage']"));
		Actions act = new Actions(driver);
		act.moveToElement(managelement).perform();
		driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String handle : allwindows) {
			driver.switchTo().window(handle);
			String url = driver.getCurrentUrl();
			if(url.contains("/category/manage")) {
				driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();

			}
		}
		
		//Iterator<String> itr = allwindows.iterator();
		/*while(itr.hasNext()) {
			String parent = itr.next();
			String ChildWindow = itr.next();
			driver.switchTo().window(ChildWindow);
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
		}*/
		//Add AWS as new category
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("AWS");
		alt.accept();
		Thread.sleep(2000);
		List<WebElement> allcourses = driver.findElements(By.xpath("//table[contains(@class,'category-table')]/tbody/tr/td[1]"));
		
		//Verify its added successfully
		for(WebElement allvalue : allcourses) {
			//System.out.println(allvalue.getText());
			if(allvalue.getText().equals("AWS")) {
				System.out.println("AWS is listed on Manage Categorie Page Table/list");
				break;
			}
			
		}
		//Sign Out
		driver.findElement(By.xpath("//img[contains(@src,'menu')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign out']")).click();
		Thread.sleep(2000);
		
		//Navigate to Sign In page and check AWS is there or not
		driver.findElement(By.xpath("//a[@href='/signup']")).click();
		Thread.sleep(3000);
		List<WebElement> allCategories =    driver.findElements(By.xpath("//div[@class='interests-div']/div/label"));
		for(WebElement allcat : allCategories) {
			if(allcat.getText().equals("AWS")){
				System.out.println("Added value AWS is present on the Sign UP Page");
				break;
			}
		}
		//Go to sign in
		driver.findElement(By.xpath("//a[@class='subLink']")).click();
		
		//Login again
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.className("submit-btn")).click();
		Thread.sleep(4000);
		
		//
		//Get Parent Window Handle
				String Parentwindow1 = driver.getWindowHandle();
				
				//Navigate to Manage Categories and Click on Add new Category
				//WebElement managelement = driver.findElement(By.xpath("//span[text()='Manage']"));
				Actions act1 = new Actions(driver);
				act1.moveToElement(driver.findElement(By.xpath("//span[text()='Manage']"))).perform();
				driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
				Thread.sleep(2000);
				Set<String> allwindows1 = driver.getWindowHandles();
				
				for(String handle1 : allwindows1) {
					driver.switchTo().window(handle1);
					String url1 = driver.getCurrentUrl();
					if(url1.contains("/category/manage")) {
                     driver.findElement(By.xpath("//td[text()='AWS']//following::td//img[@alt='update']")).click();
              		Thread.sleep(3000);
                     Alert alt1 = driver.switchTo().alert();
             		alt1.sendKeys("AZURE");
             		alt1.accept();
             		Thread.sleep(2000);
             		
					}
				}
				List<WebElement> allcourses1 = driver.findElements(By.xpath("//table[contains(@class,'category-table')]/tbody/tr/td[1]"));
				
				//Verify its added successfully
				for(WebElement allvalue : allcourses1) {
					//System.out.println(allvalue.getText());
					if(allvalue.getText().equals("AZURE")) {
						System.out.println("Updated to AZURE on Manage Categorie page.");
						break;
					}
					
				}
				
				//Sign Out
				driver.findElement(By.xpath("//img[contains(@src,'menu')]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[text()='Sign out']")).click();
				Thread.sleep(2000);
				
				//Navigate to Sign In page and check AWS is there or not
				driver.findElement(By.xpath("//a[@href='/signup']")).click();
				Thread.sleep(3000);
				List<WebElement> allCategories1 =    driver.findElements(By.xpath("//div[@class='interests-div']/div/label"));
				for(WebElement allcat : allCategories1) {
					if(allcat.getText().equals("AZURE")){
						System.out.println("Updated value : AZURE is present on the Sign UP Page");
						break;
					}
				}
				
				//Go to sign in
				driver.findElement(By.xpath("//a[@class='subLink']")).click();
				
				//Login again
				driver.findElement(By.id("email1")).sendKeys("admin@email.com");
				driver.findElement(By.name("password1")).sendKeys("admin@123");
				driver.findElement(By.className("submit-btn")).click();
				Thread.sleep(4000);
				
				//
				//Get Parent Window Handle
						//String Parentwindow1 = driver.getWindowHandle();
						
						//Navigate to Manage Categories and Click on Add new Category
						//WebElement managelement = driver.findElement(By.xpath("//span[text()='Manage']"));
						Actions act2 = new Actions(driver);
						act2.moveToElement(driver.findElement(By.xpath("//span[text()='Manage']"))).perform();
						driver.findElement(By.xpath("//a[text()='Manage Categories']")).click();
						Thread.sleep(2000);
						Set<String> allwindows2 = driver.getWindowHandles();
						
						for(String handle2 : allwindows2) {
							driver.switchTo().window(handle2);
							String url2 = driver.getCurrentUrl();
							if(url2.contains("/category/manage")) {
		                     driver.findElement(By.xpath("//td[text()='AZURE']//following::td//img[@alt='delete']")).click();
		                     driver.findElement(By.xpath("//button[text()='Cancel']//following-sibling::button")).click();
		                     System.out.println("AZURE is removed from Manage Category");
							}
						}
						
						//Sign Out
						driver.findElement(By.xpath("//img[contains(@src,'menu')]")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[text()='Sign out']")).click();
						Thread.sleep(2000);
						
						//Navigate to Sign In page and check AWS is there or not
						driver.findElement(By.xpath("//a[@href='/signup']")).click();
						Thread.sleep(3000);
						List<WebElement> allCategories3 =    driver.findElements(By.xpath("//div[@class='interests-div']/div/label"));
						for(WebElement allcat : allCategories3) {
							System.out.println(allcat.getText());
							if(allcat.getText().contains("AZURE")){
								System.out.println("AZURE is  present on the Sign UP Page");

							}
						}
						System.out.println("AZURE is NOT present on the Sign UP Page");

					driver.quit();
				
	}

}
