package First;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Assignment_Xpath_Axes {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		//1.open the website
		driver.get("https://www.saucedemo.com/v1/index.html");
		
		//2.Login to the application
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[contains(@data-test,'password')]")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//3.Verify successful login
		String urlname = driver.getCurrentUrl();
		System.out.println("Url is "+urlname);
		System.out.println("Does url contains inventory? "+urlname.contains("inventory"));
		
		//4.Add products to cart
		//add the "Bike Light"
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']//ancestor::div[@class='inventory_item']//button[text()='ADD TO CART']")).click();
	    String firstPrice = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']//ancestor::div[@class='inventory_item']//div[text()='$']")).getText();
		//add the "Fleece Jacket"
		driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']//ancestor::div[@class='inventory_item']//button[text()='ADD TO CART']")).click();
	    String secondPrice = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']//ancestor::div[@class='inventory_item']//div[text()='$']")).getText();
	    System.out.println("Prices are "+ firstPrice +"  "+secondPrice);
	    double Tax = 4.80;
	    String first = firstPrice.replaceAll("[^\\d.]", "");
	    String second = secondPrice.replaceAll("[^\\d.]", "");
	    double Sum = Double.parseDouble(first) + Double.parseDouble(second) + Tax;
	   System.out.println(Sum);
	
	   //5. Verify Cart Count
	  String cartcount = driver.findElement(By.xpath("//span[contains(@class,'shopping_cart_badge')]")).getText();
	  int count = Integer.parseInt(cartcount); 
	  System.out.println("Cart Count is 2 only ? "+ (count==2));
	  
	  //6.Proceed to CheckOut
	  driver.findElement(By.xpath("//*[@data-icon='shopping-cart']")).click();
	  driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
	  
      //7.Enter customer details.
	  driver.findElement(By.id("first-name")).sendKeys("Vikas");
	  driver.findElement(By.id("last-name")).sendKeys("Rajule");
	  driver.findElement(By.id("postal-code")).sendKeys("411033");
	  driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
	  
	  //8.Verify total price before purchase
	 String totalprice = driver.findElement(By.className("summary_total_label")).getText();
	 String cleardtoal = totalprice.replaceAll("[^\\d.]", "");
	
	 
	 double finalvalue = Double.parseDouble(cleardtoal);
	 System.out.println(finalvalue);
	 System.out.println("Total Price are correct "+(finalvalue==Sum));
	 
	 //9. Complete the Purchase
	 driver.findElement(By.xpath("//a[text()='FINISH']")).click();
	 String message = driver.findElement(By.className("complete-header")).getText();
	 System.out.println("Confirmation message is correct? "+ message.equalsIgnoreCase("THANK YOU FOR YOUR ORDER"));
	 
	 //10.Logout 
	 driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	 driver.findElement(By.id("logout_sidebar_link")).click();
	 String url = driver.getCurrentUrl();
	 System.out.println("Url contains index Logout successful: "+url.contains("index.html"));
	// driver.close();
	
	
	
	
	}

}
      