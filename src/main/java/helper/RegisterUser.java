package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Utility.startBrowser("Chrome", "https://freelance-learn-automation.vercel.app/signup");
		WebElement state = driver.findElement(By.id("state"));
		Utility.selectValueFromDropdown(state, "Goa");

	}

}
