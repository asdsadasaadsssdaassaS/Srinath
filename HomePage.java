package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public void HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Logout() throws Exception
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		findElement(By.linkText("Logout")).click();
		
		Thread.sleep(3000);
		
	}
	
	public void CloseBrowser()
	{
		
		driver.quit();
		
	}
	
	public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);

	        
	    }
	    return elem;
	}
	
	
	
}
