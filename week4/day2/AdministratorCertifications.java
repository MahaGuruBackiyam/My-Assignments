package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.sukgu.Shadow;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	 /* Assignments *1. Administrator Certifications*
		==============================
		1. Launch Salesforce application *https://login.salesforce.com/*
		2. Login with username as *ramkumar.ramaiah@testleaf.com* and password as *Password#123*
		3. Click on Learn More link in Mobile Publisher
		4. Click confirm on Confirm redirect
		5. Click Resources and mouse hover on Learning On Trailhead
		6. Click on Salesforce Certifications
		7. Click on Ceritification Administrator
		8. Navigate to Certification - Administrator Overview window
		9. Verify the Certifications available for Administrator Certifications should be displayed
	*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with username as *ramkumar.ramaiah@testleaf.com* and password as *Password#123*
		//Entering user name
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		//Entering password
		driver.findElement(By.id("password")).sendKeys("Password#123");
		//click on the login button
		driver.findElement(By.id("Login")).click();
		Thread.sleep(1000);
		
		// 3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
		
		//4. Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//5. Click Resources and mouse hover on Learning On Trailhead
		//Click Resources
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		//mouse hover on Learning On Trailhead
		/*In dom the web element for learning is under #shadow 
		in order to locate that web element we are using this*/
		Shadow dom=new Shadow(driver);
		WebElement shadowElement=dom.findElementByXPath("//span[text()='Learning']");//click on learning
		Actions act=new Actions(driver);
		act.moveToElement(shadowElement).click().perform();
		Thread.sleep(1000);
		//click on Learning on Trailhead
		//Shadow dom1=new Shadow(driver);
		WebElement shadowElement2=dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		act.moveToElement(shadowElement2).perform();
		
		//6. Click on Salesforce Certifications
		//Shadow dom2=new Shadow(driver);//No need to do this again dom will work for all the shadow window
		WebElement shadowElement3=dom.findElementByXPath("//a[text()='Salesforce Certification']");
		act.moveToElement(shadowElement3).click().perform();
		
		//7. Click on Ceritification Administrator
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		
		//8. Navigate to Certification - Administrator Overview window
		Set<String>set2=driver.getWindowHandles();
		List<String>list2=new ArrayList<String>(set2);
		driver.switchTo().window(list2.get(1));	
		
		//9. Verify the Certifications available for Administrator Certifications should be displayed
		System.out.println("The Certifications available for Administrator are: ");
		System.out.println("   ");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']/a"));
		int n=1;
		for(WebElement s:findElements) {
			System.out.println(n+". "+s.getText());
		    n++;
		}
	}
	
}
