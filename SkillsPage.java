package Pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;

public class SkillsPage {
	
	WebDriver driver;
	
	public void SkillsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);

	        
	    }
	    return elem;
	}

	
	
	public void AddSkills(DataTable dataTable) throws Exception {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<Map<String, String>> SkillsData=dataTable.asMaps(String.class,String.class);
		
		for(int i=0;i<SkillsData.size();i++) {
			
			String SkillName=SkillsData.get(i).get("SKILLNAME");
			String SkillDescr=SkillsData.get(i).get("SKILLDESCR");
			
			System.out.println("____________________________");
			
			  findElement(By.xpath("//span[text()='Admin']")).click();
			  findElement(By.xpath("//span[text()='Qualifications ']")).click();
			  findElement(By.xpath("//a[text()='Skills']")).click();
			  findElement(By.xpath("//button[text()=' Add ']")).click();
			  
			 findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(SkillName);
			  findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(SkillDescr);
			  
			  Thread.sleep(5000);
			  findElement(By.xpath("//button[text()=' Save ']")).click();
		
	}
	}
	
	
	
}
