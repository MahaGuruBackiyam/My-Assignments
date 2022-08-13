package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
driver.get("http://leaftaps.com/opentaps/control/login");
WebElement elementUsername = driver.findElement(By.id("username"));
elementUsername.sendKeys("Demosalesmanager");
WebElement elementPassword = driver.findElement(By.id("password"));
elementPassword.sendKeys("crmsfa");
WebElement elementlogin = driver.findElement(By.className("decorativeSubmit"));
elementlogin.click();
WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
elementCRMSFA.click();
WebElement elementlead = driver.findElement(By.linkText("Leads"));
elementlead.click();
WebElement elementCreateleads = driver.findElement(By.linkText("Create Lead"));
elementCreateleads.click();
WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
elementCompanyName.sendKeys("Wipro");
WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
elementFirstName.sendKeys("Wonder");
WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
elementLastName.sendKeys("Women");
WebElement elementFirstName_Local= driver.findElement(By.id("createLeadForm_firstNameLocal"));
elementFirstName_Local.sendKeys("WB");
WebElement elementDepartment = driver.findElement(By.id("createLeadForm_departmentName"));
elementDepartment.sendKeys("IT");
WebElement elementDescription= driver.findElement(By.id("createLeadForm_description"));
elementDescription.sendKeys("Newyork Nagaram urangum neram");
WebElement elementEmailAddress= driver.findElement(By.id("createLeadForm_primaryEmail"));
elementEmailAddress.sendKeys("wonderwomangoingto@space.com");
WebElement elementState_Province= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
Select dd=new Select(elementState_Province);
dd.selectByVisibleText("New York");
WebElement elementClickCreate = driver.findElement(By.className("smallSubmit"));
elementClickCreate.click();
if(driver.getTitle().contains("View Lead")){
	System.out.println("I confirm the title has View Lead");
	
}
else {
	System.out.println("The title does not have the word View Lead");
	
}
	}

}
