package First;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Alert_Assignment {

	public static void main(String[] args) {
		
      WebDriver driver = new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
      driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
      Alert alert = driver.switchTo().alert();
      String Js_Alert_Text=alert.getText();
      System.out.println("Alert has correct value?  "+Js_Alert_Text.contains("JS Alert"));
      alert.accept();
      driver.close();
      
      WebDriver driver1 = new EdgeDriver();
      driver1.get("https://the-internet.herokuapp.com/javascript_alerts");
      driver1.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
      Alert alert1 = driver1.switchTo().alert();
      String Js_Confirm_Text = alert1.getText();
      System.out.println("Confirm has correct value? "+Js_Confirm_Text.contains("JS Confirm"));
      alert1.dismiss();
      driver1.close();
      
      WebDriver driver2 = new FirefoxDriver();
      driver2.get("https://the-internet.herokuapp.com/javascript_alerts");
      driver2.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
      Alert alert2 = driver2.switchTo().alert();
      String Js_Prompt_Text = alert2.getText();
      System.out.println("prompt has correct value? "+ Js_Prompt_Text.contains("JS prompt"));
      alert2.sendKeys("Selenium");      
      alert2.accept();
     // driver2.switchTo().defaultContent();
      System.out.print("Result contains correct text? ");
      String[] You_added = driver2.findElement(By.xpath("//p[@id='result']")).getText().split(": ");
      System.out.println(You_added[1]);
     boolean Result= You_added[1].contains("Selenium");
     System.out.print(Result);
		
	}

}
