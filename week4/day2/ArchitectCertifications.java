package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*Assignments 2. *Architect Certifications*
		 
         1. Launch Salesforce application *https://login.salesforce.com/*
         2. Login with username as *ramkumar.ramaiah@testleaf.com* and password as *Password#123*
         3. Click on Learn More link in Mobile Publisher
         4. Click On Resources
         5. Select SalesForce Certification Under Learnings
         6. Choose Your Role as Salesforce Architect
         7. Get the Text(Summary) of Salesforce Architect 
         8. Get the List of Salesforce Architect Certifications Available
         9. Click on Application Architect 
        10. Get the List of Certifications available
		 
		*/
		//1. Launch Salesforce application *https://login.salesforce.com/*
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
		//Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//4. Click On Resources
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		//5. Select SalesForce Certification Under Learnings
		//click on learning
		Shadow dom=new Shadow(driver);
		WebElement shadowElement=dom.findElementByXPath("//span[text()='Learning']");//click on learning
		Actions act=new Actions(driver);
		act.moveToElement(shadowElement).click().perform();
		Thread.sleep(1000);
		//click on Learning on Trailhead
		Shadow dom1=new Shadow(driver);
		WebElement shadowElement2=dom1.findElementByXPath("//span[text()='Learning on Trailhead']");
		act.moveToElement(shadowElement2).perform();
		//Click on Salesforce Certifications
		Shadow dom2=new Shadow(driver);
		WebElement shadowElement3=dom2.findElementByXPath("//a[text()='Salesforce Certification']");
		act.moveToElement(shadowElement3).click().perform();
		
		// 6. Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
		
		//7. Get the Text(Summary) of Salesforce Architect 
		WebElement text=driver.findElement(By.xpath
		("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
		System.out.println("       Salesforce Architect");
		System.out.println("       ");
		System.out.println(text.getText());
		System.out.println("       ");
		
		//8. Get the List of Salesforce Architect Certifications Available
		List<WebElement> listCert = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("List of Salesforce Architect Certifications Available are");
		System.out.println("       ");
		int n=1;
		for(int i=0;i<listCert.size();i++) {
		System.out.println(n+". "+listCert.get(i).getText());
		n++;
		}
		System.out.println("       ");
		
		// 9. Click on Application Architect 
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		//10. Get the List of Certifications available
		List<WebElement> listCertForArchitect = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("List of Application Architect Certifications Available are");
		System.out.println("       ");
		for(int i=0;i<=3;i++) {
		System.out.println(listCertForArchitect.get(i).getText());
		
	} /*
		 * or we can also use this
		 *  for(WebElement s:listCertForArchitect) {
		 * System.out.println(n+". "+s.getText()); 
		 * n++;
		 * 
		 *}
		 */
		
	}

}
