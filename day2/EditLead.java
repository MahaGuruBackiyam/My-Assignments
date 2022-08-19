package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement elementUsername = driver.findElement(By.xpath("//input[@id='username']"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementlogin = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementlogin.click();
		WebElement elementCRMSFA = driver.findElement(By.xpath("//a[contains (text(), 'CRM/SFA')]"));
		elementCRMSFA.click();
		WebElement elementlead = driver.findElement(By.xpath("(//div[@class='x-panel-header']/a)[2]"));
		elementlead.click();
		WebElement elementFindleads = driver.findElement(By.xpath("//a[contains (text(),'Find Leads')]"));
		elementFindleads.click();
		WebElement elementFirstName = driver.findElement(By.xpath("(//input[@autocomplete='off'])[31]"));
	elementFirstName.sendKeys("Wonder");
	Thread.sleep(5000);
	WebElement element1 = driver.findElement(By.xpath("(//div[contains (@class ,'x-grid3-c')]/a)[1]"));
	element1.click();
	if(driver.getTitle().contains("View Lead")){
		System.out.println("I confirm the title has View Lead");
		
	}
	else {
		System.out.println("The title does not have the word View Lead");
		
	}
	WebElement element2 = driver.findElement(By.xpath("//a[contains (text(),'Edit')]"));
	element2.click();
	WebElement element3 = driver.findElement(By.xpath("(//input[@name='companyName'])[2]"));
	element3.click();
	element3.clear();
	element3.sendKeys("Tesla");
	WebElement element4 = driver.findElement(By.xpath("//input[@value='Update']"));
	element4.click();
	if(driver.getPageSource().contains("Tesla")){
		System.out.println("I confirm that the changed name appears ");
		
	}
	else {
		System.out.println("The changed name does not appear");
		
	}
	
	driver.close();

	}
}
