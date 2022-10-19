package Pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;

public class LoginPage {
	
	WebDriver driver;
	public static String LoginButtonxpath="//button[@type='submit']";
	
	public void LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Login()
	{
		
		
		
	}
	
	public void OpenOrangeHRM(String TestURL)
	{
		driver.get(TestURL);
	}
	
	public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);

	        
	    }
	    return elem;
	}
	
	



	public void LoginCredentials(DataTable dataTable) throws Exception {
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<Map<String, String>> login=dataTable.asMaps(String.class,String.class);
		
		String username1=login.get(0).get("Username");
		String password1=login.get(0).get("Password");
		
		 findElement(By.name("username")).sendKeys(username1);
		  findElement(By.name("password")).sendKeys(password1);
		  findElement(By.xpath(LoginButtonxpath)).click();
		  Thread.sleep(5000);
		
	}
	
	
	
}
