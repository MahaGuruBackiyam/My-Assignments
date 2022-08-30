package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator
		WebElement elementlogin = driver.findElement(By.className("decorativeSubmit"));
		elementlogin.click();
		
		//4. Click on CRM/SFA Link
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		
		// 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of windows openned: " + windowHandles.size());
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		Thread.sleep(1000);
		
		//8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		driver.switchTo().window(list.get(0));
		Thread.sleep(1000);
		
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println("Number of windows openned: " + windowHandles2.size());
		List<String> list1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(1000);
		
		// 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(list1.get(0));
		Thread.sleep(1000);
		
		//11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Text in alert  " + alert.getText());
		alert.accept();
		Thread.sleep(1000);
		
		//13. Verify the title of the page
		System.out.println(driver.getTitle());
	}
}
/**We are getting the reference of windows in 2 sets even 
 * though they are same but once the first resulting contact clicked it will go back to the parent window
 * then again when the Widget is clicked
 * the unique reference will be changed for second resulting contact page
 * so doing twice*/
