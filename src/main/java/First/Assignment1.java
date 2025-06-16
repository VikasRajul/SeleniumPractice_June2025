package First;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		chromemethod();
		firefoxmethod();
		edgemethod();
	}
	
	static void chromemethod() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/");
		String title = "Browser Automation";
		Thread.sleep(5000);
		String pagetitle = driver.getTitle();
		if(pagetitle.contains(title)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	      driver.close();
	}

	static void firefoxmethod() throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();

		driver.get("https://www.selenium.dev/documentation/");
		String title = "Browser Automation";
		Thread.sleep(5000);
		String pagetitle = driver.getTitle();
		if(pagetitle.contains(title)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	      driver.close();

	}
 
	static void edgemethod() throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();

		driver.get("https://www.selenium.dev/documentation/");
		String title = "Browser Automation";
		Thread.sleep(5000);
		String pagetitle = driver.getTitle();
		if(pagetitle.contains(title)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	      driver.close();

	}

	
	
}
