package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		System.out.println("Enter the username");
		WebElement elementUsername = driver.findElement(By.xpath("//input[@id='username']"));
		elementUsername.sendKeys("Demosalesmanager");
		
		System.out.println("Enter the password");
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementPassword.sendKeys("crmsfa");
		
		System.out.println("Click Login");
		WebElement elementlogin = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementlogin.click();
		
		System.out.println("Click crm/sfa link");
		WebElement elementCRMSFA = driver.findElement(By.xpath("//a[contains (text(), 'CRM/SFA')]"));
		elementCRMSFA.click();
		
		System.out.println("Click Leads link");
		WebElement elementlead = driver.findElement(By.xpath("(//div[@class='x-panel-header']/a)[2]"));
		elementlead.click();
		
		System.out.println("Click Find leads");
		WebElement elementFindleads = driver.findElement(By.xpath("//a[contains (text(),'Find Leads')]"));
		elementFindleads.click();
		
		System.out.println("Click on Phone");
		WebElement element1 = driver.findElement(By.xpath("//span[contains (text(),'Phone')]"));
		element1.click();
		
		System.out.println("Enter phone number");
		WebElement elementPhone = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		elementPhone.sendKeys("9");
		
		System.out.println("Click find leads button");
		WebElement element2 = driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]"));
		element2.click();

		System.out.println("Capture lead ID of First Resulting lead and Click First Resulting lead");
		Thread.sleep(5000);
		WebElement element3 = driver
				.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']"));
		String s = element3.getText();
		element3.click();

		System.out.println("Click Delete");
		Thread.sleep(5000);
		WebElement elementDelete = driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']"));
		elementDelete.click();
		
		System.out.println("Click Find leads");
		WebElement elementFindleads1 = driver.findElement(By.xpath("//a[contains (text(),'Find Leads')]"));
		elementFindleads1.click();
		
		System.out.println("Enter captured lead ID");
		WebElement elementLeadID = driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[13]"));
		elementLeadID.sendKeys(s);
		
		System.out.println("Click find leads button");
		WebElement elementFindleads2 = driver.findElement(By.xpath("(//em[@unselectable='on']/button)[7]"));
		elementFindleads2.click();
		
		System.out.println("Verify message \"No records to display\" in the Lead List. This message confirms the successful deletion");
		Thread.sleep(5000);
		boolean displayed = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		if (displayed) {
			System.out.println("No records to display is Displayed");

		} else {
			System.out.println("No records to display is Not displayed");

		}
		
		System.out.println("Close the browser");
		driver.close();
		/*
		 * Thread.sleep(5000); WebElement element4 = driver.findElement(By.
		 * xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		 * element4.click();
		 */

		// driver.findElement(By.name("id")).sendKeys(s);
		// boolean displayed=driver.findElement(By.xpath("//div[text()='No records to
		// display']")).isDisplayed();
		// System.out.println(displayed);

	}

}
