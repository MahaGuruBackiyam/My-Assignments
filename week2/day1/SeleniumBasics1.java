package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasics1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// To add driver code that is specific to the browser
		WebDriverManager.chromedriver().setup();
//To open browser
		ChromeDriver driver = new ChromeDriver();
//To open the web application using url
		driver.get("http://leaftaps.com/opentaps");
//To maximize the screen of the browser
		driver.manage().window().maximize();
//To close the browser
//		driver.close();
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.name("PASSWORD"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementlogin = driver.findElement(By.className("decorativeSubmit"));
		elementlogin.click();
		WebElement elementWelcomeMessage = driver.findElement(By.tagName("h2"));
//elementWelcomeMessage.getText();
		System.out.println(elementWelcomeMessage.getText());
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		WebElement elementlead = driver.findElement(By.linkText("Leads"));
		elementlead.click();
		WebElement elementCreateleads = driver.findElement(By.linkText("Create Lead"));
		elementCreateleads.click();
		WebElement elementSourceDD1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		elementSourceDD1.sendKeys("Conference");
		WebElement elementSourceDD2 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd2 = new Select(elementSourceDD2);
		dd2.selectByVisibleText("Aerospace");
		WebElement elementSourceDD3 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd3 = new Select(elementSourceDD3);
		dd3.selectByIndex(2);
		WebElement elementSourceDD4 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dd4 = new Select(elementSourceDD4);
		dd4.selectByValue("CATRQ_AUTOMOBILE");
	}
}

/*URL for leaftaps: http://leaftaps.com/opentaps
Credentials: Demosalesmanager/crmsfa*/


