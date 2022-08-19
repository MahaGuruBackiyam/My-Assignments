package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
      driver.get("https://en-gb.facebook.com/");
      driver.manage().window().maximize();
      Thread.sleep(5000);
      WebElement elementCreate=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
      elementCreate.click();
      Thread.sleep(5000);
      WebElement elementFirstName=driver.findElement(By.xpath("//div[@class='_5dbb']/input"));
      elementFirstName.sendKeys("Dar");
      WebElement elementLastName=driver.findElement(By.xpath("//input[@name='lastname']"));
      elementLastName.sendKeys("Shana");
      WebElement elementPhone=driver.findElement(By.xpath("//input[@name='reg_email__']"));
      elementPhone.sendKeys("9999999999");
      WebElement elementPassword=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
      elementPassword.sendKeys("NASingleanaYoungu");
      WebElement elementDate=driver.findElement(By.xpath("//select[@id='day']/option[23]"));
     elementDate.click();
     WebElement elementMonth=driver.findElement(By.xpath("//select[@aria-label='Month']/option[3]"));
     elementMonth.click();
     WebElement elementYear=driver.findElement(By.xpath("//select[@aria-label='Year']/option[@value='1999']"));
     elementYear.click();
     WebElement elementGender=driver.findElement(By.xpath("//input[@name='sex']"));
     elementGender.click();
      
	}
	
}
